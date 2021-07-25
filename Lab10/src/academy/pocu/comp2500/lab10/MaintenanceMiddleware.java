package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class MaintenanceMiddleware implements IRequestHandler{

    private OffsetDateTime maintenanceTime;
    private IRequestHandler next;


    public void MaintenanceMiddleaware(IRequestHandler handler, OffsetDateTime time) {
        this.maintenanceTime = time;
        this.next = handler;
    }

    @Override
    public ResultBase handle(Request request) {
        OffsetDateTime now =  OffsetDateTime.now(ZoneOffset.UTC);
        if(now.compareTo(maintenanceTime.plusHours(1)) > 0) {
            return (ResultBase)next;
        }
        else {
            ServiceUnavailableResult tem = new ServiceUnavailableResult(maintenanceTime, maintenanceTime.plusHours(1));
            return tem;
        }
    }

    public OffsetDateTime getStartDateTime() {
        return maintenanceTime;
    }

    public OffsetDateTime getEndDateTime() {
        return maintenanceTime.plusHours(1);
    }
}
