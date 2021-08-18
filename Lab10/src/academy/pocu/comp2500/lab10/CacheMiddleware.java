package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;

import java.util.HashMap;

public class CacheMiddleware implements IRequestHandler {

    private IRequestHandler next;
    private int expiryCount;
    private int cacheCount;
    private HashMap<Request, Integer> requestMap = new HashMap<>();

    public CacheMiddleware(IRequestHandler next, int expiryCount) {
        this.expiryCount = expiryCount;
        this.next = next;
        this.cacheCount = 0;
    }

    @Override
    public ResultBase handle(Request request) {

        if (this.requestMap.containsKey(request)) {
            int currentCount = Math.max(0, this.requestMap.get(request) - 1);
            if (currentCount == 0) {
                ResultBase resultBase = this.next.handle(request);
                if (resultBase.getCode() == ResultCode.OK) {
                    this.requestMap.put(request, expiryCount);
                }
                return this.next.handle(request);
            }
            this.requestMap.put(request, currentCount);
            return new CachedResult(currentCount);
        }

        ResultBase resultBase = this.next.handle(request);
        if (resultBase.getCode() == ResultCode.OK) {
            this.requestMap.put(request, expiryCount);
        }
        return this.next.handle(request);
    }

    public int getExpiryCount() {
        return expiryCount;
    }
}
