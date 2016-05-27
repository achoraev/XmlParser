package com.amrdevelopment.xmlparser;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.parse.Parse;
import com.parse.ParseInstallation;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Parse.enableLocalDatastore(this);
//        ParseObject.registerSubclass(ParseMainOffer.class);
//        ParseObject.registerSubclass(ParseContact.class);
//        ParseObject.registerSubclass(ParseMerchant.class);
//        ParseObject.registerSubclass(ParsePicture.class);
//        ParseObject.registerSubclass(ParsePlace.class);
//        ParseObject.registerSubclass(ParsePrice.class);
//        ParseObject.registerSubclass(ParseValidation.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("i22R4Pu2LfoJfxCsBZcAseFwVrcFLcv28cSELAF2")
                .server("https://gepioferta.azurewebsites.net/parse/")
//                .enableLocalDataStore()
                .build()
        );

        ParseInstallation.getCurrentInstallation().saveEventually();

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
