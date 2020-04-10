package com.tradeai.inventory.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class InventoryPositionDTO {
	
	private Integer inventoryId;	
	private String stockId;
	private Double rateCharged;
	private Integer quantity; 
	private Date businessDate;
	private String sourceDesk;
	private Integer fillId;

}
