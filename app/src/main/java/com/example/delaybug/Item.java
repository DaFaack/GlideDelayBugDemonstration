package com.example.delaybug;


public class Item {
    private String imageResource;
    private String imageResourceTwo;

    public Item(String imageResource , String imageResourceTwo) {
        this.imageResource = imageResource;
        this.imageResourceTwo = imageResourceTwo;

    }
    public String getImageResource() {
        return imageResource;
    }
    public String getImageResourceSecond() {
        return imageResourceTwo;
    }

}
