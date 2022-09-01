package Part2.Lesson7.server;

import Part2.Lesson7.server.handlers.ClientHandler;
import Part2.Lesson7.server.models.User;
import Part2.Lesson7.server.services.AuthenticationService;
import Part2.Lesson7.server.services.RegistrationService;
import Part2.Lesson7.server.services.impl.SimpleAuthenticationServiceImpl;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyServer {
    public static final Logger logger = Logger.getLogger("MyServer");


    private final ServerSocket serverSocket;
    private final AuthenticationService authenticationService;



    private final RegistrationService registrationService;

    private final ArrayList<ClientHandler> clients;

    public MyServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        authenticationService = new SimpleAuthenticationServiceImpl();
        registrationService = new SimpleAuthenticationServiceImpl();
        clients = new ArrayList<>();
    }


    public void start() {
        logger.log(Level.INFO , "Сервер запущен");
        System.out.println("CЕРВЕР ЗАПУЩЕН!");
        System.out.println("---------------");

        try {
            while (true) {
                waitAndProcessNewClientConnection();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void waitAndProcessNewClientConnection() throws IOException {
        System.out.println("Ожидание клиента...");
        Socket socket = serverSocket.accept();
        System.out.println("Клиент подключился!");

        processClientConnection(socket);
    }

    private void processClientConnection(Socket socket) throws IOException {
        ClientHandler handler = new ClientHandler(this, socket);
        handler.handle();
    }

    public synchronized void subscribe(ClientHandler handler) {

        clients.add(handler);
        User.userList.add(handler.getUsername()+" ");

    }

    public synchronized void unSubscribe(ClientHandler handler) {

        clients.remove(handler);
        User.userList.remove(handler.getUsername()+" ");

    }

    public AuthenticationService getAuthenticationService() {
        return authenticationService;
    }

    public boolean isUsernameBusy(String username) {
        for (ClientHandler client : clients) {
            if (client.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void stop() {
        System.out.println("------------------");
        System.out.println("------------------");
        System.out.println("ЗАВЕРШЕНИЕ РАБОТЫ");
        logger.log(Level.INFO , "Завершение работы");
        System.exit(0);
    }

    public synchronized void broadcastMessage(ClientHandler sender, String message) throws IOException {
        for (ClientHandler client : clients) {
/*            if (client == sender) {
                continue;
            }*/
            client.sendMessage(sender.getUsername(), message);
        }
    }



    public synchronized void sendPrivateMessage(ClientHandler sender, String recipient, String privateMessage) throws IOException {
        for (ClientHandler client : clients) {
            if (client.getUsername().equals(recipient)) {
                client.sendMessage(sender.getUsername(), privateMessage, true);
            }
        }
    }

    public synchronized void broadcastServerMessage(ClientHandler sender, String message) throws IOException {
        for (ClientHandler client : clients) {
            if (client == sender) {
                continue;
            }
            client.sendServerMessage(message);
        }
    }
    public RegistrationService getRegistrationService() {
        return registrationService;
    }
}
