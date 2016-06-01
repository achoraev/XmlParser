package com.amrdevelopment.xmlparser.deals;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import com.amrdevelopment.xmlparser.R;
import com.amrdevelopment.xmlparser.parse.ParseMainOffer;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 01-Jun-16
 */
public class ParseDealsOffers extends AppCompatActivity{


    private String Id = "";
    private String cities = "";
    private String categories = "";
    private String title = "";
    private String description = "";
    private String terms = "";
//    private Price price;
    private Integer sold = 0;
//    private Validation validation;
    private String link = "";
//    private List<Picture> pictures;
//    private Merchant merchants;
//    private List<Place> places;
    private Integer priority = 0;
    private Integer rpvlt = 0;
    private Integer rpv24 = 0;

    private static final String OFFER_TAG = "offer";
    private static final String ID_ATTRIBUTE = "id";
    private static final String CITIES_TAG = "cities";
    private static final String CATEGORIES_TAG = "categories";
    private static final String TITLE_TAG = "title";
    private static final String DESCRIPTION_TAG = "description";
    private static final String TERMS_TAG = "terms";
    private static final String SOLD_TAG = "sold";
    private static final String LINK_TAG = "link";
    private static final String PRIORITY_TAG = "priority";
    private static final String RPVLT_TAG = "rpvlt";
    private static final String RPV24_TAG = "rpv24";

    private XmlPullParser parser;
    List<ParseMainOffer> dealsOffers = new ArrayList<>();

    private boolean isParsingCities,
            isParsingCategories,
            isParsingTitle,
            isParsingDescription,
            isParsingTerms,
            isParsingSold,
            isParsingLink,
            isParsingPriority,
            isParsingRpvlt,
            isParsingRpv24,
            isParsingOffer;

    public List<ParseMainOffer> createPullParser(Context applicationContext) {
        try {
            // Create the Pull Parser
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            parser = factory.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);

            // Set the Parser's input to be the XML document in the HTTP Response
            InputStream is = applicationContext.getResources().openRawResource(R.raw.deals);
            parser.setInput(new InputStreamReader(is));

            // Get the first Parser event and start iterating over the XML document
            int eventType = parser.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_TAG) {
                    startTag(parser.getName());
                } else if (eventType == XmlPullParser.END_TAG) {
                    endTag(parser.getName());
                } else if (eventType == XmlPullParser.TEXT) {
                    text(parser.getText());
                }
                eventType = parser.next();
            }
            return dealsOffers;
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void startTag(String localName) {
        switch (localName) {
            case CITIES_TAG:
                isParsingCities = true;
                break;
            case CATEGORIES_TAG:
                isParsingCategories = true;
                break;
            case TITLE_TAG:
                isParsingTitle = true;
                break;
            case DESCRIPTION_TAG:
                isParsingDescription = true;
                break;
            case TERMS_TAG:
                isParsingTerms = true;
                break;
            case SOLD_TAG:
                isParsingSold = true;
                break;
            case LINK_TAG:
                isParsingLink = true;
                break;
            case PRIORITY_TAG:
                isParsingPriority = true;
                break;
            case RPVLT_TAG:
                isParsingRpvlt = true;
                break;
            case RPV24_TAG:
                isParsingRpv24 = true;
                break;
            case OFFER_TAG:
                isParsingOffer = true;
                Id = parser.getAttributeValue(null, ID_ATTRIBUTE);
                break;
        }
    }

    private void text(String text) {
        if (isParsingCities) {
            cities = text.trim();
        } else if (isParsingCategories) {
            categories = text.trim();
        } else if (isParsingTitle) {
            title = text.trim();
        } else if (isParsingDescription) {
            description = text.trim();
        } else if (isParsingTerms) {
            terms = text.trim();
        } else if (isParsingSold) {
            sold = Integer.valueOf(text.trim());
        } else if (isParsingLink) {
            link = text.trim();
        } else if (isParsingPriority) {
            priority = Integer.valueOf(text.trim());
        } else if (isParsingRpvlt) {
            rpvlt = Integer.valueOf(text.trim());
        } else if (isParsingRpv24) {
            rpv24 = Integer.valueOf(text.trim());
        }
    }

    private void endTag(String localName) {
        switch (localName) {
            case CITIES_TAG:
                isParsingCities = false;
                break;
            case CATEGORIES_TAG:
                isParsingCategories = false;
                break;
            case TITLE_TAG:
                isParsingTitle = false;
                break;
            case DESCRIPTION_TAG:
                isParsingDescription = false;
                break;
            case TERMS_TAG:
                isParsingTerms = false;
                break;
            case SOLD_TAG:
                isParsingSold = false;
                break;
            case LINK_TAG:
                isParsingLink = false;
                break;
            case PRIORITY_TAG:
                isParsingPriority = false;
                break;
            case RPVLT_TAG:
                isParsingRpvlt = false;
                break;
            case RPV24_TAG:
                isParsingRpv24 = false;
                break;
            case OFFER_TAG:
                isParsingOffer = false;
                saveParsedObject();
                Id = "";
                cities = "";
                categories = "";
                title = "";
                description = "";
                terms = "";
                sold = 0;
                link = "";
                priority = 0;
                rpvlt = 0;
                rpv24 = 0;
                break;
        }
    }

    private void saveParsedObject() {
        ParseMainOffer current = new ParseMainOffer();
        current.setId(Id);
        current.setCities(cities);
        current.setCategories(categories);
        current.setTitle(title);
        current.setDescription(description);
        current.setTerms(terms);
//        current.setPrice(price);
        current.setSold(sold);
//        current.setValidation(valid);
        current.setLink(link);
//        current.setPictures(pics);
//        current.setMerchants(currentMerc);
        current.setPriority(priority);
        current.setRpvlt(rpvlt);
        current.setRpv24(rpv24);
//        current.saveInBackground();
        dealsOffers.add(current);
    }
}
