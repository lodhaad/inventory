package com.tradeai.inventory.datamodel;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


@Entity
@Table (name = "inventory", schema = "inventory")
public class InventoryPosition {
	
	@Id
	@Column (name = "inventory_id")
	private Integer inventoryId;
	
	@Column (name = "stock_id")
	private String stockId;
	
	@Column (name = "rate_charged")
	private Double rateCharged;
	
	@Column (name = "quantity")
	private Integer quantity; 
	
	@Column (name = "business_date")
	private Date businessDate;
	
	@Column (name = "source_desk")
	private String sourceDesk;
	


	

}
