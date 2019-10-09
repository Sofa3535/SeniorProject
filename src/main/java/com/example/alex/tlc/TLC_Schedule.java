package com.example.alex.tlc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.jsoup.Connection.Response;


public class TLC_Schedule extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button login;
    private String url = "https://mytlc.bestbuy.com/";
    private String bbyId="Admin";
    private String bbyPassword="password";
    Response response;


    public TLC_Schedule() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tlc__schedule);

        username = (EditText)findViewById(R.id.usernameText);
        password = (EditText)findViewById(R.id.passwordText);
        login = (Button)findViewById(R.id.loginButton);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(username.getText().toString(),password.getText().toString(),bbyId,bbyPassword);
            }
        });

    }


    private void validate(String username, String password, String compareUser,String comparePass){

        //input username & password and save to variables
        //push enter
        //opens mytlc.bestbuy.com
        //redireict since no javascript
        //post credentials



        if((username.equals(bbyId)) && (password.equals(bbyPassword))){
            Intent intent = new Intent (TLC_Schedule.this, Schedule.class);
            startActivity(intent);

            //Check for status 200 for login page
            //return true?
            if (200 == response.statusCode()) {

                Toast toast = Toast.makeText(getApplicationContext(),
                        "200",
                        Toast.LENGTH_SHORT);
                toast.show();
                /* what ever you want to do*/
            }

        }
        else{
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Incorrect Login",
                    Toast.LENGTH_SHORT);
            toast.show();
        }
    }


}
