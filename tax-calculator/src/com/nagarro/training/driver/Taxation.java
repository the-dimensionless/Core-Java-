/*
* Class name : Taxation
*
* Author info : @Sumit Kumar Singh
*
* Creation date : 23/01/2020
*
* Description : Main class for Driving program as given in the problem statement.
*/
package com.nagarro.training.driver;

import java.io.IOException;
import java.util.ArrayList;

import com.nagarro.training.model.Item;
import com.nagarro.training.output.DisplayOnConsole;

public class Taxation {

	public static void main(String[] args) throws IOException {
		ArrayList<Item> arrayOfItems = new UI().arrayOfItems; // List to store items like a cart.

		new DisplayOnConsole().display(arrayOfItems); // call to display the result (parameter is cart)

	}

	

}