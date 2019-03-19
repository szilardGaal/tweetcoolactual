<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.codecool.web.model.Tweet" %>
<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/index.css" type="text/css">
    <title>Tweetcool</title>
</head>

<body>
<div class="main">
    <h1><a href="index.jsp">Welcome to Tweetcool!</a></h1>
    <div class="left">
        <h2>Place your Tweet!</h2>
        <form action = "index" method = "POST">
            Your tweet: <br><textarea class = "content" name = "content"></textarea><br>
            Your name: <br><input class = "name" type = "text" name = "author">
            <input type = "submit" value = "Submit" />
        </form>
    </div>

    <div class="right">
        <h2>Tweets:</h2>
        <% List<Tweet> tweets = new ArrayList<>(); %>
        <% if (request.getAttribute("tweets") != null) { %>
            <% tweets.addAll((List<Tweet>)request.getAttribute("tweets")); %>
        <% } %>
        <% if (tweets.size() > 0) { %>
            <% for (Tweet tweet : tweets) { %>
            <p><i><%= tweet.getAuthor() %></i>: <%= tweet.getContent() %><br>
              <%= tweet.getDate() %> </p>
            <% } %>
        <% } %>
    </div>
    <div class="left">
      <form action = "search" class="search" method = "GET">
        <table>
          <tr>
            <td>limit:</td><td><input type="number" name="limit" value="10"></input></td>
          </tr>
          <tr>
            <td>offset:</td><td><input type="number" name="offset" value="0"></input></td>
          </tr>
          <tr>
            <td>poster:</td><td><input type="text" name="poster"></input></td>
          </tr>
          <tr>
            <td>from:</td><td><input type="date" name="from" value="2019-02-02"></input></td>
          </tr>
        </table>
        <input type = "submit" value = "search" />
      </form>
    </div>
</div>

</body>
</html>
