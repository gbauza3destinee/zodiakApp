package com.bloomtech.zodiakProject.ServiceProviders;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.platform.commons.util.StringUtils;

import java.util.regex.Pattern;



// TODO: 5/11 Swastik - How do I import the StringUtils Library into this Class, so these methods become integrated?

@Component
public final class UserGeneratorService {


    private static final Pattern INVALID_CHARACTER_PATTERN = Pattern.compile("[\".'\\\\]");

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






