package com.example.autoshop;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.autoshop.Adapters.MessageAdapter;
import com.example.autoshop.Models.IlanVerPojo;
import com.example.autoshop.Models.MessageModel;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageActivity extends AppCompatActivity {

    String userId, otherId, userTable, otherTable, key;
    SharedPreferences sharedPreferences;
    FirebaseDatabase database;
    DatabaseReference reference;
    EditText messageEditText;
    Button sendButton;
    List<MessageModel> list;
    MessageAdapter adapter;
    RecyclerView messageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        tanimla();
        action();
        load();

    }

    public void action() {


        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendMessage(messageEditText.getText().toString(), userId, otherId);
            }
        });

    }

    public void tanimla() {

        messageList = findViewById(R.id.messageListview);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
        messageEditText = findViewById(R.id.MessageEditText);
        sendButton = findViewById(R.id.sendButton);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference();
        otherId = OtherId.getOtherId();
        sharedPreferences = getApplicationContext().getSharedPreferences("giris", 0);
        userId = sharedPreferences.getString("uyeid", null);
        list = new ArrayList<>();
        adapter = new MessageAdapter(getApplicationContext(), list, userId);
        messageList.setLayoutManager(manager);
        messageList.setAdapter(adapter);


    }

    public void sendMessage(String messagebody, String Usrid, String OthId) {

        userTable = "Messages/" + userId + "/" + otherId;
        otherTable = "Messages/" + otherId + "/" + userId;
        key = reference.child("Messages").child(userTable).child(otherId).push().getKey();

        Map map = send(messagebody, Usrid, OthId);
        Map map2 = new HashMap();
        map2.put(userTable + "/" + key, map);
        map2.put(otherTable + "/" + key, map);

        messageEditText.setText("");

        reference.updateChildren(map2, new DatabaseReference.CompletionListener() {

            @Override
            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {


            }
        });


    }

    public Map send(String messagebody, String userId, String otherId) {
        Map message = new HashMap();
        message.put("Mesaj", messagebody);
        message.put("from", userId);
        message.put("to", otherId);
        return message;


    }

    public void load() {

        reference.child("Messages").child(userId).child(otherId).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                MessageModel m = snapshot.getValue(MessageModel.class);
                list.add(m);
                adapter.notifyDataSetChanged();  // adapteri guncelle

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