package academy.pocu.comp2500.lab10.pocuflix;

public final class OkResult extends ResultBase {
    private final Movie movie;

    public OkResult(final Movie movie) {
        super(ResultCode.OK);

        this.movie = movie;
    }

    public Movie getMovie() {
        return this.movie;
    }
}
