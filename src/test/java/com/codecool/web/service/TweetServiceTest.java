package com.codecool.web.service;

import com.codecool.web.model.Tweet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TweetServiceTest {

    private List<Tweet> tests = new ArrayList<>();
    private TweetService service = TweetService.getInstance();
    private Date testDate = new Date(1552136085000L); // ~ 2019.03.09 ...
    private Tweet test1 = new Tweet("Béla", "tartalom");
    private Tweet test2 = new Tweet("Elek", "content");
    private Tweet test3 = new Tweet("Erzsi", "pletyka");

    @BeforeEach
    void setUp() {
        tests.add(test1);
        tests.add(test2);
        tests.add(test3);
        service.addTweet(test1);
        service.addTweet(test2);
        service.addTweet(test3);

    }

    @Test
    void getTweets() {
        assertTrue(service.getTweets().contains(test1) &&
                            service.getTweets().contains(test2) &&
                            service.getTweets().contains(test3));
    }

    @Test
    void getFilteredTweets() {
        List<Tweet> testList = service.getFilteredTweets("Béla", testDate, 0, 10);
        assertTrue(testList.contains(test1));
        assertFalse(testList.contains(test2));
        assertEquals(1, testList.size());
    }
}
