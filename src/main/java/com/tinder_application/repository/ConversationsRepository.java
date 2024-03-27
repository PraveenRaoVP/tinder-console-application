package com.tinder_application.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinder_application.models.Message;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConversationsRepository {
    private static ConversationsRepository instance;

    private ConversationsRepository() {
    }

    public static ConversationsRepository getInstance() {
        if (instance == null) {
            instance = new ConversationsRepository();
        }
        return instance;
    }

    private Map<Integer, List<Integer>> chatIdToMessageIds = new HashMap<>();

    public void addMessageIdToChatId(int chatId, int messageId) {
        if (!chatIdToMessageIds.containsKey(chatId)) {
            chatIdToMessageIds.put(chatId, new ArrayList<>());
        }
        chatIdToMessageIds.get(chatId).add(messageId);
    }

    // json methods
    private String fileNamePath = "./src/main/resources/conversations.json";

    public void pushDataToJSON() {
        File file = new File(fileNamePath);
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(file, chatIdToMessageIds);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void pullDataToJSON() {
        File file = new File(fileNamePath);
        ObjectMapper mapper = new ObjectMapper();

        try {
            chatIdToMessageIds.putAll(mapper.readValue(file, new TypeReference<Map<Integer, List<Integer>>>() {}));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
