package academy.pocu.comp2500.lab10.pocuflix;

public abstract class ResultBase {
    private ResultCode code;

    public ResultBase(final ResultCode code) {
        this.code = code;
    }

    public ResultCode getCode() {
        return this.code;
    }
}
