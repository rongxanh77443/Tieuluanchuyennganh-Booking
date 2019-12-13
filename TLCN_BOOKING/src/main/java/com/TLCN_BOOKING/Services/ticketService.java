package com.TLCN_BOOKING.Services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TLCN_BOOKING.DAO.ticketRepository;
import com.TLCN_BOOKING.models.Bill;
import com.TLCN_BOOKING.models.Customer;
import com.TLCN_BOOKING.models.Ticket;

@Service
public class ticketService {
	@Autowired
	public ticketRepository ticketRepository;
	

	public Collection<Ticket> findAllTicket(){
		
		List<Ticket> tickets= new ArrayList<Ticket>();
		for (Ticket ticket: ticketRepository.findAll())
		{
			tickets.add(ticket);
		}		
		return tickets;
	}


	public void saveTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		ticketRepository.save(ticket);
	}


	public Collection<Ticket> findAllTicketByBill(Bill bill) {
		// TODO Auto-generated method stub
		List<Ticket> tickets= new ArrayList<Ticket>();
		for (Ticket ticket: ticketRepository.findAllByBill(bill))
		{
			tickets.add(ticket);
		}		
		return tickets;
	}


	public void delete(Integer ticketid) {
		// TODO Auto-generated method stub
		ticketRepository.deleteById(ticketid);
	}
}
