package com.tinder_application.matches;

import com.tinder_application.models.Match;
import com.tinder_application.repository.CacheMemory;
import com.tinder_application.repository.MatchRepository;

import java.util.List;

public class MatchesModel {
    private MatchesView matchesView;

    public MatchesModel(MatchesView matchesView) {
        this.matchesView = matchesView;
    }

    public List<Match> getAllMatches() {
        int currentUserID = CacheMemory.getInstance().getCurrentUserId();

        return MatchRepository.getInstance().getMatches().stream()
                .filter(match -> match.getUserId1() == currentUserID || match.getUserId2() == currentUserID)
                .toList();
    }
}
