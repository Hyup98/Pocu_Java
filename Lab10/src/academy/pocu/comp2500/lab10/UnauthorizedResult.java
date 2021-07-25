package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;

public class UnauthorizedResult extends ResultBase {

    public UnauthorizedResult() {
        super(ResultCode.UNAUTHORIZED);
    }

    public String getErrorMessage() {
        return ("Unauthorized access");
    }
}
