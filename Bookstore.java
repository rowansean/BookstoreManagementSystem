/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rowanseanproject1;
import java.util.*;
import java.io.*;


/**
 *
 * @author seanrowan
 */
public class Bookstore implements BookstoreSpecification{
    
    //create a system that allows a bookstore owner to keep track of their inventory and members.

    /**
         *
         * Products: Books, CDs, DVDs
         *
         * Memberships: Regular (free), Premium (monthly fee)
         *
         * Key Details:
         *
         *   - (subscriptions) The store keeps track of payment method for their premium members
         *   and whether the monthly fee is due or has been paid.
         *
         *  - (profits) The system should keep track of the members and how much money each
         *   has spent at the store regardless if they are regular or premium members.
         *
         *  - (inventory) The system also keeps track of the inventory of each product.
         *
         *  3 Distinct functionalities:
         *
         *  1) Complete a purchase (1 or more items, deducted from inventory)
         *      - Capture payment details
         *      - Count number of items in cart
         *  
         *  2) Search Book Titles (By Genre, author, etc.)
         * 
         *  3) Manage Account (Subscribe / Unsubscribe)
         *      -  Log-in system
         *
         *  - Rating system (stars, comments)
         *
         */
    
    
    //Properties
    public ArrayList<Member> members = new ArrayList();  
    public ArrayList<Member> newMembers = new ArrayList();  
    public ArrayList<Product> inventory = new ArrayList();
    public ArrayList<Product> cart = new ArrayList();
    
    
    // Constructors
    public Bookstore() {
    
        generateInventory();
        generateMembers();

    }
    
    
    //Methods
    private void generateInventory(){
        
        try {

            //open file w scanner
            Scanner scanner = new Scanner(new File("ProductInventory.csv"));

            //loop through file 
            while (scanner.hasNext()){
                
                // Store info into variables
                String currentLine = scanner.nextLine();
                String[] currentInfo = currentLine.split(",");
                
                // Create products based on the info
                
                // If line contains a 'book' product, create a new product for it and add it to the inventory
                if (currentInfo[0].equalsIgnoreCase("BOOK")){
                    Book newAddition = new Book(currentInfo[1], currentInfo[2], Integer.parseInt(currentInfo[3]), 
                            Double.parseDouble(currentInfo[4]), Integer.parseInt(currentInfo[5]), Integer.parseInt(currentInfo[6])); 
                    inventory.add(newAddition);
                    continue;
                }
               
                // If line contains a 'CD' product, create a new product for it and add it to the inventory
                if (currentInfo[0].equalsIgnoreCase("CD")) {
                    CD newAddition = new CD(currentInfo[1], currentInfo[2], Integer.parseInt(currentInfo[3]),
                            Double.parseDouble(currentInfo[4]), Integer.parseInt(currentInfo[5]), Integer.parseInt(currentInfo[6]));
                    inventory.add(newAddition);
                    continue;
                }
                
                // If line contains a 'DVD' product, create a new product for it and add it to the inventory
                if (currentInfo[0].equalsIgnoreCase("DVD")) {
                    DVD newAddition = new DVD(currentInfo[1], currentInfo[2], Integer.parseInt(currentInfo[3]),
                            Double.parseDouble(currentInfo[4]), Integer.parseInt(currentInfo[5]), Integer.parseInt(currentInfo[6]));
                    inventory.add(newAddition);
                    continue;
                }
                 
            }//end while
            
            scanner.close();
            
        } catch (FileNotFoundException e){
            System.out.println("File read error.");
        }
        
    }
    
    public void saveInventory(){
        
        try {
            
            //create file IO
            FileWriter writer = new FileWriter("UpdatedInventory.csv");
            
            //initialize file once
            writer.write("type,title,author/artist,rating,price,numInStock,ItemNumber\n");            
            
            // write updated inventory
            for (Product p : inventory){
                writer.write(p.toString() + "\n");
            }
            
            writer.close();
            
        } catch (IOException e){
            System.out.println("File Error.");
            e.printStackTrace();
        }
        
    }
    
    public void displayInventory(){
        
        //Displays the inventory in order of Books, Cds, DVDs
        System.out.println("\nBooks");
        System.out.println("-----------------");
        for (Product e : inventory){
            if (e instanceof Book){
                System.out.println(e.getItemNumber() + ") " + e.getTitle() + " | Rating: (" + e.getRating() + "/5)" + " | $" + e.getCost() + " | Stock: " + e.getStock());
            }
        }

        System.out.println("\nCDs");
        System.out.println("-----------------");
        for (Product e : inventory){
            if (e instanceof CD){
                System.out.println(e.getItemNumber() + ") " + e.getTitle() + " | Rating: (" + e.getRating() + "/5)" + " | $" + e.getCost() + " | Stock: " + e.getStock());
            }
        }

        System.out.println("\nDVDs");
        System.out.println("-----------------");
        for (Product e : inventory){
            if (e instanceof DVD){
                System.out.println(e.getItemNumber() + ") " + e.getTitle() + " | Rating: (" + e.getRating() + "/5)" + " | $" + e.getCost() + " | Stock: " + e.getStock());
            }
        }
        
    }
    
