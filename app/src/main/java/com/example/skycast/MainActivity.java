package com.example.skycast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

//    static void prediction(String temp_c, String wind_kph,String wind_degree,String wind_dir,String pressure_mb, String precip_mm, String humidity,String cloud,String feelslike_c,String feelslike_f,String vis_km,String vis_miles,String gust_mph,String gust_kph, String state,String city){
//        String api = "https://rain-ozca.onrender.com/predict";
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, api,new )
//    }

    TextView textView5, textView8, textView4, textView6, textView50, textView51, textView41, textView40,textView61,textView60;
    TextView ttemp_c, twind_kph, twind_degree, twind_dir, tpressure_mb, tprecip_mm, thumidity, tcloud, tfeelslike_c, tfeelslike_f, tvis_km, tvis_miles, tgust_mph, tgust_kph, tstate, tcity;
    String url;
    String api = "https://rain-ozca.onrender.com/predict";
    Button pred;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pred = (Button) findViewById(R.id.predict);

        ttemp_c = findViewById(R.id.temp_c);
        twind_kph = findViewById(R.id.wind_kph);
        twind_degree = findViewById(R.id.wind_degree);
        twind_dir = findViewById(R.id.wind_dir);
        tpressure_mb = findViewById(R.id.pressure_mb);
        tprecip_mm = findViewById(R.id.precip_mm);
        thumidity = findViewById(R.id.humidity);
        tcloud = findViewById(R.id.cloud);
        tfeelslike_c = findViewById(R.id.feelslike_c);
        tfeelslike_f = findViewById(R.id.feelslike_f);
        tvis_km = findViewById(R.id.vis_km);
        tvis_miles = findViewById(R.id.vis_miles);
        tgust_mph = findViewById(R.id.gust_mph);
        tgust_kph = findViewById(R.id.gust_kph);
        tstate = findViewById(R.id.state);
        tcity = findViewById(R.id.city);
        textView4 = findViewById(R.id.textView4);
        textView8 = findViewById(R.id.textView8);
        textView5 = findViewById(R.id.textView5);
        textView6 = findViewById(R.id.textView6);
        textView50 = findViewById(R.id.textView50);
        textView51 = findViewById(R.id.textView51);
        textView41 = findViewById(R.id.textView41);
        textView40 = findViewById(R.id.textView40);
        textView61 = findViewById(R.id.textView61);
        textView60 = findViewById(R.id.textView60);

