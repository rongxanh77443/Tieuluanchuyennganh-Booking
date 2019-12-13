package com.TLCN_BOOKING.Services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TLCN_BOOKING.DAO.billRepository;
import com.TLCN_BOOKING.DAO.customerRepository;
import com.TLCN_BOOKING.models.Bill;
import com.TLCN_BOOKING.models.Customer;

@Service
public class billService {

	@Autowired
	public billRepository billRepository;
	
	public void saveBill(Bill bill) {
		// TODO Auto-generated method stub
		billRepository.save(bill);
	}
	
	public Collection<Bill> findAllBill(){
		
		List<Bill> bills= new ArrayList<Bill>();
		for (Bill bill: billRepository.findAll())
		{
			bills.add(bill);
		}		
		return bills;
	}

	public Bill findByCustomer(Customer findByUser) {
		// TODO Auto-generated method stub
		return billRepository.findByCustomer(findByUser);
	}

	public Collection<Bill> findAllByCustomer(Customer findByUser) {
		// TODO Auto-generated method stub
		List<Bill> bills= new ArrayList<Bill>();
		for (Bill bill: billRepository.findAllByCustomer(findByUser))
		{
			bills.add(bill);
		}		
		return bills;
	}

}
