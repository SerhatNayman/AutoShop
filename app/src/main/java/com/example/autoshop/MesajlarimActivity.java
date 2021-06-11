package com.example.autoshop;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.autoshop.Adapters.MesajlarimAdapter;
import com.example.autoshop.Models.IlanVerPojo;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MesajlarimActivity extends AppCompatActivity{

    String userId;
    SharedPreferences sharedPreferences;
    DatabaseReference reference;
    List<String> otherIdList;
    MesajlarimAdapter mesajlarimAdapter;
    ListView mesajlarlistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesajlarim);
        otherIdList = new ArrayList<>();
        sharedPreferences = getApplicationContext().getSharedPreferences("giris", 0);
        userId = sharedPreferences.getString("uyeid", null);
        reference = FirebaseDatabase.getInstance().getReference();
        mesajlarimAdapter = new MesajlarimAdapter(otherIdList, userId, getApplicationContext(),MesajlarimActivity.this);
        mesajlarlistview = findViewById(R.id.mesajlarimlistview);
        mesajlarlistview.setAdapter(mesajlarimAdapter);

        listele();
    }

    public void listele() {

        reference.child("Messages/").child(userId).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                otherIdList.add(snapshot.getKey());
                mesajlarimAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}