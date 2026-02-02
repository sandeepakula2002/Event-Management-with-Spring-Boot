package com.eventmanagement.api.service;

import com.eventmanagement.api.entity.Event;
import com.eventmanagement.api.exception.EventNotFoundException;
import com.eventmanagement.api.repository.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    private static final Logger log = LoggerFactory.getLogger(EventServiceImpl.class);
    private final EventRepository repository;

    public EventServiceImpl(EventRepository repository) {
        this.repository = repository;
    }

    // CREATE
    @Override
    public Event createEvent(Event event) {
        log.info("Creating new event: {}", event.getTitle());
        return repository.save(event);
    }

    // READ BY ID
    @Override
    public Optional<Event> getEventById(Long id) {
        log.info("Fetching event with ID: {}", id);
        return repository.findById(id);
    }

    // READ ALL
    @Override
    public List<Event> getAllEvents() {
        log.info("Fetching all events");
        return repository.findAll();
    }

    // UPDATE
    @Override
    @Transactional
    public Event updateEvent(Long id, Event updatedEvent) {
        log.info("Updating event with ID: {}", id);

        Event event = repository.findById(id)
                .orElseThrow(() -> new EventNotFoundException("Event with ID " + id + " not found"));

        event.setTitle(updatedEvent.getTitle());
        event.setDescription(updatedEvent.getDescription());
        event.setLocation(updatedEvent.getLocation());
        event.setDate(updatedEvent.getDate());

        return repository.save(event);
    }

    // DELETE
    @Override
    @Transactional
    public void deleteEvent(Long id) {
        log.info("Deleting event with ID: {}", id);

        if (!repository.existsById(id)) {
            throw new EventNotFoundException("Cannot delete: Event with ID " + id + " not found");
        }

        repository.deleteById(id);
    }
}