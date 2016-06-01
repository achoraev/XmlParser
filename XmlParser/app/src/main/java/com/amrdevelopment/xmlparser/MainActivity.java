package com.amrdevelopment.xmlparser;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.amrdevelopment.xmlparser.deals.ParseDealsOffers;
import com.amrdevelopment.xmlparser.parse.ParseMainOffer;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);

        new LoadXMLDeals().execute();

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

    class LoadXMLDeals extends AsyncTask<Void, Integer, List<ParseMainOffer>> {

        @Override
        protected void onPreExecute() {
            mProgressBar.setVisibility(ProgressBar.VISIBLE);
        }

        @Override
        protected List<ParseMainOffer> doInBackground(Void... params) {
            List<ParseMainOffer> dealsOffers =  new ParseDealsOffers().createPullParser(getApplicationContext());
            for (int i = 1; i < 100; i++) {
                publishProgress(i);
            }
            return dealsOffers;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            mProgressBar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(List<ParseMainOffer> result) {
            Toast.makeText(MainActivity.this, "Size is: " + result.size(), Toast.LENGTH_LONG).show();
            mProgressBar.setVisibility(ProgressBar.INVISIBLE);
        }

    }
}