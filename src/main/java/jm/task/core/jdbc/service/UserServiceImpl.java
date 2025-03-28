package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserDao ud = new UserDaoJDBCImpl();
    public void createUsersTable() {
        ud.createUsersTable();

    }

    public void dropUsersTable() {
        ud.dropUsersTable();

    }

    public void saveUser(String name, String lastName, byte age) {
        ud.saveUser(name,lastName,age);
        System.out.println("User с именем – " + name + " добавлен в базу данных");

    }

    public void removeUserById(long id) {
        ud.removeUserById(id);

    }

    public List<User> getAllUsers() {
        List <User> users = ud.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }
        return users;
    }


    public void cleanUsersTable() {
        ud.cleanUsersTable();

    }
}
