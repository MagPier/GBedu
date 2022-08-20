package Part2.Lesson7.server.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;

@Data
public class User {
    public static ArrayList<String> userList = new ArrayList<String>();

    private final String login;
    private final String password;
    private final String username;

}
