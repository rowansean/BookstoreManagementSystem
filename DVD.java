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
public class DVD extends Product {
    
    // Properties
    
    private String director;
    
    //constructors

    public DVD(String title, String director, int rating, double cost, int stock, int itemNumber) {
        super(title, rating, cost, stock, itemNumber);
        this.director = director;
    }
    
    //Setters and Getters

    public String getDirector() {
        return director;
    }

    public void setDirector(String Director) {
        this.director = Director;
    }
    
    public String toString() {
        //return "type,title,author/artist,rating,price,numInStock,ItemNumber"
        return ("dvd" + "," + this.getTitle() + "," + this.getDirector() + "," + this.getRating() + "," + this.getCost() + "," + this.getStock() + "," + this.getItemNumber());
    }


}
