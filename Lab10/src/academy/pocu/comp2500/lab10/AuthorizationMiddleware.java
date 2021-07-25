package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;
import academy.pocu.comp2500.lab10.pocuflix.User;

import java.util.HashSet;
import java.util.Iterator;

public class AuthorizationMiddleware implements IRequestHandler {
    private HashSet<User> users;
    private IRequestHandler next;
    public AuthorizationMiddleware(IRequestHandler handler, HashSet<User> users) {
        this.next = handler;
        this.users = users;
    }

    @Override
    public ResultBase handle(Request request) {
        Iterator<User> it = users.iterator();
        boolean bIspassed = false;
        while(it.hasNext()) {
            if(it.next().getUsername().equals(request.getUserName())) {
                bIspassed = true;
            }
        }
        if(bIspassed) {
            return (ResultBase) next;
        }
        UnauthorizedResult tem = new UnauthorizedResult();
        return tem;
    }
}
