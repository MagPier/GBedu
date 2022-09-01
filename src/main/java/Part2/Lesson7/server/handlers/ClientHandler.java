package Part2.Lesson7.server.handlers;
import org.apache.commons.io.input.ReversedLinesFileReader;


import Part2.Lesson7.server.MyServer;
import Part2.Lesson7.server.models.User;
import Part2.Lesson7.server.services.AuthenticationService;
import Part2.Lesson7.server.services.RegistrationService;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import static Part2.Lesson7.server.MyServer.logger;

public class ClientHandler {
    private static final String AUTH_CMD_PREFIX = "/auth"; // + login + password
    private static final String AUTHOK_CMD_PREFIX = "/authok"; // + username
    private static final String AUTHERR_CMD_PREFIX = "/autherr"; // + error message
    private static final String CLIENT_MSG_CMD_PREFIX = "/cMsg"; // + msg
    private static final String SERVER_MSG_CMD_PREFIX = "/sMsg"; // + msg
    private static final String PRIVATE_MSG_CMD_PREFIX = "/pm"; // + username + msg
    private static final String STOP_SERVER_CMD_PREFIX = "/stop";
    private static final String END_CLIENT_CMD_PREFIX = "/end";
    private static final String LOGIN_CMD_PREFIX = "/in";
    private static final String LOGOUT_CMD_PREFIX = "/out";
    private static final String REG_CMD_PREFIX = "/reg";
    private MyServer myServer;
    private Socket clientSocket;
    private DataInputStream in;
    private DataOutputStream out;
    private String username;
    private File libDir = new File("src/main/resources/History.txt");

    public ClientHandler(MyServer myServer, Socket socket) {

        this.myServer = myServer;
        clientSocket = socket;
    }


