package com.TLCN_BOOKING.DAO;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TLCN_BOOKING.models.Bill;
import com.TLCN_BOOKING.models.Customer;
import com.TLCN_BOOKING.models.Ticket;

@Repository
public interface ticketRepository extends CrudRepository<Ticket, Integer>{

	Collection<Ticket> findAllByBill(Bill bill);

	void deleteById(String ticketid);

}
