package com.example.recipify.Auth;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class User {

    public static DatabaseReference USER_REF = FirebaseDatabase.getInstance().getReference().child("Users");

    private String fullname;
    private String email;
    private String id;
    private boolean isSubscribed;

    public String getListRecip() {
        return listRecip;
    }

    public void setListRecip(String listRecip) {
        this.listRecip = listRecip;
    }

    private String listRecip;
    public User() {
    }

    public User(String fullname, String email, String id, String listRecip) {
        this.fullname = fullname;
        this.email = email;
        this.id = id;
        this.listRecip = listRecip;
    }


    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return this.id;
    }

    public void setUid(String id) {
        this.id = id;
    }

    public boolean isSubscribed() {
        return isSubscribed;
    }

    public void setSubscribed(boolean subscribed) {
        isSubscribed = subscribed;
    }

    public static void addUser(String userId, String fullname, String email, String listRecip) {
        // Creating a User Object
        User user = new User(fullname, email, userId, listRecip);
        // Insert
        USER_REF.child(userId).setValue(user);
    }

    public static void updateName(String userId, String newName) {
        USER_REF.child(userId).child("fullname").setValue(newName);
    }

    public static void updateSubscription(String userId, boolean subscriptionStatus) {
        USER_REF.child(userId).child("subscribed").setValue(subscriptionStatus);
    }

    public static User getUserbyEmail(List<User> userList, String email) {
        for (User user : userList) {
            if (user.email.equals(email)) {
                return user;
            }
        }
        return null;
    }
}