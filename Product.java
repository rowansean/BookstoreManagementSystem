package rowanseanproject1;

/**
 *
 * @author seanrowan
 */
public abstract class Product implements Comparable {
    
    //properties
    private String title;
    private int itemNumber;
    private int rating;
    private int stock;
    private double cost;
    
    
    //constructors
    public Product(String title, int rating, double cost, int stock, int itemNumber) {
        this.title = title;
        this.rating = rating;
        this.stock = stock;
        this.cost = cost;
        this.itemNumber = itemNumber;
    }
   
    
    //methods
    
    
    //setters and getters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    
    public int getItemNumber(){
        return this.itemNumber;
    }
    
    public void setItemNumber(int itemNumber){
        this.itemNumber = itemNumber;
    }

    public void decrementStock(){
        this.stock--;
    }

    public int compareTo(Object o) {
       
        int returnVal = 0;
        //compare prices
        if (o instanceof Product){
            
            if ( this.getCost() > ((Product) o).getCost() ){
                
                //if current object is greater, then return 1
                returnVal = 1;
            }
            else if (this.getCost() < ( (Product) o).getCost() ){
                
                //if current object is less, return -1
                returnVal = -1;
            }
            else {
                
                //if current object is equal to o, then return 0
                returnVal = 0;
            }
            
        }//end if
        return returnVal;
    }
    
    public abstract String toString();
    
}
