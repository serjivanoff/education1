package com.education.patterns.eventlistener.impl;

import com.education.patterns.eventlistener.Event;
import com.education.patterns.eventlistener.EventListener;

public class SendEmailEventListenerImpl implements EventListener {
    @Override
    public void handleEvent(Event event) {
        System.out.println("Sending email with event payload " + event);
    }
}
