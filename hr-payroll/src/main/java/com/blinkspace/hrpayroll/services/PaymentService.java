package com.blinkspace.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.blinkspace.hrpayroll.entities.Payment;
import com.blinkspace.hrpayroll.entities.Worker;

@Service //informar para o spring que é uma classe de serviço
public class PaymentService {

	@Value("${hr-worker.host}") //propriedade que está no arquivo .properties
	private String workerHost; //valor do workerHost vale http://localhost:8001
	
	@Autowired //injeção de dependência do RestTemplate.
	private RestTemplate restTemplate;
	
	public Payment getPayment(long workerId, int days) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", ""+workerId); //para usar o workerId como String, foi criado um macete para converter para String
		
		Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
