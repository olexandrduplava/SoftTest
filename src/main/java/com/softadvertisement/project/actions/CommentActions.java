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
        try (Connection connection = DBConnecting.getConnection(); PreparedStatement statement = connection.prepareStatement("SELECT * FROM comments WHERE id = ?")){
            statement.setLong(1,idComm);
            final ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                comment.setId(resultSet.getLong(1));
                //comment.setCreatedAt(resultSet.getDate(2));
                comment.setText(resultSet.getString(3));
                //comment.setUser(resultSet.getObject(4));
                //comment.setAdvertisement(resultSet.getObject(5));
            }
        }
        return comment;
    }

    public static List<Comment> getAllComm() throws SQLException {
        List<Comment> commentsList = new ArrayList<>();
        try (Connection connection = DBConnecting.getConnection(); PreparedStatement statement = connection.prepareStatement("SELECT * FROM users")) {
            final ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Comment comment = new Comment();
                comment.setId(resultSet.getLong(1));
                //comment.setCreatedAt(resultSet.getDate(2));
                comment.setText(resultSet.getString(3));
               // comment.setUser(resultSet.getObject(4));
                //comment.setAdvertisement(resultSet.getObject(5));
                commentsList.add(comment);
            }
        }
        return commentsList;
    }

}
