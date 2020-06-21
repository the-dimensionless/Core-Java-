package com.nagarro.training.fixedrates;

import com.nagarro.training.model.Item;

/*
 * Class that inherits from Rules Interface and calculates the various taxes.
 */
public class TaxRules implements Rules {

	double tax;
	double surcharge;
	double commonRawTax;
	double importDutyTax;
	Item itemObject;
	
	public TaxRules(Item item) {
		this.itemObject = item;
	}

	/*
	 * Function to calculate the taxes according to the formula given in question.
	 * It takes and Item Object as parameter. Returns the total Final cost per item.
	 */
	public double calculateTax() {
		setSurcharge(); // Function call to calculate the Surcharge
		importDutyTax = importDutyPercentage * itemObject.getItemPrice(); // Based on Formula
		return commonRawTax + surcharge + importDutyTax + tax; // returning the final cost per item
	}

	// Getter method for processing tax (excluding the common RawTax)
	public double getTax() {
		return tax;
	}

	// Getter method for Import Duty Tax
	public double getImportDutyTax() {
		return importDutyTax;
	}

	// Getter method for commonRawTax
	public double getCommonRawTax() {
		return commonRawTax;
	}

	/*
	 * Implementation of functions as given in the parent interface
	 * 
	 * @see com.nagarro.training.fixedrates.Rules#setSurcharge(com.nagarro.training.
	 * models.item.Item)
	 */
	public void setSurcharge() {
		/*
		 * Calculation of Surcharge subject to given conditions in the question. Toa
		 */
		double totalCost = tax + itemObject.getItemPrice();
		if (totalCost < 100) {
			surcharge = 5;
		} else if (totalCost >= 100 && totalCost <= 200) {
			surcharge = 10;
		} else
			surcharge = 1.05 * totalCost;
	}

	public double getSurcharge() {
		// Returns the surcharge incurred on the item
		return surcharge;
	}

}
