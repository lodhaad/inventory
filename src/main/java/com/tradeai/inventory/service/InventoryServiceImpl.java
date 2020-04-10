package com.tradeai.inventory.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tradeai.inventory.datamodel.InventoryPosition;
import com.tradeai.inventory.dto.InventoryPositionDTO;
import com.tradeai.inventory.repository.InventoryRepository;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryRepository repository;
	
	@Autowired
	private ModelMapper mapper;


	@Override
	public InventoryPositionDTO saveSinglePostionInInventory(InventoryPositionDTO inventory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InventoryPositionDTO updateFillFromDemand(InventoryPositionDTO inventory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InventoryPositionDTO> getInventoryForDate(String stockId, String dateOfInventory) {
		

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		format.setTimeZone(TimeZone.getTimeZone("America/New_York"));

		Date date1 = null;
		try {
			date1 = format.parse(dateOfInventory);
		} catch (ParseException e) {

			e.printStackTrace();
		}

		if (date1 == null) {
			return null;
		}

		java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
		
		
		
		List<InventoryPosition> positions = repository.findByStockIdAndBusinessDate(stockId, sqlDate);
		
		/// sort and give the sorted result
		
		List<InventoryPositionDTO> positionsdto = new ArrayList<>();
		
		positions.forEach(element -> {
			
			InventoryPositionDTO dto = mapper.map(element, InventoryPositionDTO.class);
			positionsdto.add(dto);
			
			
			
		});
		
		
		return positionsdto;
		
	}

}
