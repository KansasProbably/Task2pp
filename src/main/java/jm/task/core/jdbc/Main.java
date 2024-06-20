package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {

        UserService us = new UserServiceImpl();

        us.createUsersTable();

        us.saveUser("Name1", "LastName1", (byte) 20);
        us.saveUser("Name2", "LastName2", (byte) 25);
        us.saveUser("Name3", "LastName3", (byte) 31);
        us.saveUser("Name4", "LastName4", (byte) 38);

        us.removeUserById(2);
        us.getAllUsers();
        us.cleanUsersTable();
        us.dropUsersTable();

    }
}
