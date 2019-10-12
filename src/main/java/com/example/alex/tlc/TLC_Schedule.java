package com.example.alex.tlc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;
import org.jsoup.Connection.Response;

import java.io.IOException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;


public class TLC_Schedule extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button login;
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
                validate(username.getText().toString(),password.getText().toString());
            }
        });

    }


    private void validate(String username, String password){

        //input username & password and save to variables
        //push enter
        //opens mytlc.bestbuy.com
        //redireict since no javascript
        //post credentials
        //check for "Welcome Alexander"
            //change state
        //else invalid login toast

        try {
            Document doc = Jsoup.connect("http://mytlc.bestbuy.com").get();
            URL url = new URL("https://mytlc.bestbuy.com/");
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setRequestProperty("username", username);
            conn.setRequestProperty("password", password);
            conn.setRequestMethod("POST");
            Elements elements = doc.select("span.navbar-brand");
            for (Element e : elements){
                if(e.text() == "Welcome Alexander") {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "You did it DORK",
                            Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Incorrect Login",
                    Toast.LENGTH_SHORT);
            toast.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }



        }

    }



