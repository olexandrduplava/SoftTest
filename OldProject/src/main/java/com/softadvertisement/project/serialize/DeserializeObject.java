package com.softadvertisement.project.serialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.softadvertisement.project.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DeserializeObject {

    public static User DeserializeUser(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
//        User user = mapper.readValue(json, User.class);
//        return user;
        return mapper.readValue(json, User.class);
    }
    public static List<User> DeserializeListUser(String json) throws JsonProcessingException {
        List<User> userList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(json, User.class);
        userList.add(user);
        return userList;
//        return user;
 //       return mapper.readValue(json, User.class);
    }

    public static User FileToUser(File file) throws IOException {
//        String text = "";
//        try (FileReader reader = new FileReader(file)){
//            int c;
//            while ((c=reader.read())!=-1){
//                text += (char)c;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return text;
        /////////////////////////////////////////////
        File JsonFile = new File("C:/Users/Alexandr/IdeaProjects/SoftGradle/src/Json/jsonObject.json");
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(JsonFile,User.class);
        return user;
    }

}
