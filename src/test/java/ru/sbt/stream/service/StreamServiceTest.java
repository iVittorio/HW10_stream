package ru.sbt.stream.service;

import org.junit.Test;
import ru.sbt.stream.model.User;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by i.viktor on 29/08/16.
 */
public class StreamServiceTest {

    @Test
    public void streamTest() {
        User user1 = new User(1, "User1", 25);
        User user2 = new User(2, "User2", 18);
        User user3 = new User(3, "User3", 30);
        User user4 = new User(4, "User4", 10);

        List<User> users = new ArrayList<>(Arrays.asList(user1, user2, user3, user4));

        Map<String, Integer> map = StreamService.of(users)
                .filter(u -> (u.getAge() >= 18 && u.getId() != 2))
                .transform(u -> new User(u.getId(), u.getLogin(), u.getAge()*2))
                .toMap(User::getLogin, User::getAge);

        Map<String, Integer> toAssertMap = new HashMap<>();

        toAssertMap.put("User1", 50);
        toAssertMap.put("User3", 60);

        assertEquals(toAssertMap, map);
    }
}
