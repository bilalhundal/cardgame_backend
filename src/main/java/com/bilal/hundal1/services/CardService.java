package com.bilal.hundal1.services;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bilal.hundal1.models.Card;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
/**
 * This is main Service class where all firebase database crud operations are performed
 * 
 */
@Service
public class CardService {
	@Autowired
	FirebaseApp firebaseApp;
	//method for RealTime database
	public boolean addCard(Card card) {
		DatabaseReference ref = FirebaseDatabase.getInstance("https://aws-project-917b9-default-rtdb.firebaseio.com").getReference("cards");
			ref.child(card.getId()).setValue(card,null);
			return true;
		
	}
	
	// This method for firestore
	/*
	public boolean addCard(Card card) {
	      Firestore dbFirestore=FirestoreClient.getFirestore();
		  ApiFuture<WriteResult> collectionApiFuture=dbFirestore.collection("cards").document(card.getId()).set(card);
		try {
			 collectionApiFuture.get();
			return true;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}*/
	
	public Card getCard(String id) throws InterruptedException, ExecutionException {
		System.out.println("called");
		DatabaseReference ref = FirebaseDatabase.getInstance("https://aws-project-917b9-default-rtdb.firebaseio.com").getReference("cards").child(id);
		 CompletableFuture<DataSnapshot> future = new CompletableFuture<>();
	        ref.addListenerForSingleValueEvent(new ValueEventListener() {
				
				@Override
				public void onDataChange(DataSnapshot snapshot) {
					future.complete(snapshot);
					
				}
				
				@Override
				public void onCancelled(DatabaseError error) {
					future.completeExceptionally(error.toException());
					
				}
			});
	        DataSnapshot dataSnapshot = future.get();
	        return dataSnapshot.getValue(Card.class);
	}
	
	//This is method for getting card using fireStore
	/*
	public Card getCard(String id) throws InterruptedException, ExecutionException {
		Firestore dbFirestore=FirestoreClient.getFirestore();
		DocumentReference documentReference=dbFirestore.collection("cards").document(id);
		ApiFuture<DocumentSnapshot> future=documentReference.get();
		DocumentSnapshot document=future.get();
		if(document.exists()) {
			return document.toObject(Card.class);
		}
		return null;
	}*/
public boolean deleteCard(String cardId) {
	DatabaseReference ref = FirebaseDatabase.getInstance("https://aws-project-917b9-default-rtdb.firebaseio.com").getReference().child("cards");
	ref.child(cardId).removeValueAsync();
		return true;
		
	}
	//delete method by using firestore
	/*public boolean deleteCard(String cardId) {
		
		Firestore dbFirestore=FirestoreClient.getFirestore();
		ApiFuture<WriteResult> future=dbFirestore.collection("cards").document(cardId).delete();
		try {
			future.get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
		
	}*/
	
	public boolean updateCard(Card card) {
		DatabaseReference ref = FirebaseDatabase.getInstance("https://aws-project-917b9-default-rtdb.firebaseio.com").getReference().child("cards");
		ref.child(card.getId()).setValue(card,null);
		return true;
		
	}
	//this is updateCard Method by using fireStore
	/*public boolean updateCard(Card card) {
		Firestore dbFirestore=FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionApiFuture=dbFirestore.collection("cards").document(card.getId()).set(card);
		try {
			 collectionApiFuture.get();
			 return true;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}*/

}















