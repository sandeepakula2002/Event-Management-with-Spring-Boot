package com.eventmanagement.api.service;

import com.eventmanagement.api.entity.Event;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface EventService {
    Event createEvent(Event event);
    Optional<Event> getEventById(Long id);
    List<Event> getAllEvents();
    Event updateEvent(Long id, Event updatedEvent);
    void deleteEvent(Long id);
}