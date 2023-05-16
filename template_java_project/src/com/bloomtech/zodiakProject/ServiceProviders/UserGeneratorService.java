package com.bloomtech.zodiakProject.ServiceProviders;
import dagger.Component;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.platform.commons.util.StringUtils;

import javax.inject.Inject;
import java.util.regex.Pattern;


public final class UserGeneratorService {


    private static final Pattern INVALID_CHARACTER_PATTERN = Pattern.compile("[\".'*!_\\\\]");

    static final int USER_ID_LENGTH = 5;


    @Inject
    public UserGeneratorService() {
    }

    /**
     * Checks that the provided String contains only valid characters.
     *
     * @param stringToValidate the playlist name to be validated
     * @return true if the String is valid (contains only valid characters),
     * false otherwise
     */
    public static boolean isValidString(final String stringToValidate) {
        if (StringUtils.isBlank(stringToValidate)) {
            return false;
        }

        return !INVALID_CHARACTER_PATTERN.matcher(stringToValidate).find();
    }

    public static String generateUserId() {
        return RandomStringUtils.randomAlphanumeric(USER_ID_LENGTH);
    }
}






