package org.struts.model;

import java.util.UUID;

public class PaymentModel {
	private String holderName,cardNumber,cvv,expMonth,expYear,UUID_Or,UUID_Pay;

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getExpMonth() {
		return expMonth;
	}

	public void setExpMonth(String expMonth) {
		this.expMonth = expMonth;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpYear() {
		return expYear;
	}

	public void setExpYear(String expYear) {
		this.expYear = expYear;
	}

	public String getUUID_Or() {
		return UUID_Or;
	}

	public void setUUID_Or() {
		UUID_Or = UUID.randomUUID().toString();
		
	}

	public String getUUID_Pay() {
		return UUID_Pay;
	}

	public void setUUID_Pay() {
		 UUID_Pay = UUID.randomUUID().toString();
	}
	
	

}
