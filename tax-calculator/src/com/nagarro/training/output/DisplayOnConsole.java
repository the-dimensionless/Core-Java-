/*
* Class name : DisplayOnConsole
*
* Author info : @Sumit Kumar Singh
*
* Creation date : 23/01/2020
*
* Description : Displays the output as the Item Name, Item Price, the taxes liable
* 				on each of the items, and the total final price of the item.
*/
package com.nagarro.training.output;

import java.util.ArrayList;

import com.nagarro.training.fixedrates.CommonRawTax;
import com.nagarro.training.fixedrates.ItemType;
import com.nagarro.training.fixedrates.ProcessingTax;
import com.nagarro.training.fixedrates.TaxRules;
import com.nagarro.training.model.Item;

public class DisplayOnConsole {
	/*
	 * Function to display item and relevant details from cart. Input parameter is a
	 * list of items. Output is Item, Item type, Sales Tax liability, Total final
	 * cost per item and Total Cost of the cart.
	 */

	public void display(ArrayList<Item> arrayOfItems) {
		int counter = 1;
		double totalCartCost = 0;
		double tax = 0;
		for (Item item : arrayOfItems) {
			ItemType type = item.getItemType();
			Integer quantity = item.getItemQuantity();
			System.out.println("\nGiven Item no: " + counter);
			counter++;
			System.out.println("Item name: " + item.getItemName() + "     Item price: " + item.getItemPrice());
			// TaxRules object to hold the calculated values for the current item.
			TaxRules calculation;
			System.out.println("Sales tax liability as follows: ");
			if (type == ItemType.RawAndImported ) {
				calculation = new CommonRawTax(item);
				tax = calculation.getCommonRawTax();
				System.out.println("Raw Tax : " + tax);
			} else {
				calculation = new ProcessingTax(item);
				double common = (new CommonRawTax(item).getCommonRawTax());
				tax = common + new ProcessingTax(item).getTax();
				System.out.println("Manufacturing Tax : " + tax);
			}
			calculation.calculateTax();
			tax += calculation.getImportDutyTax() + calculation.getSurcharge() + item.getItemPrice();
			System.out.println("Import Duty Tax : " + calculation.getImportDutyTax() + "     Surcharge Tax : "
					+ calculation.getSurcharge() + "     Final price per item : " + tax);

			totalCartCost += quantity * tax;

			System.out.println("Total Final price for " + quantity + " items : " + (quantity * tax));
		}
		System.out.println("\nTotal Cost of the cart is Rs " + totalCartCost);

	}

}
