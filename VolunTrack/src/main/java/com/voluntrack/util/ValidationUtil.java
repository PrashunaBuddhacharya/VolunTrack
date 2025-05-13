package com.voluntrack.util;

import java.time.LocalDate;
import java.time.Period;
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

    
     // Check if a string is null or empty.
     
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    
     //Validate email format.
     
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

    
     //check if two passwords match.
     
    public static boolean doPasswordMatch(String password, String confirmPassword) {
        return password != null && password.equals(confirmPassword);
    }

   //Username must start with a letter and contain only letters and numbers.
     
    public static boolean isAlphaNumericStartingWithLetters(String username) {
        return username != null && USERNAME_PATTERN.matcher(username).matches();
    }

    // Ensure age is at least 16 based on LocalDate of birth.
     
    public static boolean isAgeAtLeast16(LocalDate birthDate) {
        if (birthDate == null) return false;
        LocalDate now = LocalDate.now();
        return Period.between(birthDate, now).getYears() >= 16;
    }

	public static boolean doPasswordsMatch(String parameter, String parameter2) {
		// TODO Auto-generated method stub
		return false;
	}
}
