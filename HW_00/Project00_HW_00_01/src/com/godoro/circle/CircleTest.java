package com.godoro.circle;

public class CircleTest {

	public static void main(String[] args) {
		
		Circle circle=new Circle(3);
		
		System.out.println("Alan :" + circle.getArea());
		System.out.println("�evrel: " + circle.getPerimeter());
		
		Circle circle2=new Circle();
		
		circle2.setRadius(3);
		
		System.out.println();
		System.out.println("Alan :" + circle2.getArea());
		System.out.println("�evrel: " + circle2.getPerimeter());
	}
}
