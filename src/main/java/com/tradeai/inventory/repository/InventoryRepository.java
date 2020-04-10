package com.tradeai.inventory.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tradeai.inventory.datamodel.InventoryPosition;

public interface InventoryRepository extends CrudRepository<InventoryPosition, Integer> {
	
	@Query ( "select max(inventoryId) from InventoryPosition")
	public Integer getInventoryId();
	
	public List<InventoryPosition> findByStockIdAndBusinessDate(String srockId, Date businessDate);
}
