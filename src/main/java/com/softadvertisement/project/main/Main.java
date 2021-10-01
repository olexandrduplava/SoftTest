package com.softadvertisement.project.main;

import com.softadvertisement.project.actions.AdvertisementActions;
import com.softadvertisement.project.actions.CommentActions;
import com.softadvertisement.project.actions.UserActions;
import com.softadvertisement.project.model.Advertisement;
import com.softadvertisement.project.model.User;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args){

        ///////////////////////////////////////////////////////////////////// All users data
//        try {
//            System.out.println(UserActions.getAllUsers());
//        } catch (SQLException | IOException e) {
//            e.printStackTrace();
//        }
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

        ///////////////////////////////////////////////////////////////////// Get Adverd by Id +++++++++
//        try {
//            System.out.println(AdvertisementActions.getAdvertId(1));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
       // System.out.println(AdvertisementActions.getAdvertId(1l));

        ///////////////////////////////////////////////////////////////////// Get Adverds by User id +++++++
//        try {
//            System.out.println(AdvertisementActions.getAdvertsByUserID(3));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        ///////////////////////////////////////////////////////////////////// Get All adverds ++++++++
//        try {
//            System.out.println(AdvertisementActions.getAllAdvert());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

//        ///////////////////////////////////////////////////////////////////// Add Advert +++++++++++++++++++++
//        User user = new User();
//        try {
//            user = UserActions.getUserById(1);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        System.out.println("USER: " + user);
//        Advertisement advertisement = new Advertisement("TITLE","DESCRIBTION", LocalDate.now(),user);
//
//        try {
//            AdvertisementActions.addAdvertisement(advertisement);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        ///////////////////////////////////////////////////////////////////// Update Advert +++++++
//        Advertisement advertisement = new Advertisement("TITLE 2","DESCRIBTION 2");
//
//        try {
//            AdvertisementActions.updateAdvertisement(2,advertisement);
//            System.out.println("UPDATED");
//        } catch (IOException | SQLException | NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }

        ///////////////////////////////////////////////////////////////////// Delete Advert ++++++
//        try {
//            AdvertisementActions.deleteAdvertisement(7);
//            System.out.println("Deleted");
//        } catch (IOException | SQLException e) {
//            e.printStackTrace();
//        }

        ///////////////////////////////////////////////////////////////////// get comId +++++++
//
//        try {
//            System.out.println(CommentActions.getCommId(1));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


        ///////////////////////////////////////////////////////////////////// getCommIdByUser ------
/*Так само виводить правильну кількість но не самі коментраії*/
//        try {
//            System.out.println(CommentActions.getCommByUserID(1));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        ///////////////////////////////////////////////////////////////////// getAllCom ++++++

//        try {
//            System.out.println(CommentActions.getAllComm());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        System.out.println("Hello");
    }
}