package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;

import java.time.OffsetDateTime;

public class MaintenanceMiddleware implements IRequestHandler {

    private OffsetDateTime startDateTime;
    private OffsetDateTime endDateTime;
    private IRequestHandler next;


    public MaintenanceMiddleware(IRequestHandler handler, OffsetDateTime startDateTime) {
        this.startDateTime = startDateTime;
        this.endDateTime = startDateTime.plusHours(1L);
        this.next = handler;
    }

    public OffsetDateTime getEndDateTime() {
        return endDateTime;
    }

    public OffsetDateTime getStartDateTime() {
        return startDateTime;
    }

    @Override
    public ResultBase handle(Request request) {
        OffsetDateTime currentTime = OffsetDateTime.now();
        if (currentTime.isAfter(startDateTime) && currentTime.isBefore(endDateTime)) {
            return new ServiceUnavailableResult(startDateTime, endDateTime);
        }
        return this.next.handle(request);
    }
}

