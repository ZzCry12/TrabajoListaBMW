package com.example.trabajo1ud;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class CochesApi {


    ArrayList<Coches> getmodelosBMW() {
        String url = "https://private-01f1f9-muchosbmw.apiary-mock.com/muchosbmw";


        try {
            String result = HttpUtils.get(url);


            JSONObject jsonresults = new JSONObject(result);
            JSONArray results = jsonresults.getJSONArray("results");

            ArrayList<Coches> listabmw = new ArrayList<>();


            for (int i = 0; i < results.length(); i++) {
                try {
                    JSONObject cochesJSON = results.getJSONObject(i);

                    System.out.println(cochesJSON);

                    Coches coche = new Coches();
                    coche.setYear(cochesJSON.getInt("year"));
                    coche.setId(cochesJSON.getInt("id"));
                    coche.setHorsepower(cochesJSON.getInt("horsepower"));
                    coche.setMake(cochesJSON.getString("make"));
                    coche.setModel(cochesJSON.getString("model"));
                    coche.setPrice(cochesJSON.getInt("price"));
                    coche.setImg_url(cochesJSON.getString("img_url"));
                    listabmw.add(coche);


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            return listabmw;
        } catch (IOException e) {
            e.printStackTrace();

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }


}


