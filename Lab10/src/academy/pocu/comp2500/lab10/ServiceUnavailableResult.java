package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;

import java.time.OffsetDateTime;

public class ServiceUnavailableResult extends ResultBase{
    private OffsetDateTime start;
    private OffsetDateTime end;
    private ResultBase result;

    public ServiceUnavailableResult(OffsetDateTime start, OffsetDateTime end) {
        super(ResultCode.SERVICE_UNAVAILABLE);
        this.start = start;
        this.end = end;
    }
}
