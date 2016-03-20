package com.example.andoird.agenda;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by NoteSamsung on 19/03/2016.
 */
public class Contact {
    private String name;
    private String phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

     public JSONObject toJson() {
        JSONObject obj = new JSONObject();

        try {
            obj.put("name", name);
            obj.put("phoneNumber", phoneNumber);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return obj;
    }
}
