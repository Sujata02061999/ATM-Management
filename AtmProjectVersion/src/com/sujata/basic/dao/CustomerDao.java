package com.sujata.basic.dao;

import com.sujata.basic.entity.Customer;

public interface CustomerDao {
   Customer findCardNumber(String cardNo);
}
