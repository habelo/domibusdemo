package com.tdialog.domibusdemo;

import javafx.util.Pair;
import org.springframework.boot.SpringApplication;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.UUID;


public class Message {

    private UUID id;
    private LocalDateTime dateTime;
    private String from;
    private Pair<String, String> service;
    private String action;
    private String conversationId;
    private String text;
    private String title;

    public Message() {
        //sdk rekommenderar values:
        service = new Pair<>("se-digg-procid", "urn:riv:messaging-process");
        action = "urn:riv:infrastructure:messaging:MessageWithAttachments:1:Message";
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime() {
        dateTime = LocalDateTime.now(Clock.systemUTC());
    }

    public String getFrom() {
        return from;
    }

    //fixme skall vara url'n som meddelandet skickades ifrån
    public void setFrom(String from) {
        this.from = SpringApplication.BANNER_LOCATION_PROPERTY;
    }

    public Pair<String, String> getService() {
        return service;
    }

    public void setService(Pair<String, String> service) {
        this.service = service;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
