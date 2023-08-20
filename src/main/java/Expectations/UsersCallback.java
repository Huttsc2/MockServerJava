package Expectations;

import Helpers.JsonReader;
import org.mockserver.mock.action.ExpectationResponseCallback;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.mockserver.model.HttpStatusCode;

import static org.mockserver.model.HttpResponse.notFoundResponse;
import static org.mockserver.model.HttpResponse.response;

public class UsersCallback implements ExpectationResponseCallback {

    @Override
    public HttpResponse handle(HttpRequest httpRequest) {
        if (httpRequest.getPath().getValue().equals("/users")) {
            return response()
                    .withStatusCode(HttpStatusCode.ACCEPTED_202.code())
                    .withBody(new JsonReader().getUserList());
        } else if (httpRequest.getPath().getValue().equals("/users/1")) {
            return response()
                    .withStatusCode(HttpStatusCode.ACCEPTED_202.code())
                    .withBody(new JsonReader().getUserById());
        }
        return notFoundResponse();
    }
}
