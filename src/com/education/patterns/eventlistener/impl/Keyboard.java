package com.education.patterns.eventlistener.impl;

import com.education.patterns.eventlistener.EventManager;
import com.education.patterns.eventlistener.EventType;

public class Keyboard {
    private final EventManager manager;

    public Keyboard(EventManager manager) {
        this.manager = manager;
    }

    public EventManager getManager() {
        return manager;
    }

    public void press() {
        System.out.println("pressing button");
        manager.notify(EventType.BUTTON_PRESSED, new EventImpl("I'm a Keyboard. Pressed button."));
    }

    public void release() {
        System.out.println("releasing button");
        manager.notify(EventType.BUTTON_RELEASED, new EventImpl("I'm a Keyboard. Released button."));
    }
}
