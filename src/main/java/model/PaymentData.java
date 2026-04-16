/*
 * This is a modal class or POJO class
 * this is for JSon data mapping 
 * this is used to map raw data from JSon to structured data
 */
package model;

public class PaymentData {
	
	    private String cardNumber;
	    private String expiryMonth;
	    private String expiryYear;
	    private String cvv;
	    private String nameOnCard;
	    private String expectedResult;

	    // Getters & Setters

	  
	    public String getCardNumber() { return cardNumber; }
	    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }

	    public String getExpiryMonth() { return expiryMonth; }
	    public void setExpiryMonth(String expiryMonth) { this.expiryMonth = expiryMonth; }

	    public String getExpiryYear() { return expiryYear; }
	    public void setExpiryYear(String expiryYear) { this.expiryYear = expiryYear; }

	    public String getCvv() { return cvv; }
	    public void setCvv(String cvv) { this.cvv = cvv; }

	    public String getNameOnCard() { return nameOnCard; }
	    public void setNameOnCard(String nameOnCard) { this.nameOnCard = nameOnCard; }

	    public String getExpectedResult() { return expectedResult; }
	    public void setExpectedResult(String expectedResult) { this.expectedResult = expectedResult; }
	}
