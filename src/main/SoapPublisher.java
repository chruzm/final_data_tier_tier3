package main;

import soap.TestImpll;

import javax.xml.ws.Endpoint;


public class SoapPublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9999/ws/tst", new TestImpll());
    }
}
