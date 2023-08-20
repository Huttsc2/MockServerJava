package Main;

import Expectations.ExpectationInitializer;
import org.mockserver.integration.ClientAndServer;

public class MainClass {
    public static void main(String[] args) {
        System.setProperty("mockserver.initializationClass", ExpectationInitializer.class.getName());
        ClientAndServer mockServer = ClientAndServer.startClientAndServer(1080);
    }
}