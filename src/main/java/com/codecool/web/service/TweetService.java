package com.codecool.web.service;

import com.codecool.web.model.Tweet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public final class TweetService {

    Tweet[] cucc = {new Tweet("cucc", "teszt szöveg1"),
                    new Tweet("mucc", "teszt szöveg2"),
                    new Tweet("Marci", "Zsanett legyél a szökőkútnál")};
    private List<Tweet> tweets = new ArrayList<>(Arrays.asList(cucc));

    public void addTweet(Tweet tweet) {
        tweets.add(tweet);
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public List<Tweet> getFilteredTweets(String poster, Date date, int offset, int limit) {

        List<Tweet> filtered = new ArrayList<>(tweets);
        List<Tweet> actual = new ArrayList<>();

        List<Tweet> removeByPoster = filterPosters(poster);
        List<Tweet> removeByDate = filerDate(date);

        filtered.removeAll(removeByPoster);
        filtered.removeAll(removeByDate);

        int counter;

        if (limit+offset > filtered.size()) {
            counter = filtered.size();
        } else {
            counter = limit+offset;
        }

        for (int i=offset; i < counter; i++) {
            actual.add(filtered.get(i));
        }

        return actual;
    }

    private List<Tweet> filterPosters(String poster) {
        List<Tweet> filter = new ArrayList<>();

        for (Tweet t : tweets) {
            if (!t.getAuthor().equals(poster)) {
                filter.add(t);
            }
        }
        return filter;
    }

    private List<Tweet> filerDate(Date date) {
        List<Tweet> filter = new ArrayList<>();

        for (Tweet t : tweets) {
            if (!t.getDate().after(date)) {
                filter.add(t);
            }
        }
        return filter;
    }

}
