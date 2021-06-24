package edu.neu.cs5520.numad21su_shuweiwang;

public class ListItem {
    private String category;
    private String details;

    public ListItem() {
    }

    public ListItem(String cat, String detail) {
        this.category = cat;
        this.details = detail;
    }

    public String getCategory() {
        return category;
    }

    public String getDetails() {
        return details;
    }

    public void setCategory(String cat) {
        this.category = cat;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
