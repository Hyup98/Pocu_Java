package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.User;

public class Request implements IRequestHandler{
    private String movieName;
    private String userName;

    public Request(String name) {
        this.movieName = name;
    }

    public void setUser(String name) {
        this.movieName = name;
    }

    public void setUser(User user) {
        this.userName = user.getUsername();
    }

    @Override
    public ResultBase handle(Request request) {
        return null;
    }

    public String getMovieName() {
        return movieName;
    }
    public String getUserName() {
        return userName;
    }
}
