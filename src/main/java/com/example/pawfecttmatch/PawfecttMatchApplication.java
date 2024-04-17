package com.example.pawfecttmatch;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;

@SpringBootApplication
public class PawfecttMatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(PawfecttMatchApplication.class, args);
		try {
			FileInputStream serviceAccount = new FileInputStream("C:\\Users\\Joaquin David P. Tiu\\Downloads\\pawfecttmatch\\pawfecttmatch\\src\\main\\java\\com\\example\\pawfecttmatch\\serviceAccount.json");

			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.setDatabaseUrl("https://pawfectmatch-172ef-default-rtdb.asia-southeast1.firebasedatabase.app")
					.build();
			FirebaseApp.initializeApp(options);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
