package com.amrdevelopment.xmlparser;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.amrdevelopment.xmlparser.deals.ParseDealsOffers;
import com.amrdevelopment.xmlparser.parse.ParseMainOffer;
import com.parse.ParseException;
import com.parse.SaveCallback;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);

        new LoadXMLDeals().execute();
    }

    class LoadXMLDeals extends AsyncTask<Void, Integer, List<ParseMainOffer>> {

        @Override
        protected void onPreExecute() {
            mProgressBar.setVisibility(ProgressBar.VISIBLE);
        }

        @Override
        protected List<ParseMainOffer> doInBackground(Void... params) {
            List<ParseMainOffer> currentOffers =  new ParseDealsOffers().createPullParser(getApplicationContext());
            for (int i = 1; i < 100; i++) {
                publishProgress(i);
            }
            return currentOffers;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            mProgressBar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(List<ParseMainOffer> result) {
            saveDataOnParse(result);
            Toast.makeText(MainActivity.this, "Size is: " + result.size(), Toast.LENGTH_LONG).show();
            mProgressBar.setVisibility(ProgressBar.INVISIBLE);
        }

    }

    private void saveDataOnParse(List<ParseMainOffer> dealsOffers) {
        for(int i = 0; i < 5; i++){
            ParseMainOffer cur = dealsOffers.get(i);
            final int finalI = i;
            // todo check if id exists
            cur.saveEventually(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if(e == null) {
                        Toast.makeText(MainActivity.this, String.format("Object %d is save successfully!", finalI), Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
}