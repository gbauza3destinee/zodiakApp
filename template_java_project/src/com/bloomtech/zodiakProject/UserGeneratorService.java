package com.bloomtech.zodiakProject;

import org.junit.platform.commons.util.StringUtils;

import java.util.regex.Pattern;

public final class UserGeneratorService {

    private static final Pattern INVALID_CHARACTER_PATTERN = Pattern.compile("[\".'\\\\]");

    // TODO: 4/27 Adjust My Invalid Pattern to take no ** / or ' and ; signs


    // package private for testing
    static final int USER_ID_LENGTH = 5;

    // do not instantiate
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






