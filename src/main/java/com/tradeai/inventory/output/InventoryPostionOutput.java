package com.tradeai.inventory.output;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class InventoryPostionOutput {
	
	private Integer inventoryId;	
	private String stockId;
	private Double rateCharged;
	private Integer quantity; 
	private String businessDate;
	private String sourceDesk;
	private Integer fillId;

}
