package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.User;

import java.util.Objects;

public class Request implements IRequestHandler {
    private String movieTitle;
    private User user;

    public Request(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Request)) return false;
        Request request = (Request) o;
        return Objects.equals(movieTitle, request.movieTitle) && Objects.equals(user, request.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieTitle, user);
    }

    @Override
    public ResultBase handle(Request request) {
        return null;
    }

    public String getMovieName() {
        return movieTitle;
    }

    public String getUserName() {
        return user.getUsername();
    }

    public User getUser() {
        return user;
    }

    public void setUser(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
