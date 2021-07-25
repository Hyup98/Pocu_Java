package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.Movie;
import academy.pocu.comp2500.lab10.pocuflix.NotFoundResult;
import academy.pocu.comp2500.lab10.pocuflix.OkResult;
import academy.pocu.comp2500.lab10.pocuflix.ResultBase;

import java.util.ArrayList;
public class MovieStore implements IRequestHandler{
    private ArrayList<Movie> movies = new ArrayList<>();
    public MovieStore() {
    }

    public void add(Movie movie) {
        if(!movie.equals(null)) {
            movies.add(movie);
        }
    }

    public boolean remove(int index) {
        if(index >= movies.size()) {
            return false;
        }
        else {
            movies.remove(index);
            return true;
        }
    }

    @Override
    public ResultBase handle(Request request) {
        for(int i = 0; i < movies.size(); i++) {
            if(movies.get(i).getTitle().equals(request.getMovieName())) {
                OkResult tem = new OkResult(movies.get(i));
                return tem;
            }
        }
        NotFoundResult tem = new NotFoundResult();
        return tem;
    }

}
