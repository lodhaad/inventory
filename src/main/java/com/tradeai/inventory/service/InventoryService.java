package com.tradeai.inventory.service;

import java.util.List;

import com.tradeai.inventory.dto.InventoryPositionDTO;

public interface InventoryService {
	
	public List<InventoryPositionDTO> getInventoryForDate(String stockId, String dateOfInventory);
	
	public InventoryPositionDTO saveSinglePostionInInventory(InventoryPositionDTO inventory);
	
	public InventoryPositionDTO updateFillFromDemand(InventoryPositionDTO inventory);

}
