package com.bilal.hundal1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ResourceUtils;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@SpringBootApplication
public class CardGameBackendApplication {
	
	public static void main(String[] args) {
		
					
		SpringApplication.run(CardGameBackendApplication.class, args);
	
}
@Bean
public FirebaseApp firebaseApp() {
	FirebaseApp firebaseApp=null;
	try {
		InputStream inputStream = CardGameBackendApplication.class.getClassLoader().getResourceAsStream("serviceAccountKey.json");    
		 FirebaseOptions options;
			   options = new FirebaseOptions.Builder()
				  .setCredentials(GoogleCredentials.fromStream(inputStream))
				  .build(); if(FirebaseApp.getApps().isEmpty()) { 
			         firebaseApp =   FirebaseApp.initializeApp(options);
			        
				  }
			
	}catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
}
	return firebaseApp;
}

}
