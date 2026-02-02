package com.eventmanagement.api.service;

import com.eventmanagement.api.entity.Event;
import java.util.Optional;

public interface EventService {
    Event createEvent(Event event);
    Optional<Event> getEventById(Long id);
}
