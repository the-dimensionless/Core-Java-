/**
* interface name : PriceRegulator
*
* Author info : @Sumit Kumar Singh
*
* Description : Class responsible stores Final Price regulation charges.
*/
package com.nagarro.model;
/**
 * Stores Final Price regulation charges
 */
public interface PriceRegulator {
	
	/** Tax to be applied if flight class if Economy*/
	public static final double ECONOMY_TAX_PERCENT = 1;
	/** Tax to be applied if flight class if Business*/
	public static final double BUSINESS_TAX_PERCENT = 1.4;

}
