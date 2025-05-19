package com.java.tekarch.sfdc.pom;

public class Main {

	public static void main(String[] args) {
		LoginPage login=new LoginPage("firefox");
		try {
			login.LoginApp("mspriyamohan106@agentforce.com", "");
			
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
}
