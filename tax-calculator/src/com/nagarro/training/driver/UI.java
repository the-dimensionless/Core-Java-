/*
* Class name : UI
*
* Author info : @Sumit Kumar Singh
*
* Creation date : 23/01/2020
*
* Description : class for taking user input as given in the problem statement.
*/
package com.nagarro.training.driver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.nagarro.training.exceptionhandling.ItemInvalidatedException;
import com.nagarro.training.model.Item;
import com.nagarro.training.validation.ItemFactory;

public class UI {

	ArrayList<Item> arrayOfItems = new ArrayList<Item>(); // List to store items like a cart.

	/*
	 * Constructor to take user Input and add Validated Items in the arrayOfItems
	 * (items cart)
	 */
	public UI() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String keepLooping = "y"; // Default value for looping.
		introduction(); // Function to prompt user.
		while (keepLooping.equals("y")) {
			System.out.println("Please Enter as described above."); // Asking user Input.
			String userInput = "";
			try {
				userInput = br.readLine();
			} catch (IOException ex) {
				System.out.println("We are sorry for the IO trouble. Please try again");
			}
			// Receiving an item object after classifying and categorizing the user input
			// query.
			Item itemObject;
			try {
				itemObject = new ItemFactory().inputSplitter(userInput);
			} catch (ItemInvalidatedException e) {
				System.out.println(e.getMessage());
				keepLooping = "y";
				continue;
			}
			arrayOfItems.add(itemObject); // Adding item to cart of items.
			System.out.println("Do you wish to add details of another Item ?");
			try {
				userInput = br.readLine();
			} catch (IOException ex) {
				System.out.println("We are sorry for the trouble. Please try again");
			}
			if (userInput.equals("y")) {
				continue; // Continue user input loop.
			} else if (userInput.equals("n")) {
				break; // Break the loop
			} else {
				System.out.println("Please input the right command.");
				continue; // in any other case input (other than y/n)
			}
		}

	}

	/**
	 * Function to prompt user input and inform sample syntax.
	 */
	private static void introduction() {
		System.out.println("Welcome to taxation. Please enter the item details.");
		System.out.println("Input according to -[command]<space>[value].");
		System.out.println("Four basic commands : \n -name\n -type\n -price\n -quantity");
		System.out.println("Example -name itemName. Enter item name followed by any "
				+ "item price, item quantity, item type. Item type is MANDATORY.");
		System.out.println("Please beware : CASE SENSITIVE ");
	}

	ArrayList<Item> getArrayOfItems() {
		return this.arrayOfItems;
	}
}
