package com.example.pawfecttmatch.service;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.pawfecttmatch.models.Dog;
import com.example.pawfecttmatch.controller.DogController;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firestore.v1.Write;
import com.google.protobuf.Api;

@Service
public class DogService {

    public static String createDog(Dog dog) throws InterruptedException, ExecutionException {

        Firestore dbFirestore = FirestoreClient.getFirestore();
        
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("dogs").document(dog.getDogId()).set(dog);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public static Dog getDog(String documentId) throws InterruptedException, ExecutionException{
        Firestore dbFirestore = FirestoreClient.getFirestore();

        
        DocumentReference documentReference = dbFirestore.collection("dogs").document(documentId);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        Dog dog;
        if(document.exists()){
            dog = document.toObject(Dog.class);
            return dog;
        }
        return null;
    }
    

    public static String updateDog(Dog dog) throws InterruptedException, ExecutionException {
        Firestore dbFirestore2 = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore2.collection("dogs").document(dog.getDogId()).set(dog);

        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public static String deleteDog(String documentId) {
       Firestore dbFirestore = FirestoreClient.getFirestore();
       ApiFuture<WriteResult> writeResult = dbFirestore.collection("dogs").document(documentId).delete();
       return "Successfully deleted " + documentId;
    }

}
