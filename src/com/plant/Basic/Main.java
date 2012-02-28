package com.plant.Basic;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main extends Activity{
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		final EditText email = (EditText) findViewById(R.id.emailEdit);
		final EditText password = (EditText) findViewById(R.id.passwordEdit);
		final TextView emailTxt = (TextView) findViewById(R.id.emailText);
		Button bTutorial1 = (Button) findViewById(R.id.login);
		
		bTutorial1.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0){
				boolean result = false;
				//emailTxt.setText(email.getText());
				// TODO Auto-generated method stub
				// da
				try{
					result = userValidation(email.getText().toString(), password.getText().toString());
				}
				catch(Exception e){
				}
				if(result)
					
				    startActivity(new Intent("com.plant.Basic.TABVIEW"));
				else
					emailTxt.setText("Wrong password or email or didn't enter");
				
			}
		});
	}
	
public static final String KEY_121 = "http://96.9.4.98/myapitest/json.php"; //email&password
	
	public boolean userValidation(String email, String password){
		boolean valiResult = false;
		TextView infoTxt = (TextView) findViewById(R.id.info);
	    
		InputStream is = null;
		String result = "";
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("email", email));
		nameValuePairs.add(new BasicNameValuePair("password", password));
		
		// http post
		try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(KEY_121);
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();

		} catch (Exception e) {
					Log.e("log_tag", "Error in http connection " + e.toString());
		}
		// convert response to string
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
            }
            is.close();
            result=sb.toString();
		} catch (Exception e) {
			Log.e("log_tag", "Error converting result " + e.toString());
		}
		//parse json data
		
	    try{
	    	    
	            JSONArray jArray = new JSONArray(result);
	            JSONObject json_data = new JSONObject();
	            for(int i=0;i<jArray.length();i++){
	            	  json_data = jArray.getJSONObject(i);
	                    //Get an output to the screen
	                  
	                    //returnString += "\n\t" + jArray.getJSONObject(i) + json_data.getString("name"); 
	            	  
	            }
	            infoTxt.setText(json_data.getString("email"));
                if(json_data.getString("email").equals(email))
                {//compare response values
        			valiResult = true;
        			infoTxt.setText("Validation Success");
                }
	    }catch(JSONException e){
	            Log.e("log_tag", "Error parsing data "+e.toString());
	            e.printStackTrace();
	            
	    }
	    //valiResult = true; //set for test!!!!!
		return valiResult;
	}
	
}
