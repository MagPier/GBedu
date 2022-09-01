package Part2.Lesson7.server;


import java.sql.*;

public class RegistrationDataBase {

    private static Connection connection;
    private static Statement statement;




    public static void connection() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/db/mainDB.db");
        statement = connection.createStatement();

    }

    public static void disconnection() throws SQLException {
        connection.close();
    }



    public static String getUsernameByLoginAndPassword(String login, String password) throws SQLException {
      //  PreparedStatement preparedStatement = connection.prepareStatement(String.format("SELECT * from auth WHERE login = '%s'", login));
        ResultSet rs = statement.executeQuery(String.format("SELECT * from auth WHERE login = '%s'", login));
        if (rs.isClosed()) {
            return null;
        }

        String usernameDB = rs.getString("username");
        String passwordDB = rs.getString("password");

        if (passwordDB.equals(password)) {
            return usernameDB;
        } else return null;
    }

    public static void registrationUser(String login, String password,String username) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO auth (login,password,username) VALUES (?,?,?)");
        connection.setAutoCommit(false);
        if (login != null && password != null && username!= null) {
        preparedStatement.setString(1,login);
        preparedStatement.setString(2,password);
        preparedStatement.setString(3,username);

        preparedStatement.addBatch();
        preparedStatement.executeBatch() ;
        connection.setAutoCommit(true);

        }
    }
}
