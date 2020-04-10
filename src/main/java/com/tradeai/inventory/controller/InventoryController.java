package com.tradeai.inventory.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tradeai.inventory.dto.InventoryPositionDTO;
import com.tradeai.inventory.output.InventoryPostionOutput;
import com.tradeai.inventory.repository.InventoryRepository;
import com.tradeai.inventory.service.InventoryService;

@RestController
@RequestMapping ("/inventory")
public class InventoryController {
	
	
	@Autowired
	private InventoryService service;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping("/health")
	public String gethealth() {
		return "Hello from inventory Service";
	}
	

	@GetMapping(path="/stock/{stockId}/date/{dateOfInventory}")
	public ResponseEntity<List<InventoryPostionOutput>> getInventoryForStockAndDate(@PathVariable String stockId,
			@PathVariable String dateOfInventory) throws ParseException {
		

		

		
		List<InventoryPositionDTO> list = service.getInventoryForDate(stockId, dateOfInventory);
		
		List<InventoryPostionOutput>  response = new ArrayList<InventoryPostionOutput>();
		
		//ModelMapper mapper =new ModelMapper();
		
		list.forEach(element -> {
			
			InventoryPostionOutput responseElement = mapper.map(element,InventoryPostionOutput.class);
			response.add(responseElement);
			
		});
		
		
		
		
		return new ResponseEntity<List<InventoryPostionOutput>>(response, HttpStatus.OK);
	}

}
