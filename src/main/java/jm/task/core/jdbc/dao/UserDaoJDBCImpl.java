package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    private static final Connection connection = Util.getConnection();

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try (Statement st = connection.createStatement()) {
            st.executeUpdate("CREATE TABLE IF NOT EXISTS users " +
                    "(id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255), last_name VARCHAR(255), age INT)");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

        public void dropUsersTable() {
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate("DROP TABLE IF EXISTS users");
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }

    public void saveUser(String name, String last_name, byte age) {
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO users (name, last_name, age) VALUES (?, ?, ?)")) {
            ps.setString(1, name);
            ps.setString(2, last_name);
            ps.setByte(3,age);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } ;

    }

    public void removeUserById(long id) {
        try (PreparedStatement ps = connection.prepareStatement("DELETE FROM users WHERE id = ?")) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM users")) {
            while (rs.next()) {
                User user = new User(rs.getString("name"), rs.getString("last_name"), rs.getByte("age"));
                user.setId(rs.getLong("id"));
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public void cleanUsersTable() {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("TRUNCATE TABLE users");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
