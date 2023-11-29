package com.sujata.basic.service;

import com.sujata.basic.dao.AtmDao;
import com.sujata.basic.dao.AtmDaoImpl;
import com.sujata.basic.entity.AtmCard;
import com.sujata.basic.entity.Customer;

public class AtmServiceImpl implements AtmService {
     AtmDao atmDao= new AtmDaoImpl();
	@Override
	public String deposite(Customer customer, Integer depositAmount) {
        atmDao.deposite(customer, depositAmount);
		return "Amount deposited...";
	}

	@Override
	public String withdraw(Customer customer, Integer withdrawAmount) {
        atmDao.withdraw(customer, withdrawAmount);
		return "Amount withdrawal successfully...";
	}

	@Override
	public Integer checkBalance(Customer customer) {
		return atmDao.checkBalance(customer);
	}

	@Override
	public String changePin(Customer customer, String newPin) {
		return atmDao.changePin(customer, newPin);
	}

}
