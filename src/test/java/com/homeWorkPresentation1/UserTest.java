package com.homeWorkPresentation1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user = new User();

    @Test
    void validateUserAge() {
        try {
            user.createUser().validateUserAge(user);
        } catch (ClassCastException e) {

        }
    }

    @Test
    void addAddressToUser() {
    }

    @Test
    void deleteAddressFromUser() {
    }

    @Test
    void fullNameCorrections() {
    }
}