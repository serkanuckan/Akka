package com.mycompany.akkaproje;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Akka {

    public static void main(String[] args) {
        // Actor System oluştur
        ActorSystem system = ActorSystem.create("MessageSystem");

        // MessageActor için ActorRef oluştur
        ActorRef messageActor = system.actorOf(Props.create(MessageActor.class), "messageActor");

        // String mesajları gönder
        messageActor.tell("AkkaISUBUDeneme", ActorRef.noSender());
        messageActor.tell("ISUBU", ActorRef.noSender());

        // Numeric mesajları gönder
        messageActor.tell(10, ActorRef.noSender());
        messageActor.tell(16, ActorRef.noSender());

        // Actor System'ı sonlandır
        system.terminate();
    }
}
