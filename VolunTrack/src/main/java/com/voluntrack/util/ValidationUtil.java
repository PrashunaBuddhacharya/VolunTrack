package com.voluntrack.util;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class ValidationUtil {

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
        "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$"
    );

    private static final Pattern PHONE_PATTERN = Pattern.compile("^98\\d{8}$");

    private static final Pattern PASSWORD_PATTERN = Pattern.compile(
        "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$"
    );

    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[A-Za-z][A-Za-z0-9]*$");

    private static final Pattern ALPHABETIC_PATTERN = Pattern.compile("^[a-zA-Z]+$");

    private static final List<String> VALID_GENDERS = Arrays.asList(
        "male", "female", "nonbinary", "other", "prefer-not"
    );

    private static final List<String> VALID_INTERESTS = Arrays.asList(
        "education", "health", "environment", "animal", "community", "disaster", "arts"
    );

    // Check if a string is null or empty.
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    // Validate email format.
    public static boolean isValidEmail(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }

    // Validate Nepali phone number (starts with 98 and has 10 digits).
    public static boolean isValidPhoneNumber(String phone) {
        return phone != null && PHONE_PATTERN.matcher(phone).matches();
    }

    // Validate password (at least 8 characters, 1 uppercase, 1 number, 1 symbol).
    public static boolean isValidPassword(String password) {
        return password != null && PASSWORD_PATTERN.matcher(password).matches();
    }

    // Check if two passwords match.
    public static boolean doPasswordsMatch(String password, String confirmPassword) {
        return password != null && password.equals(confirmPassword);
    }

    // Username must start with a letter and contain only letters and numbers.
    public static boolean isAlphanumericStartingWithLetter(String username) {
        return username != null && USERNAME_PATTERN.matcher(username).matches();
    }

    // Validate full name (contains only letters, ignoring spaces).
    public static boolean isAlphabetic(String value) {
        if (value == null) return false;
        return ALPHABETIC_PATTERN.matcher(value.replaceAll("\\s", "")).matches();
    }

    // Validate gender (must be one of the allowed options).
    public static boolean isValidGender(String gender) {
        return gender != null && VALID_GENDERS.contains(gender.toLowerCase());
    }

    // Validate interest (must be one of the allowed options).
    public static boolean isValidInterest(String interest) {
        return interest != null && VALID_INTERESTS.contains(interest.toLowerCase());
    }

    // Validate age (must be at least 16).
    public static boolean isAgeAtLeast16(int age) {
        return age >= 16;
    } 

    // Validate age based on LocalDate of birth (for potential future use).
    public static boolean isAgeAtLeast16(LocalDate birthDate) {
        if (birthDate == null) return false;
        LocalDate now = LocalDate.now();
        return Period.between(birthDate, now).getYears() >= 16;
    }
}