//        textView2 = findViewById(R.id.textView2);


        url = "https://api.weatherapi.com/v1/current.json?key=395bcdb6eb824921805184723232603&q=Mumbai&aqi=no";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject location = response.getJSONObject("location");
                            String city_c = location.getString("name");
                            String datetime = location.getString("localtime");
                            String date = datetime.split(" ")[0];
                            JSONObject current = response.getJSONObject("current");
                            String temp_c = current.getString("temp_c");
                            ttemp_c.setText(temp_c);
                            String wind_kph = current.getString("wind_kph");
                            twind_kph.setText(wind_kph);
                            String wind_degree = current.getString("wind_degree");
                            twind_degree.setText(wind_degree);

                            String wind_dirc = current.getString("wind_dir");
                            switch (wind_dirc) {
                                case "E":
                                    twind_dir.setText("0");
                                    break;
                                case "ENE":
                                    twind_dir.setText("1");
                                    break;
                                case "ESE":
                                    twind_dir.setText("2");
                                    break;
                                case "N":
                                    twind_dir.setText("3");
                                    break;
                                case "NE":
                                    twind_dir.setText("4");
                                    break;
                                case "NNE":
                                    twind_dir.setText("5");
                                    break;
                                case "NNW":
                                    twind_dir.setText("6");
                                    break;
                                case "NW":
                                    twind_dir.setText("7");
                                    break;
                                case "S":
                                    twind_dir.setText("8");
                                    break;
                                case "SE":
                                    twind_dir.setText("9");
                                    break;
                                case "SSE":
                                    twind_dir.setText("10");
                                    break;
                                case "SSW":
                                    twind_dir.setText("11");
                                    break;
                                case "SW":
                                    twind_dir.setText("12");
                                    break;
                                case "W":
                                    twind_dir.setText("13");
                                    break;
                                case "WNW":
                                    twind_dir.setText("14");
                                    break;
                                case "WSW":
                                    twind_dir.setText("15");
                                    break;
                            }
                            String pressure_mb = current.getString("pressure_mb");
                            tpressure_mb.setText(pressure_mb);
                            String precip_mm = current.getString("precip_mm");
                            tprecip_mm.setText(precip_mm);
                            String humidity = current.getString("humidity");
                            thumidity.setText(humidity);
                            String cloud = current.getString("cloud");
                            tcloud.setText(cloud);
                            String feelslike_c = current.getString("feelslike_c");
                            tfeelslike_c.setText(feelslike_c);
                            String feelslike_f = current.getString("feelslike_f");
                            tfeelslike_f.setText(feelslike_f);
                            String vis_km = current.getString("vis_km");
                            tvis_km.setText(vis_km);
                            String vis_miles = current.getString("vis_miles");
                            tvis_miles.setText(vis_miles);
                            String gust_mph = current.getString("gust_mph");
                            tgust_mph.setText(gust_mph);
                            String gust_kph = current.getString("gust_kph");
                            tgust_kph.setText(gust_kph);
                            tcity.setText("93");
                            tstate.setText("19");
//                            prediction(temp_c,	wind_kph,	wind_degree,	wind_dir,	pressure_mb,	precip_mm,	humidity,	cloud,	feelslike_c,	feelslike_f,	vis_km,	vis_miles,	gust_mph,	gust_kph,	state,	city);

                            //String datetime = response.getString("location");
                            //String date = datetime.split(" ")[0];
//                            String current = response.getString("current");
                            textView4.setText(date);
                            textView5.setText(temp_c + " ℃");
                            textView6.setText("Mumbai");
                            textView50.setText(wind_kph+ " kph   ");
                            textView51.setText(humidity +" g.m-3");
                            textView41.setText("          "+cloud + " oktas");
                            textView40.setText(wind_dirc+"    ");
                            textView60.setText(gust_kph +" kph");
                            textView61.setText(pressure_mb+" mb");


                        } catch (Exception e) {

                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Volley.newRequestQueue(this).add(request);

        pred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringRequest stringRequest = new StringRequest(Request.Method.POST, api, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String re = jsonObject.getString("Rain");
                            Intent intent;
                            if(re.equals("1")) {
                                intent = new Intent(MainActivity.this, rain.class);

                            } else {
                                intent = new Intent(MainActivity.this, sunny.class);

                            }
                            startActivity(intent);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("temp_c", ttemp_c.getText().toString());
                        params.put("wind_kph", twind_kph.getText().toString());
                        params.put("wind_degree", twind_degree.getText().toString());
                        params.put("wind_dir", twind_dir.getText().toString());
                        params.put("pressure_mb", tpressure_mb.getText().toString());
                        params.put("precip_mm", tprecip_mm.getText().toString());
                        params.put("humidity", thumidity.getText().toString());
                        params.put("cloud", tcloud.getText().toString());
                        params.put("feelslike_c", tfeelslike_c.getText().toString());
                        params.put("feelslike_f", tfeelslike_f.getText().toString());
                        params.put("vis_km", tvis_km.getText().toString());
                        params.put("vis_miles", tvis_miles.getText().toString());
                        params.put("gust_mph", tgust_mph.getText().toString());
                        params.put("gust_kph", tgust_kph.getText().toString());
                        params.put("state", tstate.getText().toString());
                        params.put("city", tcity.getText().toString());

                        return params;
                    }

                };
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                queue.add(stringRequest);


            }
        });

    }
}


