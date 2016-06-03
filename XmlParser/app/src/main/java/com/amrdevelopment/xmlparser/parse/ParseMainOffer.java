package com.amrdevelopment.xmlparser.parse;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created on 26-May-16
 */
@ParseClassName("ParseMainOffer")
public class ParseMainOffer extends ParseObject {

    public ParseMainOffer () {}

    // id
    public String getId() {
        return getString("id");
    }

    public void setId(String id) {
        put("id", id);
    }

    // cities
    public String getCities() {
        return getString("cities");
    }

    public void setCities(String cities) {
        put("cities", cities);
    }

    // categories
    public String getCategories() {
        return getString("categories");
    }

    public void setCategories(String categories) {
        put("categories", categories);
    }

    // title
    public String getTitle() {
        return getString("title");
    }

    public void setTitle(String title) {
        put("title", title);
    }

    // description
    public String getDescription() {
        return getString("description");
    }

    public void setDescription(String description) {
        put("description", description);
    }

    // terms
    public String getTerms() {
        return getString("terms");
    }

    public void setTerms(String terms) {
        put("terms", terms);
    }

    // pictures
    public List<String> getPictures() {
        return getList("pictures");
    }

    public void setPictures(List<String> pic) {
        addAll("pictures", pic);
    }

    // places
    public List<String> getPlaces() {
        return getList("places");
    }

    public void setPlaces(ArrayList<String> place) {
        addAll("places", place);
    }

    // sold
    public Integer getSold() {
        return getInt("sold");
    }

    public void setSold(Integer sold) {
        put("sold", sold);
    }

    // original price
    public Double getOriginalPrice() {
        return getDouble("originalPrice");
    }

    public void setOriginalPrice(Double original) {
        put("originalPrice", original);
    }

    // promo price
    public Double getPromoPrice() {
        return getDouble("promoPrice");
    }

    public void setPromoPrice(Double promo) {
        put("promoPrice", promo);
    }

    // discount in percent
    public Double getDiscountInPercent() {
        return getDouble("discountInPercent");
    }

    public void setDiscountInPercent(Double discount) {
        put("discountInPercent", discount);
    }

    // start date
    public Date getStartDate() {
        return getDate("startDate");
    }

    public void setStartDate(Date start) {
        put("startDate", start);
    }

    // end date
    public Date getEndDate() {
        return getDate("endDate");
    }

    public void setEndDate(Date end) {
        put("endDate", end);
    }

    // updated date
    public Date getUpdatedDate() {
        return getDate("updatedDate");
    }

    public void setUpdatedDate(Date updated) {
        put("updatedDate", updated);
    }

    // link
    public String getLink() {
        return getString("link");
    }

    public void setLink(String link) {
        put("link", link);
    }

    // merchant name
    public String getMerchantName() {
        return getString("merchantName");
    }

    public void setMerchantName(String merchantName) {
        put("merchantName", merchantName);
    }

    // merchant email
    public String getMerchantEmail() {
        return getString("merchantEmail");
    }

    public void setMerchantEmail(String merchantEmail) {
        put("merchantEmail", merchantEmail);
    }

    // merchant website
    public String getMerchantWebsite() {
        return getString("merchantWebsite");
    }

    public void setMerchantWebsite(String merchantWebsite) {
        put("merchantWebsite", merchantWebsite);
    }

    // merchant address
    public String getMerchantAddress() {
        return getString("merchantAddress");
    }

    public void setMerchantAddress(String merchantAddress) {
        put("merchantAddress", merchantAddress);
    }

    // merchant address more
    public String getMerchantAddressMore() {
        return getString("merchantAddressMore");
    }

    public void setMerchantAddressMore(String merchantAddressMore) {
        put("merchantAddressMore", merchantAddressMore);
    }

    // merchant phone
    public String getMerchantPhone() {
        return getString("merchantPhone");
    }

    public void setMerchantPhone(String merchantPhone) {
        put("merchantPhone", merchantPhone);
    }

    // merchant latitude
    public double getMerchantLatitude() {
        return getDouble("merchantLatitude");
    }

    public void setMerchantLatitude(double merchantLatitude) {
        put("merchantLatitude", merchantLatitude);
    }

    // merchant longitude
    public double getMerchantLongtitude() {
        return getDouble("merchantLongtitude");
    }

    public void setMerchantLongtitude(double merchantLongtitude) {
        put("merchantLongtitude", merchantLongtitude);
    }

    // priority
    public Integer getPriority() {
        return getInt("priority");
    }

    public void setPriority(Integer priority) {
        put("priority", priority);
    }

    // rpvlt
    public Integer getRpvlt() {
        return getInt("rpvlt");
    }

    public void setRpvlt(Integer rpvlt) {
        put("rpvlt", rpvlt);
    }

    // rpv24
    public Integer getRpv24() {
        return getInt("rpv24");
    }

    public void setRpv24(Integer rpv24) {
        put("rpv24", rpv24);
    }

    // expired
    public Boolean getExpired() {
        return getBoolean("expired");
    }

    public void setExpired(Boolean expired) {
        put("expired", expired);
    }

    public static ParseQuery<ParseMainOffer> getQuery() {
        return ParseQuery.getQuery(ParseMainOffer.class);
    }
}
