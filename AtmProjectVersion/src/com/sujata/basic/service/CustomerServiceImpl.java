package com.sujata.basic.service;

import com.sujata.basic.dao.CustomerDao;
import com.sujata.basic.dao.CustomerDaoImpl;
import com.sujata.basic.entity.Customer;

public class CustomerServiceImpl implements CustomerService {
 
	CustomerDao customerDao = new CustomerDaoImpl();
	@Override
	public Customer findCardNumber(String cardNo) {
		return customerDao.findCardNumber(cardNo);
	}

}
