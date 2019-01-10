package com.example.lenovo.roomdatabasedesign;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public EditText userId,userName,userEmail;
    Button btnAddUser;
    public static MyAppDatabase appDatabase;
    public User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userId = findViewById(R.id.user_id);
        userName =findViewById(R.id.user_name);
        userEmail = findViewById(R.id.user_email);
        btnAddUser = findViewById(R.id.add_user);

        appDatabase = Room.databaseBuilder(getApplicationContext(),MyAppDatabase.class,"userdb").allowMainThreadQueries().build();

        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = new User();
                user.setId(userId.getId());
                user.setName(userName.getText().toString());
                user.setEmail(userEmail.getText().toString());
                appDatabase.myDao().addUser(user);
                Toast.makeText(MainActivity.this, "Successful", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
