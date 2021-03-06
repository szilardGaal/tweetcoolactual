package com.codecool.web.servlet;

import com.codecool.web.model.Tweet;
import com.codecool.web.service.TweetService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    private final TweetService service = TweetService.getInstance();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String poster = req.getParameter("poster");
        String dateString = req.getParameter("from");
        int limit = Integer.parseInt(req.getParameter("limit"));
        int offset = Integer.parseInt(req.getParameter("offset"));

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date date = df.parse(dateString);
            List<Tweet> tweets = service.getFilteredTweets(poster, date, offset, limit);
            req.setAttribute("tweets", tweets);
        } catch (ParseException e) {
            req.setAttribute("errorMessage", "blabla");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
