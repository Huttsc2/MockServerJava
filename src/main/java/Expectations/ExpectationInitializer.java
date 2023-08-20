package Expectations;

import Helpers.JsonReader;
import org.mockserver.mock.Expectation;
import org.mockserver.model.HttpClassCallback;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.Parameter.param;

public class ExpectationInitializer implements org.mockserver.server.initialize.ExpectationInitializer {

        @Override
        public Expectation[] initializeExpectations() {
                return new Expectation[]{
                        new Expectation(
                                request().withPath("/users.*")
                        )
                                .thenRespond(
                                        HttpClassCallback.callback()
                                                .withCallbackClass(
                                                        UsersCallback.class
                                                )
                        ),
                        new Expectation(
                                request().withPath("/books.*")
                        )
                                .thenRespond(
                                        HttpClassCallback.callback()
                                                .withCallbackClass(
                                                        BooksCallback.class
                                                )
                        )
                };
        }
}