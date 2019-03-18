package com.codecool.web.service;

import com.codecool.web.model.Tweet;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TweetServiceTest {

    @Test
    void testGetGreeting() {
        // given
        TweetService service = new TweetService();

        // when
        List<Tweet> tweets = service.getTweets();

        // then
        assertNotNull(tweets);
    }
}
