package com.example.appcours;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.toolbox.JsonObjectRequest;

public class MainActivity extends AppCompatActivity {

    public void jokeSetup(Joke joke){
        TextView jokeCategory = findViewById(R.id.jokeCategory);
        TextView jokeSetup = findViewById(R.id.jokeSetup);
        TextView jokeDelivery = findViewById(R.id.jokeDelivery);
        Button jokeButton = findViewById(R.id.jokeButton);

        jokeDelivery.setText("");
        jokeSetup.setText(joke.getSetup());
        jokeCategory.setText(joke.getCategory());

        jokeButton.setOnClickListener((e) -> {
            jokeDelivery.setText(joke.getDelivery());
        });
    }

    public void generateJoke(){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                "https://v2.jokeapi.dev/joke/Any?lang=fr",
                response -> {
                    jokeSetup(new Joke(response));
                },

                error -> Log.d("volley", error.toString())
        );

        RequestManager.getInstance(this).addToRequestQueue(jsonObjectRequest);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateJoke();

        Button generateButton = findViewById(R.id.generateButton);
        generateButton.setOnClickListener((view) -> generateJoke());
    }
}