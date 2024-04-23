package com.tinder_application.matches;

import com.tinder_application.models.Match;
import com.tinder_application.models.User;
import com.tinder_application.repository.CacheMemory;
import com.tinder_application.repository.UserRepository;

import java.util.List;

public class MatchesView {
    private MatchesModel matchesModel;

    public MatchesView() {
        matchesModel = new MatchesModel(this);
    }

    public void showMatches() {
        List<Match> matches = matchesModel.getAllMatches();
        if(matches.isEmpty()) {
            System.out.println("No matches yet!");
        } else {
            System.out.println("Your matches:");
            int index = 1;
            for (Match match : matches) {
                if(match.getUserId1() == CacheMemory.getInstance().getCurrentUserId()) {
                    User user = UserRepository.getInstance().getUserById(match.getUserId2());
                    System.out.println(index++ + ". " + user.getUserName());
                } else {
                    User user = UserRepository.getInstance().getUserById(match.getUserId1());
                    System.out.println(index++ + ". " + user.getUserName());
                }
            }
        }
    }
}
