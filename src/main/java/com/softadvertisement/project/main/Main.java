package com.softadvertisement.project.main;

import com.softadvertisement.project.actions.AdvertisementActions;
import com.softadvertisement.project.actions.UserActions;
import com.softadvertisement.project.model.User;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) {

        ///////////////////////////////////////////////////////////////////// All users data
        try {
            System.out.println(UserActions.getAllUsers());
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        /////////

        ///////////////////////////////////////////////////////////////////// Get back user id 1
//        try {
//            System.out.println(UserActions.getUserById(1L));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        ////////

//        ///////////////////////////////////////////////////////////////////// New user
//        //User user = new User(5,"wqewqe","wqewqe");
//        User user = new User("testUser","TestPassword");
//
//        try {
//            UserActions.addUser(user);
//        } catch (IOException | SQLException | NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//
////        try {
////            System.out.println(UserActions.getUserById(5L));
////        } catch (SQLException e) {
////            e.printStackTrace();
////        }

//        ///////////////////////////////////////////////////////////////////// Update user
//        User user = new User(5,"bla bla");
//        try {
//            UserActions.updateUser(5,user);
//        } catch (IOException | SQLException | NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//        try {
//            System.out.println(UserActions.getAllUsers());
//        } catch (SQLException | IOException e) {
//            e.printStackTrace();
//        }
        ///////////////////////////////////////////////////////////////////// Delete user
//        try {
//            UserActions.deleteUser(5);
//            System.out.println("Deleted");
//        } catch (IOException | SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            System.out.println(UserActions.getAllUsers());
//        } catch (SQLException | IOException e) {
//            e.printStackTrace();
//        }

        try {
            AdvertisementActions.getAdvertId(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Hello");
    }
}