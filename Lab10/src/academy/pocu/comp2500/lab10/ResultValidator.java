package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.NotFoundResult;
import academy.pocu.comp2500.lab10.pocuflix.OkResult;
import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;

public class ResultValidator {
    private ResultBase resultBase;

    public ResultValidator(ResultBase resultBase) {
        this.resultBase = resultBase;
    }

    public boolean isValid(final ResultCode code) {
        ResultCode[] results = ResultCode.values();
        boolean existCode = false;
        for (ResultCode resultCode : results) {
            if (resultCode == code) {
                existCode = true;
                break;
            }
        }

        if (existCode) {
            switch (code) {
                case OK:
                    return resultBase instanceof OkResult && resultBase.getCode() == code;
                case NOT_FOUND:
                    return resultBase instanceof NotFoundResult && resultBase.getCode() == code;
                case SERVICE_UNAVAILABLE:
                    return resultBase instanceof ServiceUnavailableResult && resultBase.getCode() == code;
                case UNAUTHORIZED:
                    return resultBase instanceof UnauthorizedResult && resultBase.getCode() == code;
                default:
                    return resultBase instanceof CachedResult && resultBase.getCode() == code;
            }
        }

        return false;
    }
}
