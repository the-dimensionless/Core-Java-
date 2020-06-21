package com.nagarro.training.fixedrates;

import com.nagarro.training.model.Item;

public class CommonRawTax extends TaxRules {
	
	public CommonRawTax(Item itemObject) {
		super(itemObject);
		commonRawTax = itemObject.getItemPrice() * rawGoodsTaxPercentage; // Based on Formula
	}

}
