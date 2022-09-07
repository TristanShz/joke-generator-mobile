package com.example.appcours;

import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.function.Function;

public class Joke {
    private Integer id;
    private String category;
    private String setup;
    private String delivery;

    public Joke(Integer id, String category, String setup, String delivery) {
        this.id = id;
        this.category = category;
        this.setup = setup;
        this.delivery = delivery;
    }

    public Joke(JSONObject json){
        try{
            this.id = json.getInt("id");
            this.category = json.getString("category");
            this.setup = json.getString("setup");
            this.delivery = json.getString("delivery");
        }catch(JSONException e){
            e.printStackTrace();
            this.id = 0;
            this.category = "";
            this.setup = "";
            this.delivery = "";
        }
    }

    public String getCategory() {
        return category;
    }

    public String getSetup() {
        return setup;
    }

    public String getDelivery() {
        return delivery;
    }

}
