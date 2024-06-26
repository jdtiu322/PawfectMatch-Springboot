package com.example.pawfecttmatch;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;

@SpringBootApplication
public class PawfecttMatchApplication {

    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = PawfecttMatchApplication.class.getClassLoader();

        // Load serviceAccountKey.json as input stream
        InputStream serviceAccountStream = classLoader.getResourceAsStream("serviceAccountKey.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccountStream))
                .setDatabaseUrl("https://pawfectmatch-172ef-default-rtdb.asia-southeast1.firebasedatabase.app")
                .build();

        FirebaseApp.initializeApp(options);

        SpringApplication.run(PawfecttMatchApplication.class, args);
    }
}
