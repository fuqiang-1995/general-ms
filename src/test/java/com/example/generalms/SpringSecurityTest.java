package com.example.generalms;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author fuqiang
 * @dateTime: 2022/11/28 21:21
 **/
@SpringBootTest
public class SpringSecurityTest {
    @Test
    void encode() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        boolean matches = encoder.matches("123", "$2a$10$Rw.0REVO3oGKGCV5lGjSlOt0lP4SJClKZFFuF/GuyFWpvhjDpnNZC");
        System.out.println(matches);
    }
}
