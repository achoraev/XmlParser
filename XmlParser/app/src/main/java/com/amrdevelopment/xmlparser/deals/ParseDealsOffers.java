package com.amrdevelopment.xmlparser.deals;

import android.content.Context;
import com.amrdevelopment.xmlparser.R;
import com.amrdevelopment.xmlparser.parse.ParseMainOffer;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created on 01-Jun-16
 */
public class ParseDealsOffers {

    private static final String ID_ATTRIBUTE = "id";
    private static final String OFFER_TAG = "offer";
    private static final String CITIES_TAG = "cities";
    private static final String CATEGORIES_TAG = "categories";
    private static final String TITLE_TAG = "title";
    private static final String DESCRIPTION_TAG = "description";
    private static final String TERMS_TAG = "terms";
    private static final String PICTURES_TAG = "picture";
    private static final String SOLD_TAG = "sold";
    private static final String ORIGINAL_PRICE_TAG = "original_price";
    private static final String PROMO_PRICE_TAG = "promo_price";
    private static final String DISCOUNT_TAG = "discount";
    private static final String END_DATE_TAG = "end";
    private static final String UPDATED_TAG = "updated";
    private static final String LINK_TAG = "link";
    private static final String MERCHANT_NAME_TAG = "name";
    private static final String MERCHANT_LATITUDE_TAG = "latitude";
    private static final String MERCHANT_LONGITUDE_TAG = "longtitude";
    private static final String PRIORITY_TAG = "priority";
    private static final String RPVLT_TAG = "rpvlt";
    private static final String RPV24_TAG = "rpv24";

    private List<String> pictures = new ArrayList<>();
    private XmlPullParser parser;
    private List<ParseMainOffer> dealsOffers = new ArrayList<>();
    private ParseMainOffer current = new ParseMainOffer();

    private boolean isParsingCities,
            isParsingCategories,
            isParsingTitle,
            isParsingDescription,
            isParsingTerms,
            isParsingPictures,
            isParsingOriginalPrice,
            isParsingPromoPrice,
            isParsingDiscount,
            isParsingEndDate,
            isParsingUpdated,
            isParsingSold,
            isParsingLink,
            isParsingMerchantName,
            isParsingMerchantLatitude,
            isParsingMerchantLongitude,
            isParsingPriority,
            isParsingRpvlt,
            isParsingRpv24;

    public List<ParseMainOffer> createPullParser(Context applicationContext) {
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            parser = factory.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            InputStream is = applicationContext.getResources().openRawResource(R.raw.deals);
            parser.setInput(new InputStreamReader(is));

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
            case PICTURES_TAG:
                isParsingPictures = true;
                break;
            case SOLD_TAG:
                isParsingSold = true;
                break;
            case ORIGINAL_PRICE_TAG:
                isParsingOriginalPrice = true;
                break;
            case PROMO_PRICE_TAG:
                isParsingPromoPrice = true;
                break;
            case DISCOUNT_TAG:
                isParsingDiscount = true;
                break;
            case END_DATE_TAG:
                isParsingEndDate = true;
                break;
            case UPDATED_TAG:
                isParsingUpdated = true;
                break;
            case LINK_TAG:
                isParsingLink = true;
                break;
            case MERCHANT_NAME_TAG:
                isParsingMerchantName = true;
                break;
            case MERCHANT_LATITUDE_TAG:
                isParsingMerchantLatitude = true;
                break;
            case MERCHANT_LONGITUDE_TAG:
                isParsingMerchantLongitude = true;
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
                current.setId(parser.getAttributeValue(null, ID_ATTRIBUTE));
                break;
        }
    }

    private void text(String text) {
        if (isParsingCities) {
            current.setCities(text.trim());
        } else if (isParsingCategories) {
            current.setCategories(text.trim());
        } else if (isParsingTitle) {
            current.setTitle(text.trim());
        } else if (isParsingDescription) {
            current.setDescription(text.trim());
        } else if (isParsingTerms) {
            current.setTerms(text.trim());
        } else if (isParsingPictures) {
            pictures.add(text.trim());
        } else if (isParsingSold) {
            current.setSold(Integer.valueOf(text.trim()));
        } else if (isParsingOriginalPrice) {
            current.setOriginalPrice(Double.valueOf(text.trim()));
        } else if (isParsingPromoPrice) {
            current.setPromoPrice(Double.valueOf(text.trim()));
        } else if (isParsingDiscount) {
            current.setDiscountInPercent(Double.valueOf(text.trim()));
        } else if (isParsingEndDate) {
            Date end = parsingDate(text.trim());
            current.setEndDate(end);
            if (new Date().before(end)) {
                current.setExpired(false);
            } else {
                current.setExpired(true);
            }

        } else if (isParsingUpdated) {
            current.setUpdatedDate(parsingDate(text.trim()));
        } else if (isParsingLink) {
            current.setLink(text.trim());
        } else if (isParsingMerchantName) {
            current.setMerchantName(text.trim());
        } else if (isParsingMerchantLatitude) {
            current.setMerchantLatitude(Double.valueOf(text.trim()));
        } else if (isParsingMerchantLongitude) {
            current.setMerchantLongtitude(Double.valueOf(text.trim()));
        } else if (isParsingPriority) {
            current.setPriority(Integer.valueOf(text.trim()));
        } else if (isParsingRpvlt) {
            current.setRpvlt(Integer.valueOf(text.trim()));
        } else if (isParsingRpv24) {
            current.setRpv24(Integer.valueOf(text.trim()));
        }
    }

    private Date parsingDate(String trim) {
        try {
            // 2016-05-25 22:00:00
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(trim);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
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
            case PICTURES_TAG:
                isParsingPictures = false;
                break;
            case SOLD_TAG:
                isParsingSold = false;
                break;
            case ORIGINAL_PRICE_TAG:
                isParsingOriginalPrice = false;
                break;
            case PROMO_PRICE_TAG:
                isParsingPromoPrice = false;
                break;
            case DISCOUNT_TAG:
                isParsingDiscount = false;
                break;
            case END_DATE_TAG:
                isParsingEndDate = false;
                break;
            case UPDATED_TAG:
                isParsingUpdated = false;
                break;
            case LINK_TAG:
                isParsingLink = false;
                break;
            case MERCHANT_NAME_TAG:
                isParsingMerchantName = false;
                break;
            case MERCHANT_LATITUDE_TAG:
                isParsingMerchantLatitude = false;
                break;
            case MERCHANT_LONGITUDE_TAG:
                isParsingMerchantLongitude = false;
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
                current.setPictures(pictures);
                pictures = new ArrayList<>();
                dealsOffers.add(current);
                current = new ParseMainOffer();
                break;
        }
    }
}
