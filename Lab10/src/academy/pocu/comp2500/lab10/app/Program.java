package academy.pocu.comp2500.lab10.app;

import academy.pocu.comp2500.lab10.*;
import academy.pocu.comp2500.lab10.pocuflix.*;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

public class Program {

    public static void main(String[] args) {
        MovieStore store = new MovieStore();

        store.add(new Movie("Harry Potter", Rating.PG13, 180));
        store.add(new Movie("The Lord of the Rings", Rating.R, 180));

        assert (!store.remove(2));
        assert (store.remove(1));

        {
            Request request = new Request("None");

            ResultBase result = store.handle(request);

            assert (result.getCode() == ResultCode.NOT_FOUND);
            assert (result instanceof NotFoundResult);

            request = new Request("Harry Potter");

            result = store.handle(request);

            assert (result.getCode() == ResultCode.OK);
            assert (result instanceof OkResult);

            OkResult okResult = (OkResult) result;

            assert (okResult.getMovie().getTitle().equals("Harry Potter"));
            assert (okResult.getMovie().getRating() == Rating.PG13);
            assert (okResult.getMovie().getPlayTime() == 180);
        }

        {
            OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);
            OffsetDateTime startDateTime = now.plusSeconds(5);
            OffsetDateTime endDateTime = startDateTime.plusHours(1);

            MaintenanceMiddleware middleware = new MaintenanceMiddleware(store, startDateTime);

            Request request = new Request("Harry Potter");

            ResultBase result = middleware.handle(request);

            assert (result.getCode() == ResultCode.OK);
            assert (result instanceof OkResult);

            sleep(10);

            request = new Request("Harry Potter");

            result = middleware.handle(request);

            assert (result.getCode() == ResultCode.SERVICE_UNAVAILABLE);
            assert (result instanceof ServiceUnavailableResult);

            ServiceUnavailableResult serviceUnavailableResult = (ServiceUnavailableResult) result;

            assert (serviceUnavailableResult.getStartDateTime().compareTo(startDateTime) == 0);
            assert (serviceUnavailableResult.getEndDateTime().compareTo(endDateTime) == 0);
        }

        {
            HashSet<User> users = new HashSet<>();
            users.add(new User("Jane", "Doe"));

            AuthorizationMiddleware middleware = new AuthorizationMiddleware(store, users);

            Request request = new Request("Harry Potter");

            ResultBase result = middleware.handle(request);

            assert (result.getCode() == ResultCode.UNAUTHORIZED);
            assert (result instanceof UnauthorizedResult);

            UnauthorizedResult unauthorizedResult = (UnauthorizedResult) result;

            assert (unauthorizedResult.getErrorMessage().equals("Unauthorized access"));

            request = new Request("Harry Potter");
            request.setUser(new User("James", "Bob"));

            result = middleware.handle(request);

            assert (result.getCode() == ResultCode.UNAUTHORIZED);
            assert (result instanceof UnauthorizedResult);

            unauthorizedResult = (UnauthorizedResult) result;

            assert (unauthorizedResult.getErrorMessage().equals("Unauthorized access"));

            request = new Request("Harry Potter");
            request.setUser(new User("Jane", "Doe"));

            result = middleware.handle(request);

            assert (result.getCode() == ResultCode.OK);
            assert (result instanceof OkResult);
        }

        {
            CacheMiddleware middleware = new CacheMiddleware(store, 3);

            Request request = new Request("Harry Potter");

            ResultBase result = middleware.handle(request);

            assert (result.getCode() == ResultCode.OK);
            assert (result instanceof OkResult);

            request = new Request("Harry Potter");

            result = middleware.handle(request);

            assert (result.getCode() == ResultCode.NOT_MODIFIED);
            assert (result instanceof CachedResult);

            CachedResult cachedResult = (CachedResult) result;

            assert (cachedResult.getExpiryCount() == 2);

            request = new Request("Harry Potter");
            request.setUser(new User("Jane", "Doe"));

            result = middleware.handle(request);

            assert (result.getCode() == ResultCode.OK);
            assert (result instanceof OkResult);

            request = new Request("Harry Potter");

            result = middleware.handle(request);

            assert (result.getCode() == ResultCode.NOT_MODIFIED);
            assert (result instanceof CachedResult);

            cachedResult = (CachedResult) result;

            assert (cachedResult.getExpiryCount() == 1);

            request = new Request("Harry Potter");
            request.setUser(new User("Jane", "Doe"));

            result = middleware.handle(request);

            assert (result.getCode() == ResultCode.NOT_MODIFIED);
            assert (result instanceof CachedResult);

            cachedResult = (CachedResult) result;

            assert (cachedResult.getExpiryCount() == 2);

            request = new Request("Harry Potter");

            result = middleware.handle(request);

            assert (result.getCode() == ResultCode.OK);
            assert (result instanceof OkResult);
        }
        {
            OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);

            ResultBase result = new ServiceUnavailableResult(now, now);

            ResultValidator validator = new ResultValidator(result);

            assert (validator.isValid(ResultCode.SERVICE_UNAVAILABLE));
            assert (!validator.isValid(ResultCode.OK));
            assert (!validator.isValid(ResultCode.NOT_FOUND));
        }
    }

    private static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}