package com.softadvertisement.project.serialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.softadvertisement.project.model.User;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SerializeObject {

    public static String SerializeUser(User user) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json;
        json = mapper.writeValueAsString(user);
        return json;
    }

    public static String SerializeListUsers (List<User> userList) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json;
        json = mapper.writeValueAsString(userList);
        return json;
    }

    public static void JsonToFile(String text){
        try ( FileWriter writer = new FileWriter("C:/Users/Alexandr/IdeaProjects/SoftGradle/src/Json/jsonObject.json")){
           writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
