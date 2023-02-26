/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rowanseanproject1;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author seanrowan
 */
public class BookstoreSimulation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Create a New Bookstore and construct a scanner for user userInput later
        Bookstore seansBookstore = new Bookstore();
        Scanner console = new Scanner(System.in);
        String userInput;
        
        //Display Menu and Get user Input
        System.out.println("---------------------------------------------------");
        System.out.println(" Welcome to Sean's Bookstore!                  ");
        
        //Loop Menu Options until user exits with '-1'
        do {
            //Display menu and get user userInput
            seansBookstore.displayMenuOptions();
            userInput = console.next();
            
            switch (userInput){
                
                case "1":
                    seansBookstore.displayInventory();
                    System.out.println("\nIf you would like to make a purchase, enter the item Number (or '-1' to exit)");
                    int selection = console.nextInt();
                    seansBookstore.makePurchase(selection);
                    break;
                case "2":
                    seansBookstore.displayMembers();
                    seansBookstore.addNewMember();
                    break;
                case "3":
                    seansBookstore.displayCart();
                    seansBookstore.checkout();
                    break;
                default:
                    System.out.println("Please enter a valid selection.\n");
            }
            
        
        } while (!userInput.equals("-1"));
       
        seansBookstore.saveInventory();
        seansBookstore.generateEndOfDayReport();
        
        
        
    }
    
}
