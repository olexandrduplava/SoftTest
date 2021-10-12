package com.softadvertisement.project.actions;

import com.softadvertisement.project.connect.DBConnecting;
import com.softadvertisement.project.model.Advertisement;
import com.softadvertisement.project.model.Comment;
import com.softadvertisement.project.model.User;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CommentActions {

    public static Comment getCommId(long idComm) throws SQLException {
        Comment comment = new Comment();
        Advertisement advertisement = new Advertisement();
        User user = new User();
        try (Connection connection = DBConnecting.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT comments.*,users.name,advertisement.title FROM comments join users on comments.user_id = users.id join advertisement on comments.adv_id = advertisement.id WHERE comments.id = ?")){
            statement.setLong(1,idComm);
            final ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                comment.setId(resultSet.getLong(1));
                comment.setCreatedAt(resultSet.getTimestamp(2).toLocalDateTime().toLocalDate());
                comment.setText(resultSet.getString(3));
                user.setLogin(resultSet.getString("name"));
                user.setId(resultSet.getLong("user_id"));
                comment.setUser(user);
                advertisement.setId(resultSet.getLong("id"));
                advertisement.setTitle(resultSet.getString("title"));
                comment.setAdvertisement(advertisement);
            }
        }
        return comment;
    }

    public static List<Comment> getCommByUserID(long idUser) throws SQLException {
        List<Comment> commentList = new ArrayList<>();
        User user = new User();
        try (Connection connection = DBConnecting.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT comments.*,advertisement.title, users.name FROM comments join advertisement on comments.adv_id = advertisement.id join users on comments.user_id = users.id WHERE users.id = ?")){
            statement.setLong(1,idUser);
            final ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Advertisement advertisement = new Advertisement();
                Comment comment = new Comment();
                comment.setId(resultSet.getLong(1));
                comment.setCreatedAt(resultSet.getTimestamp(2).toLocalDateTime().toLocalDate());
                comment.setText(resultSet.getString(3));
                user.setLogin(resultSet.getString("name"));
                user.setId(resultSet.getLong("user_id"));
                comment.setUser(user);
                advertisement.setId(resultSet.getLong("id"));
                advertisement.setTitle(resultSet.getString("title"));
                comment.setAdvertisement(advertisement);
                commentList.add(comment);
            }
        }
        return commentList;
    }

    public static List<Comment> getAllComm() throws SQLException {
        List<Comment> commentsList = new ArrayList<>();
        User user = new User();
        Advertisement advertisement = new Advertisement();
        try (Connection connection = DBConnecting.getConnection(); PreparedStatement statement = connection.prepareStatement("SELECT comments.*,users.name,advertisement.title FROM comments join users on comments.user_id = users.id join advertisement on comments.adv_id = advertisement.id")) {
            final ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Comment comment = new Comment();
                comment.setId(resultSet.getLong(1));
                comment.setCreatedAt(resultSet.getTimestamp(2).toLocalDateTime().toLocalDate());
                comment.setText(resultSet.getString(3));
                user.setLogin(resultSet.getString("name"));
                user.setId(resultSet.getLong("user_id"));
                comment.setUser(user);
                advertisement.setId(resultSet.getLong("id"));
                advertisement.setTitle(resultSet.getString("title"));
                comment.setAdvertisement(advertisement);
                commentsList.add(comment);
            }
        }
        return commentsList;
    }

    public static boolean addComment(@org.jetbrains.annotations.NotNull Comment comment) throws SQLException{
        User user = new User();
        try (Connection connection = DBConnecting.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO comments (created_at ,text ,user_id, adv_id ) VALUES (?,?,?,?);")){
            preparedStatement.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
            preparedStatement.setString(2, comment.getText());
            preparedStatement.setLong(3, comment.getUser().getId());
            preparedStatement.setLong(4, comment.getAdvertisement().getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("SQL addAdvertisement");
            return false;
        }
    }

    public static boolean updateComment(long id, Comment comment) throws IOException, SQLException, NoSuchAlgorithmException {
        try (Connection connection = DBConnecting.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("UPDATE comments SET text  = ?  WHERE id = ?")) {
            preparedStatement.setString(1, comment.getText());
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static boolean deleteComment(long idDelete) throws IOException, SQLException {
        Connection connection = DBConnecting.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement("delete from comments WHERE Id=?")) {
            preparedStatement.setLong(1,idDelete);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

}
