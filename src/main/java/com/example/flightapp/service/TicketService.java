package com.example.flightapp.service;

import com.example.flightapp.entity.Ticket;
import com.example.flightapp.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public List<Ticket> getTicketsByUserId(String userProfileId) {
        return ticketRepository.findByUserProfileUserId(userProfileId);
    }

    public Ticket createTicket(Ticket ticket) {
        ticket.setTicketId(UUID.randomUUID().toString());
        ticket.setCreatedAt(OffsetDateTime.now());
        return ticketRepository.save(ticket);
    }
}
