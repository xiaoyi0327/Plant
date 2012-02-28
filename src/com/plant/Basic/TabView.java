package com.plant.Basic;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TextView;

public class TabView extends TabActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabview);
		
		Resources res = getResources(); // Resource object to get Drawables
	    TabHost tabHost = getTabHost();  // The activity TabHost
	    TabHost.TabSpec spec;  // Resusable TabSpec for each tab
	    Intent intent;  // Reusable Intent for each tab

	    // Create an Intent to launch an Activity for the tab (to be reused)
	    intent = new Intent().setClass(this, HomeList.class);

	    // Initialize a TabSpec for each tab and add it to the TabHost
	    spec = tabHost.newTabSpec("Home").setIndicator("Home",
	                      res.getDrawable(R.drawable.ic_tab_homtlist))
	                  .setContent(intent);
	    tabHost.addTab(spec);

	    // Do the same for the other tabs
	    intent = new Intent("com.plant.Basic.MYLIST");
	    spec = tabHost.newTabSpec("MyPlants").setIndicator("MyPlants",
	                      res.getDrawable(R.drawable.ic_tab_homtlist))
	                  .setContent(intent);
	    tabHost.addTab(spec);

	    intent = new Intent().setClass(this, MyFriends.class);
	    spec = tabHost.newTabSpec("Friends").setIndicator("Friends",
	                      res.getDrawable(R.drawable.ic_tab_homtlist))
	                  .setContent(intent);
	    tabHost.addTab(spec);
	    
	    intent = new Intent().setClass(this, Setting.class);
	    spec = tabHost.newTabSpec("Setting").setIndicator("Setting",
	                      res.getDrawable(R.drawable.ic_tab_homtlist))
	                  .setContent(intent);
	    tabHost.addTab(spec);

	    tabHost.setCurrentTab(0);
	}
	
	

}
