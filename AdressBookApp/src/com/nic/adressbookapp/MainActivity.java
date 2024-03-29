package com.nic.adressbookapp;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MainActivity extends ListActivity {
	
	Intent intent;
	TextView contactId;
	
	DBTools dbTools = new DBTools(this);
	

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ArrayList<HashMap<String, String>> contactList = dbTools.getAllContacts();
		dbTools.getAllContacts();
		
		if(contactList.size() != 0) {			
			
			ListView listView = getListView();
			listView.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View view,
						int arg2, long arg3) {

					contactId = (TextView) view.findViewById(R.id.contactId);
					
					String contactIdValue = contactId.getText().toString();
					
					Intent theIntent = new Intent(getApplication(), EditContact.class);
					
					theIntent.putExtra("contactId", contactIdValue);
					
					startActivity(theIntent);
					
				}	
				
			});
			
			ListAdapter adapter = new SimpleAdapter(
					MainActivity.this, contactList, R.layout.contact_entry,
					new String[] {"contactId", "lastName", "firstName"},
					new int[] {R.id.contactId, R.id.lastName, R.id.firstName});
			
			setListAdapter(adapter);
			
		}
		
	}
	
	
	public void showAddContact(View view){
		
		Intent intent = new Intent(getApplication(), NewContact.class);
		
		startActivity(intent);
		
	}

}
