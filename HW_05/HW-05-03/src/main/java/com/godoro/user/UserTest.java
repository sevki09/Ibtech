package com.godoro.user;

public class UserTest {
	
	public static void main(String[] args) throws Exception {
		UserManager userManager=new UserManager();
		
		User user=userManager.findByUserName("Ne�et");
		System.out.println(user.getUserId()+" "+user.getUserName()+" "+user.getPassword());
	}

}
