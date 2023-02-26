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
public class Member {
    
    // Attributes
    private String fullName;
    private String favGenre;
    private double totalSpent;
    private boolean isPremium;
    private boolean isDuesPaid;
    private String paymentMethod;
    private ArrayList<Product> purchaseHistory = new ArrayList();
   
    
    // Constructors
    public Member(){
       
    }
    
    public Member(String fullName, String favGenre, boolean isPremium) {
        this.fullName = fullName;
        this.favGenre = favGenre;
        this.isPremium = isPremium;
        this.totalSpent = 0;
       
    }
 
    
    //Methods
   
    
    
    //Setters & Getters

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFavGenre() {
        return favGenre;
    }

    public void setFavGenre(String favGenre) {
        this.favGenre = favGenre;
    }

    public double getTotalSpent() {
        return totalSpent;
    }

    public void addTotalSpent(double newCharge) {
        this.totalSpent = this.totalSpent + newCharge;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setIsPremium(boolean isPremium) {
        this.isPremium = isPremium;
    }

    public boolean isIsDuesPaid() {
        return isDuesPaid;
    }

    public void setIsDuesPaid(boolean isDuesPaid) {
        this.isDuesPaid = isDuesPaid;
    }
    
    public void addToPurchaseHistory(Product purchase){
        this.purchaseHistory.add(purchase);
    }
    
    public ArrayList<Product> getPurchaseHistory(){       
        return purchaseHistory;
    }
    
    
}
