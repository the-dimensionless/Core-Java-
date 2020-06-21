/*
* Class name : InputAndValidation
*
* Author info : @Sumit Kumar Singh
*
* Creation date : 23/01/2020
*
* Description : Validates the inputs given by the user by first splitting them.
*/
package com.nagarro.training.validation;

import com.nagarro.training.exceptionhandling.InvalidSyntaxException;
import com.nagarro.training.exceptionhandling.ItemInvalidatedException;
import com.nagarro.training.fixedrates.ItemType;
import com.nagarro.training.model.Item;

/*
 * This Class is concerned with the Validation of each subquery within the input text
 * received from the Taxation class.
 * 
 * Returns -1 for Invalidated query and 1 for a validated one.
 */
public class ItemFactory {
	String name; // Name of the item
	ItemType type; // Type of the item
	Double price; // Price of the item
	Integer quantity; // Quantity of the item

	public boolean isFullyNumeric(String userName) {
		int flag = 0;
		boolean value = true;
		for (int i = 0; i < userName.length(); i++) {
			if (!Character.isLetter(userName.charAt(i))) {
				flag++;
			}
		}
		if (flag == userName.length()) {
			value = false;
		} else {
			value = true;
		}
		return value;
	}
	/**
     * Get Key details of a key.
     * 
      * @param String
     *            : userName
     * @param String
     *            : userName        
     * @return Int
     * @throws InvalidSyntaxException
     *             InvalidSyntaxException
     */
	public int validateName(String userName) throws InvalidSyntaxException {
		/*
		 * Function to split the user subquery and return validation result.
		 */
		int flag = 1;
		if (userName.length() <= 5 || !userName.substring(0, userName.indexOf(' ')).equals("name")) {
			throw new InvalidSyntaxException("Please check syntax for -item <itemName>");
		}
		String[] nameSplitter = userName.split(" ");
		if (isFullyNumeric(nameSplitter[1])) {
			name = nameSplitter[1];
			flag = 1;
		} else {
			System.out.println("Name cannot be Numeric. Please fix");
			throw new InvalidSyntaxException("It cannnot be completley Numeric.");
		}
		
		if (flag == -1) {
			throw new InvalidSyntaxException("It cannnot be completley Numeric.");
		}
		return flag;
	}

	public int validateType(String user) throws InvalidSyntaxException {
		/*
		 * Function to validate the item Type subquery and return success result.
		 */
		if (user.length() <= 5 || !user.substring(0, user.indexOf(' ')).equals("type")) {
			throw new InvalidSyntaxException("Please check syntax for -item <itemType>");
		}
		// Re - structuring the subquery
		String itemType = user.substring(user.indexOf(" ")).trim();
		int flag = 0;
		// Checking the plausible values for item type.
		if ((itemType.equals("Raw and Imported") == true)) {
			type = ItemType.RawAndImported;
			flag = 1;
		} else if ((itemType.equals("Manufactured and Imported") == true)) {
			type = ItemType.ManufacturedAndImported;
			flag = 1;
		} else {
		}
		// Setting flag to hint erroneous input and a message subsequently.
		if (flag == 0) {
			flag = -1;
			System.out.println("Please give correct value for Item Type.");
			System.out.println("Either 'Raw and Imported' or 'Manufactured and Imported'");
			System.out.println("Please beware : CASE SENSITIVE ");
		}

		return flag;

	}
	/*
	 * Parameterized Constuctor to create an Item Object
	 * @param String : itemName(Name of the item) 
	 */
	public int findOrderOfInputs(String inputArray[], int lengthOfInputs) {
		int flag = 0;
		for (int i = 2; i < inputArray.length; i++) {
			try {
				if (inputArray[i].contains("type")) {
					flag += validateType(inputArray[i]);
				} else if (inputArray[i].contains("price")) {
					flag += validatePrice(inputArray[i]);
				} else if (inputArray[i].contains("quantity")) {
					flag += validateQuantity(inputArray[i]);
				} else
					flag = -1;
			} catch (InvalidSyntaxException e) {
				System.out.println(e);
				flag = -1;
				break;
			}
		}

		if (flag == (lengthOfInputs - 1)) {
			flag = 1;
		}
		return flag;
	}

	public int validatePrice(String userItemPrice) throws InvalidSyntaxException {
		if (userItemPrice.length() <= 6 || !userItemPrice.substring(0, userItemPrice.indexOf(' ')).equals("price")) {
			throw new InvalidSyntaxException("Please check syntax for -item <itemPrice>");
		}
		String inputItemPrice = userItemPrice.substring(userItemPrice.indexOf(" ") + 1);
		int flag = 1;
		try {
			price = Double.parseDouble(inputItemPrice);
		} catch (Exception e) {
			System.out.println("Please enter the correct input for price.");
			flag = -1;
		}

		return flag;
	}

	public int validateQuantity(String userItemQuantity) throws InvalidSyntaxException {
		if (userItemQuantity.length() <= 9
				|| !userItemQuantity.substring(0, userItemQuantity.indexOf(' ')).equals("quantity")) {
			throw new InvalidSyntaxException("Please check syntax for -item <itemQuantity>");
		}
		String inputItemQuantity = userItemQuantity.substring(userItemQuantity.indexOf(" ") + 1).trim();
		int flag = 1;
		try {
			quantity = Integer.parseInt(inputItemQuantity);
		} catch (NumberFormatException e) {
			System.out.println("Please give correct values for Quantity of Item");
			flag = -1;
		}
		return flag;
	}

	public Item inputSplitter(String userInput) throws ItemInvalidatedException, InvalidSyntaxException {
		int flag = 0; // Flag variable to store sub query validation result.
		int flagForName = 0; // Variable to store name validation result.
		Item output = null;
		userInput = userInput.trim();
		String inputArray[] = userInput.split("-");
		int lengthOfArray = inputArray.length - 1;
		/*
		 * Raising an error type of null if there are less than 2 or more than 4 inputs
		 * in the user given Input from Taxation class.
		 */
		if (lengthOfArray < 2 || lengthOfArray > 4) {
			output = null;
		} else {
			flagForName = validateName(inputArray[1]);
			if (lengthOfArray == 2) {
				try {
					flag = validateType(inputArray[2]);
				} catch (InvalidSyntaxException e) {
					System.out.println(e.getMessage());
					flag = -1;
				}

				price = 0.0;
				quantity = 1;
			} else {
				flag = findOrderOfInputs(inputArray, lengthOfArray);
				if (price == null) {
					price = 0.0;
				} else if (quantity == null) {
					quantity = 1;
				}
			}
		}
		if (flag == 1 && (flagForName == 1)) {
			output = new Item(name, type, price, quantity);
		}

		if (output == null) {
			throw new ItemInvalidatedException("Item entry has been invalidated.\n Please try again.");
		}
		return output;
	}

}
