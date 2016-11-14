package main;

/**
 * Created by simon on 14.11.16.
 */
public class Video {
    private String title;
    private int length; // length in minutes
    private boolean avaliable;

    public Video(String title, int length, boolean avaliable) {
        this.title = title;
        this.length = length;
        this.avaliable = avaliable;
    }
}
