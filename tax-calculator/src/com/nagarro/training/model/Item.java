/*
* Class name : Item
*
* Author info : @Sumit Kumar Singh
*
* Creation date : 23/01/2020
*
* Description : Solution to Problem Statement as given below --> 
* 				Write a stand alone java program that accepts items 
* 				details and calculate the effective cost  after applying 
* 				the tax rules.

*/
package com.nagarro.training.model;

import com.nagarro.training.fixedrates.ItemType;

public class Item {

	// variable to store item name.
	private String itemName; 
	
	private ItemType itemType; // variable to store item type.
	
	private Double itemPrice; // variable to store item price.
	
	private Integer itemQuantity; // variable to store item quantity.

	/*
	 * Parameterized Constuctor to create an Item Object
	 * @param String : itemName(Name of the item) 
	 */
	public Item(String itemName, ItemType itemType, Double itemPrice, Integer itemQuantity) {
		this.itemName = itemName;
		this.itemType = itemType;
		this.itemPrice = itemPrice;
		this.itemQuantity = itemQuantity;
	}

	public Item() {
	}

	public String getItemName() {
		// function to return current item's name
		return itemName;
	}

	public void setItemName(String itemName) {
		// function to set current item's name to the name in parameter.
		this.itemName = itemName;
	}

	public ItemType getItemType() {
		// function to get current item's type.
		return itemType;
	}

	public void setItemType(ItemType itemType) {
		// function to set current item's type to the type in parameter.
		this.itemType = itemType;
	}

	public Double getItemPrice() {
		// function to get current item's price.
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		// function to set current item's price to the price in parameter.
		this.itemPrice = itemPrice;
	}

	public Integer getItemQuantity() {
		// function to get quantity of current items.
		return itemQuantity;
	}

	public void setItemQuantity(Integer itemQuantity) {
		// function to set Quantity of current item to the Quantity in parameter.
		this.itemQuantity = itemQuantity;
	}

}
