/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testingwithhsqldb;

/**
 *
 * @author pedago
 */
public class ProductEntity {
    private int ID;
    private String Name;
    private float Price;

    public ProductEntity(Integer Id,String name, float price) {
        ID = Id;
        Name = name;
        Price = price;
        
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }
    
    
    public int getID(){
        return ID;
    }
    public String getName(){
        return Name;
    }
    public float getPrice(){
        return Price;
    }
    
    public String toString(){
        return Name;
    }
    
    
    
    
}
