package com.softadvertisement.project.actions;

import com.softadvertisement.project.connect.DBConnecting;
import com.softadvertisement.project.model.Advertisement;
import com.softadvertisement.project.model.User;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdvertisementActions {

    public static Advertisement getAdvertId(long idAdvert) throws SQLException {
        Advertisement advertisement = new Advertisement();
        User user = new User();
        try (Connection connection = DBConnecting.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT advertisement.*,name FROM advertisement join users on advertisement.user_id = users.id WHERE advertisement.id = ?")){
            statement.setLong(1,idAdvert);
            final ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                advertisement.setId(resultSet.getLong(1));
                advertisement.setTitle(resultSet.getString(2));
                advertisement.setCreatedAt(resultSet.getTimestamp(3).toLocalDateTime().toLocalDate());
                advertisement.setDescription(resultSet.getString(4));
                user.setLogin(resultSet.getString("name"));
                user.setId(resultSet.getLong("user_id"));
                advertisement.setUser(user);
            }
        }
        return advertisement;
    }

    public static List<Advertisement> getAllAdvert() throws SQLException, IOException {
        List<Advertisement> advertList = new ArrayList<>();
        try (Connection connection = DBConnecting.getConnection(); PreparedStatement statement = connection.prepareStatement("SELECT advertisement.*,name FROM advertisement join users on advertisement.user_id = users.id")) {
            final ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Advertisement advertisement = new Advertisement();
                advertisement.setId(resultSet.getLong(1));
                advertisement.setTitle(resultSet.getString(2));
                advertisement.setCreatedAt(resultSet.getTimestamp(3).toLocalDateTime().toLocalDate());
                advertisement.setDescription(resultSet.getString(4));
               // advertisement.setUser(resultSet.getObject(5));
                advertList.add(advertisement);
            }
        }
        return advertList;
    }


    public static boolean addAdvertisement(Advertisement advertisement) throws IOException, SQLException, NoSuchAlgorithmException {
        try (Connection connection = DBConnecting.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO advertisement  (title , description, user_id ) VALUES (?,?,?);")) {
            preparedStatement.setString(1, advertisement.getTitle());
            preparedStatement.setString(2, advertisement.getDescription());
            //preparedStatement.setString(3, advertisement.getUser());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static boolean updateAdvertisement(long id, Advertisement advertisement) throws IOException, SQLException, NoSuchAlgorithmException {
        try (Connection connection = DBConnecting.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("UPDATE advertisement SET title  = ?, description = ?  WHERE id = ?;")) {
            preparedStatement.setString(1, advertisement.getTitle());
            preparedStatement.setString(2, advertisement.getDescription());
            preparedStatement.setLong(3, advertisement.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static boolean deleteAdvertisement(long idDelete) throws IOException, SQLException {
        Connection connection = DBConnecting.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement("delete from advertisement WHERE Id=?")) {
            preparedStatement.setLong(1,idDelete);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }


}