    private void generateMembers(){
        //generate members
        Member m1 = new Member("Joe Johnson", "Fiction & Classical", true);
        Member m2 = new Member("Mary Beth", "NonFiction", true);
        Member m3 = new Member("James Jones", "True Crime", false);
        Member m4 = new Member("Daniel McDaniels", "Drama", false);
        
        //add members to members list
        members.add(m1);
        members.add(m2);
        members.add(m3);
        members.add(m4);
    }
    
    public void displayMembers(){
        
        //Displays member list with Premium status
        int ID = 0;
        System.out.println("Members List:");
        System.out.println("---------------------");
        for (Member m : members){
            ID++;
            System.out.println(ID + " | " + m.getFullName() + "| Premium: " + m.isPremium());
        }
        System.out.println("");
        
    }
    
    public void addNewMember(){
        
        Scanner console = new Scanner(System.in);
        //ASks user to add new member to list
        System.out.println("Would  you like to add a new member? (Y/N)");
        String input = console.next();
        
        if (input.equalsIgnoreCase("Y")) {
            
            Member newMem = new Member();
            
            System.out.println("Please Enter Your Name:");
            input = console.nextLine();
            input = console.nextLine();
            newMem.setFullName(input);
            
            System.out.println("Would you like to subscribe for a Premium Membership for $10 a month? (Y/N)");
            input = console.next();
            if (input.equalsIgnoreCase("Y")){
                newMem.setIsPremium(true);
            }
            
            newMembers.add(newMem);
            members.add(newMem);
            System.out.println("You have been added to the membership list!\n");
            
        }
        
    }
    
    public void displayMenuOptions(){
        //Display menu options
        System.out.println("\n Enter a Menu Option Below or Enter '-1' to Exit ");
        System.out.println("---------------------------------------------------");
        System.out.println(" 1. Make A Purchase\n 2. Manage Account\n 3. View Cart\n");
    }
   
    public void makePurchase(int selection){

        //remove one to make slection inline with cart inventory
        selection--;
        
        // Check if selection is valid, if so, add to cart and decrement stock
        if (selection >= 0 && selection <= inventory.size()){
            
            //Check if selection is in stock
            if (inventory.get(selection).getStock() > 0){
                
                cart.add(inventory.get(selection));
                inventory.get(selection).decrementStock();
                
            } else {System.out.println("This item is currently out of stock, please try again later.");}
               
        } else {System.out.println("Item not selected");}
        
    }
    
    public void checkout(){
        
        Scanner console = new Scanner(System.in);
        
        //Ask to checkout
        System.out.println("Would  you like to check out? (Y/N)");
        String input = console.next();
        
        //If yes, then update purchase history and total spent
        if (input.equalsIgnoreCase("Y")) {
            System.out.println("Please select you Member ID:");
            displayMembers();
            
            int num = console.nextInt();
            for (int i = 0; i < cart.size(); i++){
                
               members.get(num-1).addTotalSpent(cart.get(i).getCost());
               members.get(num-1).addToPurchaseHistory(cart.get(i));
               
            }
            
            cart.clear();
            System.out.println("Cha-Ching!");
            
        }
    }
    
    public void displayCart(){
        
        //Displays cart contents and total price
        System.out.println("Cart (" + cart.size() + ")");
        System.out.println("---------------");
        double total = 0;
        for (int i = 0; i < cart.size(); i++){
            System.out.println(cart.get(i).getTitle());
            total += cart.get(i).getCost();
        }
        System.out.println("-------------------");
        System.out.println("Total: $" + total);
    }   
    
    public void generateEndOfDayReport(){
        
        double totalRevenue = 0;       
        
        // open / create end of day file (csv)
        try {

            FileWriter myWriter = new FileWriter("EndOfDayReport.txt");
            
            myWriter.write(
                    "---------------------\n" +
                    "End Of Day Report" +
                    "\n---------------------\n");
            
            // write products purshased and the total revenue
            myWriter.write("\nProducts Purchased:\n\n");
            
            //loop through members purchase history
            for (Member m : members){
                
                for (int i = 0; i < m.getPurchaseHistory().size(); i++){
                    
                    myWriter.write(m.getPurchaseHistory().get(i).getTitle() + "\n");
                    totalRevenue += m.getPurchaseHistory().get(i).getCost();

                }
                
            }            
            
            
            // write the new members
            myWriter.write("\nNew Members:\n\n");
            
            for (Member m : newMembers){
                myWriter.write(m.getFullName() +  "\n");
            }
            
            
            //Total spent and Number of New Members
            myWriter.write("\nTotal Revenue: " + totalRevenue + "\nNew Members: " + newMembers.size());
            
            
            myWriter.close();
            System.out.println("Successfully wrote to the file.");          

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }        
       
    }
    
     @Override
    public void restockProduct(int index, int newStock) {
        
        inventory.get(index).setStock(newStock);
        
    }

    @Override
    public double inventoryValue() {
        
        double totalCost = 0;
        
        for (Product p : inventory){
            totalCost += p.getCost();
        }
        return totalCost;
        
    }
    
    
    
    
    // Setters & Getters
    
    

    public ArrayList<Product> getInventory(){
        return inventory;
    }
    
    public void setInventory(ArrayList<Product> inventory){
        this.inventory = inventory;
    }
    
    public ArrayList<Member> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }
    
    public ArrayList<Product> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Product> Cart) {
        this.cart = Cart;
    }

}
