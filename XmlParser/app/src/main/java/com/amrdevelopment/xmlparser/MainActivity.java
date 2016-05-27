package com.amrdevelopment.xmlparser;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.amrdevelopment.xmlparser.parse.ParseMainOffer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ParseObject testObject = new ParseObject("TestObject");
//        testObject.put("foo", "bar");
//        testObject.saveInBackground();

        ParseMainOffer current = new ParseMainOffer();
        current.setId(123456);
        current.setCities("Cities");
        current.setCategories("Categories");
        current.setTitle("Title");
        current.setDescription("Desc");
        current.setTerms("Terms");
//        current.setPrice(price);
        current.setSold(150);
//        current.setValidation(valid);
        current.setLink("Link");
//        current.setPictures(pics);
//        current.setMerchants(currentMerc);
        current.setPriority(100);
        current.setRpvlt(10);
        current.setRpv24(24);
        current.saveInBackground();
    }
}
