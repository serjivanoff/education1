package com.education.patterns.eventlistener.impl;

import com.education.patterns.eventlistener.Event;

public class EventImpl implements Event {
    private final String message;

    public EventImpl(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "EventImpl{" +
                "message='" + message + '\'' +
                '}';
    }
}
