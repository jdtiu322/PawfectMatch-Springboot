package com.example.pawfecttmatch.service;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.pawfecttmatch.models.User;
import com.example.pawfecttmatch.controller.UserController;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firestore.v1.Write;
import com.google.protobuf.Api;

@Service
public class UserService {

    public static String createUser(User user) throws InterruptedException, ExecutionException {

        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("users").document(user.getUserId()).set(user);
        
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public static User getUser(String documentId) throws InterruptedException, ExecutionException{
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("users").document(documentId);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        User user;
        if(document.exists()){
            user = document.toObject(User.class);
            return user;
        }
        return null;
    }
    

    public static String updateUser(User user) throws InterruptedException, ExecutionException {
        Firestore dbFirestore2 = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore2.collection("users").document(user.getUserId()).set(user);

        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public static String deleteUser(String documentId) {
       Firestore dbFirestore = FirestoreClient.getFirestore();
       ApiFuture<WriteResult> writeResult = dbFirestore.collection("users").document(documentId).delete();
       return "Successfully deleted " + documentId;
    }

}
