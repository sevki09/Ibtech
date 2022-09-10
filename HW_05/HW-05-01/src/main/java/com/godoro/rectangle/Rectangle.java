package com.godoro.rectangle;

public class Rectangle {
	
	private int width;
	
	private int height;

	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public Rectangle() {
	}

	public int getWidht() {
		return width;
	}

	public void setWidht(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getArea() {
		return width*height;
	}
	
	public int getPerimeter() {
		return 2*(width+height);
	}

}
