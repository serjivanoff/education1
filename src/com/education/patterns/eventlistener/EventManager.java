package com.education.patterns.eventlistener;

public interface EventManager {
    void subscribe(EventType eventType, EventListener listener);

    void unSubscribe(EventType eventType, EventListener listener);

    void notify(EventType eventType, Event event);
}
