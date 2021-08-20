/* Project: Green Dragon Inn
 * This: Item.Java
 * Date: 5/5/2021
 * Author: Devin Wineburner
 * Purpose: A super class that contains common attributes.
 */
package mygreendragoninn;
import java.util.Scanner;

public class Item 
{
   private final static Scanner USERCON = new Scanner(System.in); 
    
   private String name;
   private int price;// amount of gold needed to buy
   private char itemType;//(W)eapon,(P)otions,(M)isc
   
   //============= constructor =================================================
   public Item()
   {
       
   }
   
   //============ setter/getters ===============================================

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public int getPrice() 
    {
        return price;
    }

    public void setPrice(int price) 
    {
        this.price = price;
    }

    public char getItemType() 
    {
        return itemType;
    }

    public void setItemType() 
    {
        char itemType;
        do
        {
        System.out.print("\nWhich section would you like to look at?\n"
                + "\t(W)eapon\n"
                + "\t(P)otion\n"
                + "Enter W or P: ");
        itemType = USERCON.next().toUpperCase().charAt(0);
        if(itemType != 'W' && itemType != 'P')
        {
            System.out.println("Only W or P are valid choices.");
        }
        }while(itemType != 'W' && itemType != 'P');     
        this.itemType = itemType;
    }
    
   
}
