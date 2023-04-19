package com.education.patterns.eventlistener;

import com.education.patterns.eventlistener.impl.EventManagerImpl;
import com.education.patterns.eventlistener.impl.Keyboard;
import com.education.patterns.eventlistener.impl.PrintConsoleMessageEventListenerImpl;
import com.education.patterns.eventlistener.impl.SendEmailEventListenerImpl;

public class Runner {
    public static void main(String[] args) {
        EventListener consoleEventListener = new PrintConsoleMessageEventListenerImpl();
        EventListener emailEventListener = new SendEmailEventListenerImpl();
        EventManager manager = new EventManagerImpl(EventType.BUTTON_PRESSED, EventType.BUTTON_RELEASED);

        Keyboard keyboard = new Keyboard(manager);

        manager.subscribe(EventType.BUTTON_PRESSED, consoleEventListener);
        manager.subscribe(EventType.BUTTON_PRESSED, emailEventListener);
        manager.subscribe(EventType.BUTTON_RELEASED, consoleEventListener);
        manager.subscribe(EventType.BUTTON_RELEASED, emailEventListener);

        keyboard.press();
        keyboard.release();
    }
}
