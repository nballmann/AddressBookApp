package com.nic.adressbookapp;

import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NewContact extends Activity{
	
	EditText firstName;
	EditText lastName;
	EditText phoneNumber;
	EditText emailAddress;
	EditText homeAddress;

	
	DBTools dbTools = new DBTools(this);
	
	public void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_new_contact);
		
		firstName = (EditText) findViewById(R.id.firstName);
		lastName = (EditText) findViewById(R.id.lastName);
		phoneNumber = (EditText) findViewById(R.id.phoneNumber);
		emailAddress = (EditText) findViewById(R.id.emailAddress);
		homeAddress = (EditText) findViewById(R.id.homeAddress);		
		
	}
	
	public void addNewContact(View view){
		
		HashMap<String, String> queryValuesMap = new HashMap<String, String>();
		
		queryValuesMap.put("firstName", firstName.getText().toString());
		queryValuesMap.put("lastName", lastName.getText().toString());
		queryValuesMap.put("phoneNumber", phoneNumber.getText().toString());
		queryValuesMap.put("emailAddress", emailAddress.getText().toString());
		queryValuesMap.put("homeAddress", homeAddress.getText().toString());
		
		dbTools.insertContact(queryValuesMap);
		
		this.callMainActivity(view);
		
	}
	
	public void callMainActivity(View view){
		
		Intent theIntent = new Intent(getApplication(), MainActivity.class);
		
		startActivity(theIntent);
		
	}
	
}
