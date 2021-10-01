package com.softadvertisement.project.actions;

import com.softadvertisement.project.connect.DBConnecting;
import com.softadvertisement.project.model.Advertisement;
import com.softadvertisement.project.model.User;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AdvertisementActions {

    public static Advertisement getAdvertId(long idAdvert) throws SQLException {
        Advertisement advertisement = new Advertisement();
        User user = new User();
        try (Connection connection = DBConnecting.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT advertisement.*,name FROM advertisement join users on advertisement.user_id = users.id WHERE advertisement.id = ?")){
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

//    public static List<Advertisement> getAdversByUserID(long idUser) throws SQLException {
//        List<Advertisement> advertList = new ArrayList<>();
//        Advertisement advertisement = new Advertisement();
//        User user = new User();
//        try (Connection connection = DBConnecting.getConnection();
//             PreparedStatement statement = connection.prepareStatement(
//                     "SELECT advertisement.*,name FROM advertisement join users on advertisement.user_id = users.id WHERE user_id = ?")){
//            statement.setLong(1,idUser);
//            final ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()){
//                advertisement.setId(resultSet.getLong(1));
//                advertisement.setTitle(resultSet.getString(2));
//                advertisement.setCreatedAt(resultSet.getTimestamp(3).toLocalDateTime().toLocalDate());
//                advertisement.setDescription(resultSet.getString(4));
//                user.setLogin(resultSet.getString("name"));
//                user.setId(resultSet.getLong("user_id"));
//                advertisement.setUser(user);
//                advertList.add(advertisement);
//            }
//        }
//        return advertList;
//    }
    public static List<Advertisement> getAdvertsByUserID(long idUser) throws SQLException {
        List<Advertisement> advertList = new ArrayList<>();

        User user = new User();
        try (Connection connection = DBConnecting.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT advertisement.*,name FROM advertisement join users on advertisement.user_id = users.id WHERE user_id = ?")){
            statement.setLong(1,idUser);
            final ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Advertisement advertisement = new Advertisement();
                advertisement.setId(resultSet.getLong(1));
                advertisement.setTitle(resultSet.getString(2));
                advertisement.setCreatedAt(resultSet.getTimestamp(3).toLocalDateTime().toLocalDate());
                advertisement.setDescription(resultSet.getString(4));
                user.setLogin(resultSet.getString("name"));
                user.setId(resultSet.getLong("user_id"));
                advertisement.setUser(user);
                advertList.add(advertisement);
            }
        }
        return advertList;
    }

    public static List<Advertisement> getAllAdvert() throws SQLException{
        List<Advertisement> advertList = new ArrayList<>();
        User user = new User();
        try (Connection connection = DBConnecting.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT advertisement.*,name FROM advertisement join users on advertisement.user_id = users.id")) {
            final ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Advertisement advertisement = new Advertisement();
                advertisement.setId(resultSet.getLong(1));
                advertisement.setTitle(resultSet.getString(2));
                advertisement.setCreatedAt(resultSet.getTimestamp(3).toLocalDateTime().toLocalDate());
                advertisement.setDescription(resultSet.getString(4));
                user.setLogin(resultSet.getString("name"));
                user.setId(resultSet.getLong("user_id"));
                advertisement.setUser(user);
                advertList.add(advertisement);
            }
        }
        return advertList;
    }

    public static boolean addAdvertisement(@org.jetbrains.annotations.NotNull Advertisement advertisement) throws SQLException{
        User user = new User();
        try (Connection connection = DBConnecting.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO advertisement ( title, created_at ,description ,user_id ) VALUES (?,?,?,?);")){
            preparedStatement.setString(1, advertisement.getTitle());
            //preparedStatement.setTimestamp(2, Timestamp.valueOf(String.valueOf(now))); /*SQL EXCEPTION*/
            preparedStatement.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
            preparedStatement.setString(3, advertisement.getDescription());
            preparedStatement.setLong(4, advertisement.getUser().getId());/*SQL EXCEPTION*/
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("SQL addAdvertisement");
            return false;
        }
    }

    public static boolean updateAdvertisement(long id, Advertisement advertisement) throws IOException, SQLException, NoSuchAlgorithmException {
        try (Connection connection = DBConnecting.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("UPDATE advertisement SET title  = ?, description = ?  WHERE id = ?")) {
            preparedStatement.setString(1, advertisement.getTitle());
            preparedStatement.setString(2, advertisement.getDescription());
            preparedStatement.setLong(3, id);
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
