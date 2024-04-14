package com.tinder_application.operations.preferences_operations;

import com.tinder_application.models.Preferences;
import com.tinder_application.models.User;
import com.tinder_application.models.enums.Genders;
import com.tinder_application.repository.CacheMemory;
import com.tinder_application.repository.PreferencesRepository;
import com.tinder_application.repository.UserRepository;
import com.tinder_application.repository.UserToPreferencesRepository;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PrefOperationsModel {
    private PrefOperationsView prefOperationsView;

    public PrefOperationsModel(PrefOperationsView prefOperationsView) {
        this.prefOperationsView = prefOperationsView;
    }


}
