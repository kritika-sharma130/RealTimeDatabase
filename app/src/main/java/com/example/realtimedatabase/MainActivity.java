package com.example.realtimedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
EditText e1,e2,e3,e4;
Button b1;
FirebaseDatabase firebaseDatabase;
DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.editTextTextPersonName);
        e2=(EditText)findViewById(R.id.editTextTextPassword);
        e3=(EditText)findViewById(R.id.editTextTextPhoneNumber);
        e4=(EditText)findViewById(R.id.editTextEmail);
        b1=(Button)findViewById(R.id.button);
        firebaseDatabase=FirebaseDatabase.getInstance();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              databaseReference=firebaseDatabase.getReference("Users");
              String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                String s3=e3.getText().toString();
                String s4=e4.getText().toString();
                if(s3.length()!=10){
                    Toast.makeText(MainActivity.this, "Enter a valid phone number", Toast.LENGTH_SHORT).show();
                }else{
                    Users users=new Users(s1,s2,s3,s4);
                    databaseReference.child(s3).setValue(users);
                    Toast.makeText(MainActivity.this, "Database updated", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}