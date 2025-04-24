package dto;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @org.junit.jupiter.api.Test
    void testGetUserNameMethod() {
        User user = new User("John");
        assertEquals("John", user.getName());
    }
}

