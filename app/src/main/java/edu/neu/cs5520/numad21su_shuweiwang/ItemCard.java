package edu.neu.cs5520.numad21su_shuweiwang;

public class ItemCard {
    private final String name;
    private final String URL;

    // Constructor
    public ItemCard(String name, String URL) {
        this.name = name;
        this.URL = URL;
    }

    public String getName() {
        return name;
    }

    public String getURL() {
        return URL;
    }

    @Override
    public void onItemClick(int position) {
        // go to the website in brower
    }

}
