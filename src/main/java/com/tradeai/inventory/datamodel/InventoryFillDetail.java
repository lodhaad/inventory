package com.tradeai.inventory.datamodel;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter


@Entity
@Table (name = "inventory_fill", schema = "inventory")
public class InventoryFillDetail {
	
	
	@Column (name = "inventory_id")
	private Integer inventoryId;
	
	@Column (name = "demand_id")
	private Integer demand_id;
	
	
	@Column (name = "quantity")
	private Integer quantity; 
	

}
