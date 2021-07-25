package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;

public class CacheMiddleware implements IRequestHandler {
    private IRequestHandler next;
    private int count;
    public CacheMiddleware(IRequestHandler next,int count) {
        this.count = count;
        this.next = next;
    }

    @Override
    public ResultBase handle(Request request) {
        return null;
    }

    public int getExpiryCount() {
        return count;
    }
}