    public void handle() throws IOException {
        in = new DataInputStream(clientSocket.getInputStream());
//        ObjectInputStream inobj = new ObjectInputStream(clientSocket.getInputStream());
//        inobj.readObject();
        out = new DataOutputStream(clientSocket.getOutputStream());

        new Thread(() -> {
            try {
                authentication();
                registration();
                readMessage();
            } catch (IOException e) {
                try {
                    String s = User.userList.toString();
                    out.writeUTF(LOGIN_CMD_PREFIX + " " + User.userList.toString().replaceAll("^\\[|\\]$", ""));
                    myServer.broadcastServerMessage(this, "Пользователь " + username + " отключился от чата");
                    myServer.broadcastServerMessage(this, s);

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                myServer.unSubscribe(this);

                e.printStackTrace();
            }
        }).start();
    }

    private void authentication() throws IOException {
        while (true) {
            String message = in.readUTF();

            if (message.startsWith(AUTH_CMD_PREFIX)) {
                boolean isSuccessAuth = processAuthentication(message);
                if (isSuccessAuth) {
                    break;
                }

            }
            if (message.startsWith(REG_CMD_PREFIX)) {
                boolean isSuccessAuth = processRegistration(message);
                if (isSuccessAuth) {
                    break;
                } else {
                    logger.log(Level.WARNING , "1Неверная команда аутентификации");
                    out.writeUTF(AUTHERR_CMD_PREFIX + " 1Неверная команда аутентификации");
                    System.out.println("1Неверная команда аутентификации");
                }

            }
        }
    }

    private void registration() throws IOException {
        while (true) {
            String message = in.readUTF();

            if (message.startsWith(REG_CMD_PREFIX)) {
                boolean isSuccessAuth = processRegistration(message);
                if (isSuccessAuth) {
                    break;
                }
            } else {
                out.writeUTF(AUTHERR_CMD_PREFIX + " Неверная команда аутентификации");
                logger.log(Level.WARNING , "2Неверная команда аутентификации");
                System.out.println("2Неверная команда аутентификации");
                break;
            }

        }
    }

    private boolean processRegistration(String message) throws IOException {
        String[] parts = message.split("\\s+");
        if (parts.length != 4) {
            out.writeUTF(AUTHERR_CMD_PREFIX + " Неверная команда аутентификации");
            logger.log(Level.WARNING , "3Неверная команда аутентификации");
            System.out.println("3Неверная команда аутентификации");
            return false;
        }

        String login = parts[1];
        String password = parts[2];
        String username = parts[3];
        boolean regsuccses;

        RegistrationService reg = myServer.getRegistrationService();

        regsuccses = reg.getUserNameLoginAndPassword(login, password, username);

        if (!regsuccses) {
            if (myServer.isUsernameBusy(username)) {
                out.writeUTF(AUTHERR_CMD_PREFIX + " Логин уже используется");
                return false;
            }
            return true;
        } else {
            out.writeUTF(AUTHERR_CMD_PREFIX + " 1Неверная комбинация логина и пароля");
            return false;
        }
    }

    private boolean processAuthentication(String message) throws IOException {
        String[] parts = message.split("\\s+");
        if (parts.length != 3) {
            out.writeUTF(AUTHERR_CMD_PREFIX + " Неверная команда аутентификации");
            System.out.println("4Неверная команда аутентификации");
            return false;
        }

        String login = parts[1];
        String password = parts[2];

        AuthenticationService auth = myServer.getAuthenticationService();

        username = auth.getUserNameByLoginAndPassword(login, password);

        if (username != null) {
            if (myServer.isUsernameBusy(username)) {
                out.writeUTF(AUTHERR_CMD_PREFIX + " Логин уже используется");
                return false;
            }

            out.writeUTF(AUTHOK_CMD_PREFIX + " " + username);
            myServer.subscribe(this);
            System.out.println("Пользователь " + username + " подключился к чату");
            out.writeUTF(LOGIN_CMD_PREFIX + " " + User.userList.toString().replaceAll("^\\[|\\]$", ""));

            myServer.broadcastServerMessage(this, "Пользователь " + username + " подключился к чату");
            myServer.broadcastServerMessage(this, User.userList.toString());
            for (String s:readLastLine(libDir,100)){
                sendMessage(s.split("\\|")[0],s.split("\\|")[1]);
            }



            return true;
        } else {
            out.writeUTF(AUTHERR_CMD_PREFIX + " 5Неверная комбинация логина и пароля");
            return false;
        }
    }

    private void readMessage() throws IOException {
        while (true) {
            String message = in.readUTF();

            System.out.println("message | " + username + ": " + message);

            String typeMessage = message.split("\\s+")[0];
            if (!typeMessage.startsWith("/")) {
                System.out.println("Неверный запрос");
            }


            switch (typeMessage) {
                case STOP_SERVER_CMD_PREFIX:
                    myServer.stop();
                    break;
//                case REG_CMD_PREFIX:
//                    processRegistration(typeMessage);
//                    break;
                case END_CLIENT_CMD_PREFIX:
                    closeConnection();
                    break;
                case CLIENT_MSG_CMD_PREFIX:
                    String[] messageParts = message.split("\\s+", 2);
                    myServer.broadcastMessage(this, messageParts[1]);
                    break;
                case PRIVATE_MSG_CMD_PREFIX:
                    String[] privateMessageParts = message.split("\\s+", 3);
                    String recipient = privateMessageParts[1];
                    String privateMessage = privateMessageParts[2];
                    myServer.sendPrivateMessage(this, recipient, privateMessage);
                    break;
                default:
                    logger.log(Level.INFO , "1Неверная команда "+message);
                    System.out.println("1Неверная команда");
                    break;
            }

        }
    }

    private void closeConnection() throws IOException {
        clientSocket.close();
        System.out.println(username + " отключился");
    }

    public void sendServerMessage(String message) throws IOException {
        out.writeUTF(String.format("%s %s", SERVER_MSG_CMD_PREFIX, message));
    }

    public void sendMessage(String sender, String message, Boolean isPrivate) throws IOException {
        out.writeUTF(String.format("%s %s %s", isPrivate ?
                        PRIVATE_MSG_CMD_PREFIX
                        : CLIENT_MSG_CMD_PREFIX,
                sender, message));
    }

    public void sendMessage(String sender, String message) throws IOException {
        sendMessage(sender, message, false);
        writeToFile(sender,message);
    }

    public String getUsername() {
        return username;
    }

    private void writeToFile(String sender,String message) {
        String messageToHistory = sender+"||"+message+"\n";
        try (FileOutputStream fileOutputStream = new FileOutputStream(libDir, true)) {
            fileOutputStream.write(messageToHistory.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<String> readLastLine(File file, int numLastLineToRead) {

        List<String> result = new ArrayList<>();

        try (ReversedLinesFileReader reader = new ReversedLinesFileReader(file, StandardCharsets.UTF_8)) {

            String line = "";
            while ((line = reader.readLine()) != null && result.size() < numLastLineToRead) {
                result.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;

    }
}

