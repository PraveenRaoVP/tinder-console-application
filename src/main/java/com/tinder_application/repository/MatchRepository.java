package com.tinder_application.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinder_application.models.Match;

import java.io.File;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class MatchRepository {
    private static MatchRepository instance;

    private MatchRepository() {
    }

    public static MatchRepository getInstance() {
        if (instance == null) {
            instance = new MatchRepository();
        }
        return instance;
    }

    private Map<Integer, Match> matchesMap = new HashMap<>();

    // json functions
    private String fileNamePath = "./src/main/resources/matches.json";

    public void pushDataToJSON() {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(fileNamePath);
        try {
            objectMapper.writeValue(file, matchesMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pullDataFromJSON() {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(fileNamePath);
        try {
            matchesMap.clear();
            matchesMap.putAll(mapper.readValue(file, new TypeReference<Map<Integer, Match>>() {}));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
