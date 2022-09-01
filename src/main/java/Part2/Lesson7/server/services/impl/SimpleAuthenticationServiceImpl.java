package Part2.Lesson7.server.services.impl;

import Part2.Lesson7.server.RegistrationDataBase;
import Part2.Lesson7.server.models.User;
import Part2.Lesson7.server.services.AuthenticationService;
import Part2.Lesson7.server.services.RegistrationService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;


public class SimpleAuthenticationServiceImpl implements AuthenticationService, RegistrationService {

//    private static List<User> clients = new ArrayList<>(Arrays.asList(
//            new User("Martin", "1", "MartiSuper"),
//            new User("batman", "1", "Bruce"),
//            new User("gena", "1", "Gendalf"),
//            new User("mario", "1", "Super_mario")
//    ));


    @Override
    public String getUserNameByLoginAndPassword(String login, String password) {
//        for (User client : clients) {
//            if (client.getLogin().equals(login) && client.getPassword().equals(password)) {
//                return client.getUsername();
//            }
//        }
//        return null;
        try {
            RegistrationDataBase.connection();
            String rtn = RegistrationDataBase.getUsernameByLoginAndPassword(login, password);
            RegistrationDataBase.disconnection();
            return rtn;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public boolean getUserNameLoginAndPassword(String login, String password, String username) {
//        boolean check=true;
////        for (User client : clients) {
////            if (client.getLogin().equals(login) || client.getUsername().equals(username)) {
////                check =false;
////            }
////        }
//
//
//        if(check){
//            clients.add(new User(login,password,username));
//            System.out.println("Пользователь добавлен");
//            return true;
//        } else System.out.println("Такой пользователь уже существует");
//        return false;
//
//    }
        try {
            RegistrationDataBase.connection();
            RegistrationDataBase.registrationUser(login, password, username);
            RegistrationDataBase.disconnection();
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

