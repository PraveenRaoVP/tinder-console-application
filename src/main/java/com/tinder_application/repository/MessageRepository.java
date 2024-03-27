package com.tinder_application.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinder_application.models.Message;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class MessageRepository {
    private static MessageRepository instance;

    private MessageRepository() {
    }

    public static MessageRepository getInstance() {
        if (instance == null) {
            instance = new MessageRepository();
        }
        return instance;
    }

    private Map<Integer, Message> messages = new HashMap<>();


    // json methods
    private String fileNamePath = "./src/main/resources/messages.json";

    public void pushDataToJSON() {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(fileNamePath);
        try {
            mapper.writeValue(file, messages);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void pullDataFromJSON() {
        File file = new File(fileNamePath);
        ObjectMapper mapper = new ObjectMapper();
        try {
            messages.putAll(mapper.readValue(file, new TypeReference<Map<Integer, Message>>() {}));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
