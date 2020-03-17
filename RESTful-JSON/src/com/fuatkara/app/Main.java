package com.fuatkara.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
	public static void main(String[] args) {
		int id=1;
		String name = "Fuat";
		String surname = "Kara";
		
		try {
			URL url = new URL("http://localhost:8080/RESTful-JSONServer/rest/user/information"+ id + "/" + name + "/" + surname);
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");  // Burada diyoruz ki yukaridaki adresle ne yapicaz,bizde diyoruz kim,GET yapicaz, postman'deki gibi
			connection.setRequestProperty("Accept", "application/json"+";charset=utf-8"); //buraya application/json yazsak json gelecek.
			
			if(connection.getResponseCode() != 200) {
				throw new RuntimeException("FUAT HTTP CODE :" + connection.getResponseCode());
			}
			//Birseyi buffer'lamak bellekte onlari biriktiriyorsun sonra kullaniyorsun.
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String result = bufferedReader.readLine();
			System.out.println(result);
			
			connection.disconnect();
			
		}catch (MalformedURLException e) {
			System.err.println("ERRROROROR" + e);    //err.println
			e.printStackTrace(); 					//ve buda tam hatanin aciklamisni gosteriyor
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}

























