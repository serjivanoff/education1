package com.education.patterns.eventlistener.impl;

import com.education.patterns.eventlistener.Event;
import com.education.patterns.eventlistener.EventListener;
import com.education.patterns.eventlistener.EventManager;
import com.education.patterns.eventlistener.EventType;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class EventManagerImpl implements EventManager {

    private final EnumMap<EventType, List<EventListener>> listeners = new EnumMap<>(EventType.class);

    public EventManagerImpl(EventType... eventTypes) {
        for (EventType et : eventTypes) {
            listeners.put(et, new ArrayList<>());
        }
    }

    @Override
    public void subscribe(EventType eventType, EventListener listener) {
        listeners.get(eventType).add(listener);
    }

    @Override
    public void unSubscribe(EventType eventType, EventListener listener) {
        listeners.get(eventType).remove(listener);
    }

    @Override
    public void notify(EventType eventType, Event event) {
        listeners.get(eventType).forEach(el -> el.handleEvent(event));
    }
}
