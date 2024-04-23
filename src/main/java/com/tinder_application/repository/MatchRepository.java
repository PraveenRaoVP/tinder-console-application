package com.tinder_application.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinder_application.models.Match;

import java.io.File;
import java.util.HashMap;
import java.util.List;
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
    private Map<Integer, Map<Integer,Integer>> dislikesMap = new HashMap<>();

    // json functions
    private String fileNamePath = "./src/main/resources/matches.json";
    private String dislikesFileNamePath = "./src/main/resources/dislikes.json";

    public void pushDataToJSON() {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(fileNamePath);
        File file2 = new File(dislikesFileNamePath);
        try {
            objectMapper.writeValue(file, matchesMap);
            objectMapper.writeValue(file2, dislikesMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pullDataFromJSON() {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(fileNamePath);
        File file2 = new File(dislikesFileNamePath);
        try {
            matchesMap.clear();
            matchesMap.putAll(mapper.readValue(file, new TypeReference<Map<Integer, Match>>() {}));
            dislikesMap.clear();
            dislikesMap.putAll(mapper.readValue(file2, new TypeReference<Map<Integer, Map<Integer,Integer>>>() {}));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public boolean checkIfMatched(int userId1, int userId2) {
        for (Match match : matchesMap.values()) {
            if ((match.getUserId1() == userId1 && match.getUserId2() == userId2) || (match.getUserId1() == userId2 && match.getUserId2() == userId1)) {
                if(match.isMatched()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void addMatch(int userId1, int userId2) {
        int matchId = matchesMap.size() + 1;
        Match match = new Match(matchId, userId1, userId2, false);
        matchesMap.put(matchId, match);
    }

    public void updateMatch(int matchId) {
        Match match = matchesMap.get(matchId);
        match.setMatched(true);
        matchesMap.put(matchId, match);
    }

    public int checkIfMatchRecordExistsAndMatchDidntHappen(int userId1, int userId2) {
        for (Match match : matchesMap.values()) {
            if ((match.getUserId1() == userId1 && match.getUserId2() == userId2) || (match.getUserId1() == userId2 && match.getUserId2() == userId1)) {
                if(!match.isMatched()) {
                    return match.getMatchId();
                }
                if(match.isMatched()) {
                    return Integer.MIN_VALUE;
                }
            }
        }
        return -1;
    }

    public boolean checkIfDisliked(int userId1,int userId2) {
        return false;
    }

    public List<Match> getMatches() {
        return List.copyOf(matchesMap.values());
    }


}
