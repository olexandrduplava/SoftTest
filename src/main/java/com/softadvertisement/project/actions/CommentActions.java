package com.softadvertisement.project.actions;

import com.softadvertisement.project.connect.DBConnecting;
import com.softadvertisement.project.model.Advertisement;
import com.softadvertisement.project.model.Comment;
import com.softadvertisement.project.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        Comment comment = new Comment();
        Advertisement advertisement = new Advertisement();
        User user = new User();
        try (Connection connection = DBConnecting.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT comments.*,advertisement.title, users.name FROM comments join advertisement on comments.adv_id = advertisement.id join users on comments.user_id = users.id WHERE users.id = ?")){
            statement.setLong(1,idUser);
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
                commentList.add(comment);
            }
        }
        return commentList;
    }
//

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

}
