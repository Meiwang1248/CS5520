package edu.neu.cs5520.numad21su_shuweiwang;

public class ListItem {
    private String country;
    private String capital;

    public ListItem() {
    }

    public ListItem(String cat, String detail) {
        this.country = cat;
        this.capital = detail;
    }

    public String getCountry() {
        return country;
    }

    public String getCapital() {
        return capital;
    }

    public void setCountry(String cat) {
        this.country = cat;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
}
