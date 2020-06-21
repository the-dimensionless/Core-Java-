package com.nagarro.training.fixedrates;

import com.nagarro.training.model.Item;

public class ProcessingTax extends TaxRules {
	
	public ProcessingTax(Item itemObject) {
		super(itemObject);
		double tmp = new CommonRawTax(itemObject).commonRawTax;
		if (itemObject.getItemType() == ItemType.RawAndImported) {
			tax = 0; // No extra cost for Raw goods other than the commonRawTax
		} else if (itemObject.getItemType() == ItemType.ManufacturedAndImported) {
			tax = processingGoodsTaxPercentage * (itemObject.getItemPrice() + tmp);
		}
	}

}
