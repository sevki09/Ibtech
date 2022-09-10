package com.godoro.console;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleApplicitaion {
	private static Scanner scanner=new Scanner(System.in);
	
	private final static String filePath="C:\\Users\\�evki\\Desktop\\workspace\\Project02_HW_02_02\\Supplier.txt";
	
	private static List<Supplier> supplierList=new ArrayList<>();

	
	private static void printMenu()
	{
		System.out.println("Men�: ");
		System.out.println("1. Y�kle");
		System.out.println("2. Sakla");
		System.out.println("3. Dizelgele");
		System.out.println("4. Bul");
		System.out.println("5. Ekle");
		System.out.println("6. G�ncelle");
		System.out.println("7. Sil");
		System.out.println("0. ��k");
	}
	
	private static int scanChoice()
	{
		System.out.println("Se�iniz: ");
		int choice=scanner.nextInt();
		System.out.println("Se�ilen: "+choice);
		return choice;
	}
	
	private static void handleExit()
	{
		System.exit(0);
	}
	
	private static void handleChoice(int choice) throws Exception
	{
		switch(choice)
			{
			case 1:
				doLoad();
				break;
			case 2:
				doStore();
				break;
			case 3:
				doList();
				break;
			case 4:
				doFind();
				break;
			case 5:
				doAdd();
				break;
			case 6:
				doUpdate();
				break;
			case 7:
				doDelete();
				break;
			case 0:
				doExit();
				break;
			default:
				System.out.println("Ge�ersiz se�im: "+choice);	
			}
	}
	private static void doLoad() throws Exception 
	{
		System.out.println("Y�kleniyor...");
		SupplierFiler supplierFiler=new SupplierFiler(filePath);
		supplierList=supplierFiler.load();
		
	}
	private static void doStore() throws Exception
	{
		System.out.println("Saklan�yor...");
		SupplierFiler supplierFiler=new SupplierFiler(filePath);
		supplierFiler.store(supplierList);
	}
	private static void doList() throws IOException
	{
		System.out.println("Dizelgeleniyor...");
		SupplierFiler supplierFiler=new SupplierFiler(filePath);
		for(Supplier supplier:supplierFiler.load())
		{
			printSupplier(supplier);
		}
	}
	private static void doFind()
	{
		System.out.println("Bulunuyor...");
		System.out.println("Bulmak istedi�iniz istemci Id: ");
		long supplierId=scanner.nextLong();
		findSupplier(supplierId);
	}
	private static void doAdd()
	{
		System.out.println("Ekleniyor...");
		Supplier supplier=new Supplier();
		System.out.println("Sat�mc� Id: ");
		supplier.setSupplierId(scanner.nextLong());
		System.out.println("Sat�mc� Ad�: ");
		String string=scanner.next();
		string+=scanner.nextLine();
		supplier.setSupplierName(string);
		System.out.println("Toplam Kredi: ");
		supplier.setTotalCredit(scanner.nextDouble());
		supplierList.add(supplier);
		System.out.println("Eklendi...");
	}
	private static void doUpdate()
	{
		System.out.println("G�ncelleniyor...");
		System.out.println("G�ncellemek istedi�iniz sat�mc� Id: ");
		long supplierId=scanner.nextLong();
		for(Supplier supplier:supplierList)
		{
			if(supplier.getSupplierId()==supplierId)
			{
				System.out.println("Sat�mc� yeni ad�: ");
				String string=scanner.next();
				string+=scanner.nextLine();
				supplier.setSupplierName(string);
				System.out.println("Sat�mc� yeni kredisi: ");
				supplier.setTotalCredit(scanner.nextDouble());
				int index=supplierList.indexOf(supplier);
				supplierList.set(index, supplier);
			}
		}
	}
	private static void doDelete()
	{
		System.out.println("Siliniyor...");
		System.out.println("Silmek istedi�iniz sat�mc� Id: ");
		long supplierId=scanner.nextLong();
		for(Supplier supplier:supplierList)
		{
			if(supplier.getSupplierId()==supplierId)
			{
				int index=supplierList.indexOf(supplier);
				supplierList.remove(index);
				break;
			}
		}
		
	}
	private static void doExit()
	{
		System.out.println("��k�l�yor...");
		handleExit();
	}
	private static void printSupplier(Supplier supplier)
	{
		System.out.println(supplier.getSupplierId()+" "
				+supplier.getSupplierName()+" "
				+supplier.getTotalCredit());
	}
	private static void findSupplier(long supplierId)
	{
		boolean control=false;
		for(Supplier supplier:supplierList)
		{
			if(supplier.getSupplierId()==supplierId)
			{
				printSupplier(supplier);
				control=true;
			}
		}
		if(!control)
		{
			System.out.println("�stemci bulunamad�: "+supplierId);
		}
	}
	
	public static void main(String[] args) throws Exception  {
		
		while(true)
		{
			printMenu();
			int choice=scanChoice();
			handleChoice(choice);
		}
		
	}

}
