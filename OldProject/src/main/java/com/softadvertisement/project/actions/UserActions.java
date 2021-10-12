package com.softadvertisement.project.actions;

import com.softadvertisement.project.connect.DBConnecting;
import com.softadvertisement.project.model.User;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserActions {

    public static User getUserById(long idUser) throws SQLException {
    User user = new User();
        try (Connection connection = DBConnecting.getConnection(); PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE id = ?")){
            statement.setLong(1, idUser);
            final ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user.setId(resultSet.getLong(1));
                user.setLogin(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
            }
        }
        return user;
    }


    public static List<User> getAllUsers() throws SQLException, IOException {
        List<User> userList = new ArrayList<>();
        try (Connection connection = DBConnecting.getConnection(); PreparedStatement statement = connection.prepareStatement("SELECT * FROM users")) {
            final ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong(1));
                user.setLogin(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                userList.add(user);
            }

        }
        return userList;
    }

    public static boolean addUser(User user) throws IOException, SQLException, NoSuchAlgorithmException {
        try (Connection connection = DBConnecting.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users  (name , password ) VALUES (?,?);")) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static boolean updateUser(long id, User user) throws IOException, SQLException, NoSuchAlgorithmException {
        try (Connection connection = DBConnecting.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET name  = ?  WHERE id = ?;")) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static boolean deleteUser(long idDelete) throws IOException, SQLException {
        Connection connection = DBConnecting.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement("delete from users WHERE Id=?")) {
            preparedStatement.setLong(1,idDelete);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

}
