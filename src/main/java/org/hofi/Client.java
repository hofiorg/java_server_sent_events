package org.hofi;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;

import java.net.URI;
import java.util.concurrent.TimeUnit;

public class Client {
  public static void main(String[] args) throws InterruptedException {
    EventHandler eventHandler = new SimpleEventHandler();
    String url = String.format("http://localhost:8080/hofi");
    EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(url));

    try (EventSource eventSource = builder.build()) {
      eventSource.setReconnectionTimeMs(3000);
      eventSource.start();

      TimeUnit.MINUTES.sleep(10);
    }
  }
}