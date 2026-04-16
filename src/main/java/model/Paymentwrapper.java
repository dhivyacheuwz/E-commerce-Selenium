/*
 * This is a Wrapper class
 * this is for mapping primitive data to list ,array and object 
 */

package model;

import java.util.List;

public class Paymentwrapper {
	private List<PaymentData> payments;

    public List<PaymentData> getPayments() {
        return payments;
    }

    public void setPayments(List<PaymentData> payments) {
        this.payments = payments;
    }

}
