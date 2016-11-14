package main;

import java.util.Date;

/**
 * Created by simon on 14.11.16.
 */
public class Customer extends Person{
    private Video[] borrowedVideos;

    public Customer() {
        super();
        this.borrowedVideos = new Video[1];
    }
}
