package com.amrdevelopment.xmlparser;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.amrdevelopment.xmlparser.deals.ParseDealsOffers;
import com.amrdevelopment.xmlparser.parse.ParseMainOffer;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<ParseMainOffer> dealsOffers =  new ParseDealsOffers().createPullParser(getApplicationContext());

        Log.i("Parse", String.valueOf(dealsOffers.size()));

//        ParseMainOffer current = new ParseMainOffer();
//        current.setId(123456);
//        current.setCities("Cities");
//        current.setCategories("Categories");
//        current.setTitle("Title");
//        current.setDescription("Desc");
//        current.setTerms("Terms");
////        current.setPrice(price);
//        current.setSold(150);
////        current.setValidation(valid);
//        current.setLink("Link");
////        current.setPictures(pics);
////        current.setMerchants(currentMerc);
//        current.setPriority(100);
//        current.setRpvlt(10);
//        current.setRpv24(24);
//        current.saveInBackground();
    }
}