package com.tdialog.domibusdemo;

public class Message {

    private final String text;
    private final String sender;
    private final String reciever;


    public Message(String text, String sender, String reciever) {
        this.text = text;
        this.sender = sender;
        this.reciever = reciever;
    }

    public String getText() {
        return text;
    }

    public String getSender() {
        return sender;
    }

    public String getReciever() {
        return reciever;
    }
}
