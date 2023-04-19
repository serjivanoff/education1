package com.education.patterns.eventlistener.impl;

import com.education.patterns.eventlistener.Event;
import com.education.patterns.eventlistener.EventListener;

public class PrintConsoleMessageEventListenerImpl implements EventListener {

    @Override
    public void handleEvent(Event event) {
        System.out.println(event.toString());
    }
}
