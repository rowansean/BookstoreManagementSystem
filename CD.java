/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rowanseanproject1;
import java.util.*;

/**
 *
 * @author seanrowan
 */
public class CD extends Product {
    
    //Properties
   
    private String artist;
    
    // Constructors
    
    public CD(String title, String artist, int rating, double cost, int stock, int itemNumber) {
        super(title, rating, cost, stock, itemNumber);
        this.artist = artist;
    }
    
    // Setters and Getters


    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }    
    
    public String toString() {
        //return "type,title,author/artist,rating,price,numInStock,ItemNumber"
        return ("cd" + "," + this.getTitle() + "," + this.getArtist() + "," + this.getRating() + "," + this.getCost() + "," + this.getStock() + "," + this.getItemNumber());
    }


}
