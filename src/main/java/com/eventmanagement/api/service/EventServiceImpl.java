package com.eventmanagement.api.service;

import com.eventmanagement.api.entity.Event;
import com.eventmanagement.api.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository repository;

    public EventServiceImpl(EventRepository repository) {
        this.repository = repository;
    }

    @Override
    public Event createEvent(Event event) {
        return repository.save(event);
    }

    @Override
    public Optional<Event> getEventById(Long id) {
        return repository.findById(id);
    }
}
