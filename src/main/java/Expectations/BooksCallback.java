package Expectations;

import Helpers.JsonReader;
import org.mockserver.mock.action.ExpectationResponseCallback;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.mockserver.model.HttpStatusCode;

import static org.mockserver.model.HttpResponse.notFoundResponse;
import static org.mockserver.model.HttpResponse.response;

public class BooksCallback implements ExpectationResponseCallback {

    @Override
    public HttpResponse handle(HttpRequest httpRequest) {
        String method = httpRequest.getMethod().getValue();
        String path = httpRequest.getPath().getValue();

        switch (method) {
            case "GET" -> {
                switch (path) {
                    case "/books" -> {
                        return response()
                                .withStatusCode(HttpStatusCode.ACCEPTED_202.code())
                                .withBody(new JsonReader().getBookInfoList());
                    }
                    case "/books/1" -> {
                        return response()
                                .withStatusCode(HttpStatusCode.ACCEPTED_202.code())
                                .withBody(new JsonReader().getBookInfoById1());
                    }
                    case "/books/2" -> {
                        return response()
                                .withStatusCode(HttpStatusCode.ACCEPTED_202.code())
                                .withBody(new JsonReader().getBookInfoById2());
                    }
                }
            }
            case "POST" -> {
                switch (path) {
                    case "/books" -> {
                        return response()
                                .withStatusCode(HttpStatusCode.ACCEPTED_202.code())
                                .withBody("Item created");
                    }
                }
            }
            case "PUT" -> {
                switch (path) {
                    case "/books/1/genres", "/books/1/reviews", "/books/2/genres", "/books/2/reviews" -> {
                        return response()
                                .withStatusCode(HttpStatusCode.ACCEPTED_202.code())
                                .withBody("Item updated");
                    }
                }
            }
            case "DELETE" -> {
                switch (path) {
                    case "/books/1", "/books/2" -> {
                        return response()
                                .withStatusCode(HttpStatusCode.ACCEPTED_202.code())
                                .withBody("Item deleted");
                    }
                }
            }
        }
        return notFoundResponse();
    }
}
