package com.amrdevelopment.xmlparser;

import com.amrdevelopment.xmlparser.parse.*;
import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParseObject;

/**
 * Created on 27-May-16
 */
public class Application extends android.app.Application{

    @Override
    public void onCreate() {
        super.onCreate();
        //        Parse.enableLocalDatastore(this);
        ParseObject.registerSubclass(ParseMainOffer.class);
        ParseObject.registerSubclass(ParseContact.class);
        ParseObject.registerSubclass(ParseMerchant.class);
        ParseObject.registerSubclass(ParsePicture.class);
        ParseObject.registerSubclass(ParsePlace.class);
        ParseObject.registerSubclass(ParsePrice.class);
        ParseObject.registerSubclass(ParseValidation.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                        .applicationId("i22R4Pu2LfoJfxCsBZcAseFwVrcFLcv28cSELAF2")
                        .clientKey("c1qyL40oPnQSrhRPS7oQQe4XE5qzt75XWVQIWXed")
                        .server("https://gepioferta.azurewebsites.net/parse/")
//                .enableLocalDataStore()
                        .build()
        );

        ParseInstallation.getCurrentInstallation().saveInBackground();
    }
}
