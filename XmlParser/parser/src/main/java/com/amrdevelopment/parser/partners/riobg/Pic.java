package com.amrdevelopment.parser.partners.riobg;

import javax.xml.bind.annotation.XmlValue;

public class Pic {
    private String link;

    public String getLink() {
        return link;
    }

    @XmlValue
    public void setLink(String link) {
        this.link = link;
    }
}
