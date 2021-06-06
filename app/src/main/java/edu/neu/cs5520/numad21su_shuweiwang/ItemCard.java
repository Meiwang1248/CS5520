package edu.neu.cs5520.numad21su_shuweiwang;

public class ItemCard implements ItemClickListener{
    private String name;
    private String URL;

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

    public void setName(String name) {
        this.name = name;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    @Override
    public void onItemClick(int position) {
        // go
    }


}
