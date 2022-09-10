package com.godoro.pattern;

public class TestInsert {
	public static void main(String[] args) {
		Customer customer=new Customer(0,"Buzdolab�",4350);
		CustomerManager customerManager=new CustomerManager();
		try {
			boolean inserted=customerManager.insert(customer);
			if(inserted)
			{
				System.out.println("�r�n Sokuldu.");
			}
			else
			{
				System.out.println("Sokulmad�!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
