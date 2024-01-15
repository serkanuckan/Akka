package com.mycompany.akkaproje;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class MessageActor extends AbstractActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, this::handleStringMessage)
                .match(Integer.class, this::handleIntegerMessage)
                .build();
    }

    private void handleStringMessage(String message) {
        log.info("Received a string message: {}", message);
        String reversed = new StringBuilder(message).reverse().toString();
        log.info("Reversed message: {}", reversed);
    }

    private void handleIntegerMessage(Integer message) {
        log.info("Received an integer message: {}", message);
        int square = message * message;
        log.info("Square of the number: {}", square);
    }
}
