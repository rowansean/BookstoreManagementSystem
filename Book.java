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
public class Book extends Product {
    
    //Properties
   
    private String author;
    

    // Constructors
    
    public Book(String title, String author, int rating, double cost, int stock, int itemNumber) {
       super(title, rating, cost, stock, itemNumber);
       this.author = author;
    }
    
    // Setters and Getters

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String toString(){
        //return "type,title,author/artist,rating,price,numInStock,ItemNumber"
        return ("book" + "," + this.getTitle() + "," + this.getAuthor() + "," + this.getRating() + "," + this.getCost() + "," + this.getStock() + "," + this.getItemNumber());
    }
    
}

