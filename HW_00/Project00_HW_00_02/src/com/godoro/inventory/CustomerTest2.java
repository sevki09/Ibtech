package com.godoro.inventory;

public class CustomerTest2 {

	public static void main(String[] args) {
		Customer customer=new Customer(501,"Ne�et Erta�",4350);
		System.out.println("M��ter �zde�li�i: "+customer.getCustomerId());
		System.out.println("M��teri Ad�: "+customer.getCustomerName());

		System.out.println("Toplam Borcu: "+customer.getTotalDebit());

	}

}
