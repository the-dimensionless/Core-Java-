/*
* Interface name : Rules
*
* Author info : @Sumit Kumar Singh
*
* Creation date : 23/01/2020
*
* Description : Contains the various taxes and their values with getters and setters
* 				for Surcharge on items
*/
package com.nagarro.training.fixedrates;

/*
 * Contains the Tax rates for various types of commodities and processes.
 */
public interface Rules {
	/*
	 * Any changes in the tax rates must be made here.
	 */

	double rawGoodsTaxPercentage = 0.125;
	double processingGoodsTaxPercentage = 0.02;
	double manufacturedGoodsPercentage = rawGoodsTaxPercentage + processingGoodsTaxPercentage;
	double importDutyPercentage = 0.1;

	void setSurcharge(); // Function Prototype to calculate Surcharge

	double getSurcharge(); // Function Prototype to get the Surcharge

}
