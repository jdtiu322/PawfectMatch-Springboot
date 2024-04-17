//package com.example.pawfecttmatch.service;
//
//import com.example.pawfecttmatch.models.User;
//import com.google.api.core.ApiFuture;
//import com.google.cloud.firestore.DocumentSnapshot;
//import com.google.cloud.firestore.Firestore;
//import com.google.cloud.firestore.QuerySnapshot;
//import com.google.cloud.firestore.WriteResult;
//import com.google.firebase.cloud.FirestoreClient;
//import org.springframework.stereotype.Service;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.ExecutionException;
//
//public class FirebaseService {
//    public Firestore getFirestore() {
//        return FirestoreClient.getFirestore();
//    }
//
//    public String saveUser(User user) throws ExecutionException, InterruptedException {
//        Firestore db = getFirestore();
//        ApiFuture<WriteResult> apiFuture = db.collection("users").document(user.getUserId()).set(user);
//        return apiFuture.get().getUpdateTime().toString();
//    }
//
//    public List<User> getAllUsers() throws ExecutionException, InterruptedException {
//        Firestore db = getFirestore();
//        ApiFuture<QuerySnapshot> querySnapshot = db.collection("users").get();
//
//        List<User> userList = new ArrayList<>();
//        for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
//            userList.add(document.toObject(User.class));
//        }
//        return userList;
//    }
//}
//
