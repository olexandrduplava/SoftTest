package com.softadvertisement.project.main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.softadvertisement.project.actions.AdvertisementActions;
import com.softadvertisement.project.actions.CommentActions;
import com.softadvertisement.project.actions.UserActions;
import com.softadvertisement.project.model.Advertisement;
import com.softadvertisement.project.model.Comment;
import com.softadvertisement.project.model.User;
import com.softadvertisement.project.serialize.DeserializeObject;
import com.softadvertisement.project.serialize.SerializeObject;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {


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

        ///////////////////////////////////////////////////////////////////// Get Advert by Id +++++++++
//        try {
//            System.out.println(AdvertisementActions.getAdvertId(1));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        // System.out.println(AdvertisementActions.getAdvertId(1l));

        ///////////////////////////////////////////////////////////////////// Get Adverts by User id +++++++
//        try {
//            System.out.println(AdvertisementActions.getAdvertsByUserID(3));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        ///////////////////////////////////////////////////////////////////// Get All adverts ++++++++
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
//        Advertisement advertisement = new Advertisement("TITLE","DESCRIPTION", LocalDate.now(),user);
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


        ///////////////////////////////////////////////////////////////////// getCommIdByUser ++++++
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

        ///////////////////////////////////////////////////////////////// Add Comm ++++++++
//        User user = new User();
//        try {
//            user = UserActions.getUserById(1);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        Advertisement advertisement = new Advertisement();
//        try {
//            advertisement = AdvertisementActions.getAdvertId(1);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        Comment comment = new Comment(user,advertisement,"TEST TEXT COMMENT",LocalDate.now());
//        try {
//            CommentActions.addComment(comment);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("/////////////////////////////////////////////////");
//
//        try {
//            System.out.println(CommentActions.getAllComm());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        ///////////////////////////////////////////////////////////////////// Update Comm +++++

//        Comment comment = new Comment("UPDATED COMMENT");
//        try {
//            System.out.println(CommentActions.updateComment(6,comment));
//        } catch (SQLException | IOException | NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            System.out.println(CommentActions.getAllComm());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        /////////////////////////////////////////////////////////////////// Delete Comm +++++

//        try {
//            System.out.println(CommentActions.deleteComment(6));
//        } catch (IOException | SQLException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            System.out.println(CommentActions.getAllComm());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        /////////////////////////////////////////////////////////////////// Serialize +++++++

//        List<User> userList = new ArrayList<>();
//
//        try {
//            userList = (UserActions.getAllUsers());
//        } catch (SQLException | IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(userList);
//        System.out.println("//////////////////////////////////");
//
//        String text = "";
//        try {
//            text = SerializeObject.SerializeListUsers(userList);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//
//        SerializeObject.JsonToFile(text);
////
//        User user = new User("LOGIN", "PASSWORD");
//        GsonBuilder builder = new GsonBuilder();
//        Gson gson = builder.create();
//        System.out.println((gson.toJson(user)));

//        ObjectMapper mapper = new ObjectMapper();
//        String json = "";
//        try {
//            json = mapper.writeValueAsString(user);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        System.out.println(json);

//        String jsonlist = null;
//        try {
//            jsonlist = mapper.writeValueAsString(userList);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        System.out.println(jsonlist);

        ///////////////////////////Serialize cherez class

//        User user = new User("LOGIN", "PASSWORD");
//        Advertisement advertisement = new Advertisement("test","1234");
//        String test="";
//
//        try {
//           test = SerializeObject.SerializeUser(user);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(test);
        ///////////////////////////////////DESERIALIZE cherez file

//        User user = new User();
//
//        List<User> testList = new ArrayList<>();
//
//
//        File file = new File("C:/Users/Alexandr/IdeaProjects/SoftGradle/src/Json/json.txt");
//        String test = DeserializeObject.FileToJson(file);
//        System.out.println("File to Json: " + test);
//        try {
//            testList = DeserializeObject.DeserializeListUser(test);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(testList);
//
//        System.out.println("User: " + user);
        ///////////////////////////////////////////////////////Prosto deserialize
//        User user2 = new User();
//        try {
//            user2 = DeserializeObject.DeserializeUser(test);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("user 2: " + user2);


        User user = new User();
        File filetest = new File("C:/Users/Alexandr/IdeaProjects/SoftGradle/src/Json/jsonObject.json");
        try {
            user = DeserializeObject.FileToUser(filetest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(user);


        ///////////////////////////////////////////////////////////////// PROBEM ZAPIS V FILE +++++
//        SerializeObject.JsonToFile(test);


        System.out.println("Hello");
    }
}