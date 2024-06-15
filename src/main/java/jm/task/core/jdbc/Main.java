package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        Util.getConnection();
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        List<User> users = userService.getAllUsers();
        users.add(new User("Anar", "Aslanov", (byte)22));
        users.add(new User("Anastasia", "Borovitskay", (byte)22));
        users.add(new User("Andrey", "Ivanov", (byte)25));
        users.add(new User("Ivan", "Ivanov", (byte)21));

        for (User user : users) {
            userService.saveUser(user.getName(), user.getLastName(), user.getAge());
            System.out.println("User с именем – " + user.getName() + " добавлен в базу данных");
        }
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();


    }
}
