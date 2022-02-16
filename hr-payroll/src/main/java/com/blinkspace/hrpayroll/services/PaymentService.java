package com.blinkspace.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.blinkspace.hrpayroll.entities.Payment;

@Service
public class PaymentService {

	public Payment getPayment(long workedId, int days) {
		return new Payment("Marcelo", 200.0, days);
	}
}
