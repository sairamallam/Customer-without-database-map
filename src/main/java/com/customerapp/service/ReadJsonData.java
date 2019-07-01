package com.customerapp.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import com.customerapp.model.CustomerDetails;

public class ReadJsonData
{
   public Map<Integer,CustomerDetails> jsonToMap() throws org.json.simple.parser.ParseException
   {
       //JSON parser object to parse read file
       JSONParser jsonParser = new JSONParser();
        Map<Integer, CustomerDetails> customermap = new HashMap<Integer, CustomerDetails>();
        
       try 
       (FileReader reader = new FileReader("C:\\Users\\ninja\\Documents\\Springboot-workspace\\customer\\src\\main\\resources\\static\\customer.json"))
       {
    	   //Read JSON file
           Object obj = jsonParser.parse(reader);
           JSONArray customerlist =  (JSONArray) obj;
			
			  for(int i=0;i<customerlist.size();i++) 
			  { 
				  CustomerDetails customer = new CustomerDetails();
			  JSONObject jsonObject =(JSONObject)customerlist.get(i); 
			  
			  customer.setId(Integer.parseInt(jsonObject.get("id").toString()));
			  customer.setName((String)jsonObject.get("name").toString());
			  customer.setPhone(Long.parseLong(jsonObject.get("phone").toString()));
			  customer.setRole((String)jsonObject.get("role").toString());
			  
			  customermap.put(customer.getId(), customer);
			  }
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
	return customermap;
   }
}