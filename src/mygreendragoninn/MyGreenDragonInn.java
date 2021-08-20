/* Project: Green Dragon Inn
 * This: MyGreenDragonInn.Java
 * Date: 5/5/2021
 * Author: Devin Wineburner
 * Purpose: A simulation of use an Inn in a classic RPG.
 */
package mygreendragoninn;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class MyGreenDragonInn 
{
    
    private static int gold = 0;
    private static Scanner USERCON = new Scanner(System.in);
    public static void main(String[] args) 
    {
        //Setup
        char choice = 'L';
        try {
            File mySave = new File("save.txt");
            

            if (mySave.createNewFile())
            {
                System.out.println("Save created: " + mySave.getName());
                FileWriter saveInfo = new FileWriter("save.txt");
                saveInfo.write("1000");
                saveInfo.close();
                Scanner myReader = new Scanner(mySave);
                while (myReader.hasNextLine()){
                    String data = myReader.nextLine();
                    gold = Integer.parseInt(data);
                }
                
            }

            else
            {
                System.out.println("loading Save");
                Scanner myReader = new Scanner(mySave);
                while (myReader.hasNextLine()){
                    String data = myReader.nextLine();
                    gold = Integer.parseInt(data);
                }
            }
        }
        catch (IOException e)
        {
           System.out.println("An error occured");
           e.printStackTrace();
        }
        //Start
        System.out.println("===== Welcome to the Green Dragon Inn =====");
        do{
            choice = pickChoice();
            switch(choice)
            {
                case'R':
                {
                    restChoice();
                    break;
                }
                case'S':
                {
                    
                    Item pickSection = new Item();
                    pickSection.setItemType();
                    char sectChoice = pickSection.getItemType();
                    displayShop(sectChoice);
                    break;
                }
                case'L':
                {
                    System.out.println("You decide to leave the inn\n"
                    + "Thank you for visiting the Green Dragon Inn!");
                    try {
                    String strGold = String.valueOf(gold);
                    FileWriter saveInfo = new FileWriter("save.txt");
                    saveInfo.write(strGold);
                    saveInfo.close();
                    System.out.print("Save Updated");
                    }
                    
                    catch (IOException e)
                    {
                       System.out.println("An error occured");
                       e.printStackTrace();
                    }
                    break;
                }
                
                default:System.out.println("\nOnly (R)est, (S)hop, or (L)eave are valid options!\n");break;
            }
        }while(choice != 'L');
        
        
        
    }
    //================== char pickChoice() =====================================
    public static char pickChoice()
    {
        System.out.printf("Current Gold: %d\n",gold);
        System.out.print("How may we help you today?\n"
                + "\t(R)est at Inn\n"
                + "\t(S)hop at Inn\n"
                + "\t(L)eave the Inn\n"
                + "Enter (R)est, (S)hop, or (L)eave: ");
        char choice = USERCON.next().toUpperCase().charAt(0);
        
        return choice;
    }
    //================= void restChoice() ======================================
    public static void restChoice()
    {
        char choice;
        do
        {
            System.out.print("\nWould you like to rest for the night? (Costs 40 gold)\n"
                    + "\t(Y)es\n"
                    + "\t(N)o\n"
                    + "Enter your choice: ");
            choice = USERCON.next().toUpperCase().charAt(0);
            if(choice != 'Y' && choice != 'N')
            {
                System.out.println("Only (Y)es or (N)o are valid choices.");
            }
        }while(choice != 'Y' && choice != 'N');
        
        switch(choice)
        {
            case'Y':
            {
                if(gold >= 40)
                {
                    System.out.println("\nzzz...\n"
                            + "You now feel well rested.\n");
                    gold = gold - 40;
                }
                else
                {
                    System.out.println("You are unable to afford a room at this Inn.");
                }
                break;
            }
            case'N':
            {
                System.out.println("\nYou choose not to rest for the night.\n");
                break;
            }
        }
        
    }
    //================== void displayShop() ====================================
    public static void displayShop(char type)
    {
        //setup
        String strEffect;
        Potion[] ourItem = new Potion[4];
        
        ourItem[0] = new Potion();
        ourItem[0].setName("Potion");
        ourItem[0].setPrice(20);
        ourItem[0].setEffectType("Health");
        ourItem[0].setRestoreAmt(25);
        
        ourItem[1] = new Potion();
        ourItem[1].setName("Either");
        ourItem[1].setPrice(50);
        ourItem[1].setEffectType("Mana");
        ourItem[1].setRestoreAmt(10);
        
        ourItem[2] = new Potion();
        ourItem[2].setName("Skooma");
        ourItem[2].setPrice(1000);
        ourItem[2].setEffectType("Stamina");
        ourItem[2].setRestoreAmt(500);
        
        ourItem[3] = new Potion();
        ourItem[3].setName("Hi-Potion");
        ourItem[3].setPrice(100);
        ourItem[3].setEffectType("Health");
        ourItem[3].setRestoreAmt(200);
        
        Weapon[] ourWeap = new Weapon[3];
        
        ourWeap[0] = new Weapon();
        ourWeap[0].setName("Iron Short Sword");
        ourWeap[0].setPrice(200);
        ourWeap[0].setWeaType("Blade");
        ourWeap[0].setDamage(5);
        
        ourWeap[1] = new Weapon();
        ourWeap[1].setName("Wooden Club");
        ourWeap[1].setPrice(50);
        ourWeap[1].setWeaType("Blunt");
        ourWeap[1].setDamage(2);
        
        ourWeap[2] = new Weapon();
        ourWeap[2].setName("Steel Axe");
        ourWeap[2].setPrice(450);
        ourWeap[2].setWeaType("Axe");
        ourWeap[2].setDamage(8);
        
        int itemChoice = 0;
        char buyChoice = 'N';
        
        //input
        switch(type)
        {
            case'W':
            {
                char weapEquip;
                
                do
                {
                    System.out.printf("\nCurrent Gold: %d\n",gold);
                    System.out.printf("==#== Weapon list ==#==\n"
                            + "\t1. %s   %dG\n"
                            + "\t2. %s   %dG\n"
                            + "\t3. %s   %dG\n"
                            + "Enter the number of the item you want to buy(0 returns to main menu): "
                            ,ourWeap[0].getName(),ourWeap[0].getPrice()
                            ,ourWeap[1].getName(),ourWeap[1].getPrice()
                            ,ourWeap[2].getName(),ourWeap[2].getPrice());
                    while(!USERCON.hasNextInt())
                    {
                        System.out.println("Please only use numbers.");
                        USERCON.next();
                    }
                    itemChoice = USERCON.nextInt()-1;
                    
                    if(itemChoice >= 0 && itemChoice <= 2 )
                    {
                        if(gold >= ourWeap[itemChoice].getPrice())
                        {
                            System.out.printf("\n=== Item Stats ===\n"
                                    + "\tName: %s\n"
                                    + "\tPrice: %d Gold\n"
                                    + "\tType: %s\n"
                                    + "\tDamage: %d\n"
                                    + "Do you want to buy this item?(Y/N): "
                                    ,ourWeap[itemChoice].getName()
                                    ,ourWeap[itemChoice].getPrice()
                                    ,ourWeap[itemChoice].getWeaType()
                                    ,ourWeap[itemChoice].getDamage());

                        buyChoice = USERCON.next().toUpperCase().charAt(0);

                        
                            while(buyChoice != 'Y' && buyChoice != 'N')
                            {
                                System.out.println("The only valid choices is Y or N.");
                                System.out.printf("Do you want to buy a %s (Y/N): ", ourWeap[itemChoice].getName());

                                buyChoice = USERCON.next().toUpperCase().charAt(0);
                            }

                            switch(buyChoice)
                            {
                                case'Y':
                                {
                                    System.out.printf("\nYou brought a %s\n"
                                            , ourWeap[itemChoice].getName());
                                    gold = gold - ourWeap[itemChoice].getPrice();
                                    System.out.printf("Would you like to equip the %s (Y/N)?"
                                            ,ourWeap[itemChoice].getName());
                                    weapEquip = USERCON.next().toUpperCase().charAt(0);
                                    
                                    while(weapEquip != 'Y' && weapEquip != 'N')
                                    {
                                        System.out.printf("Only Y or N are valid choices\n"
                                                + "Would you like to equip the %s (Y/N)?"
                                            ,ourWeap[itemChoice].getName());
                                        weapEquip = USERCON.next().toUpperCase().charAt(0);
                                    }
                                    
                                    if(weapEquip == 'Y')
                                    {
                                        System.out.printf("\nYou equiped the %s!\n"
                                        ,ourWeap[itemChoice].getName());
                                    }
                                    else
                                    {
                                        System.out.printf("\nYou stored away the %s!\n"
                                        ,ourWeap[itemChoice].getName());
                                    }
                                    break;
                                }
                                case'N':System.out.printf("\nYou did not buy the %s\n", ourWeap[itemChoice].getName());break;
                            }
                        }
                        else
                        {
                        System.out.println("\nYou realize you can't afford that weapon..");
                        itemChoice = -1;
                        }
                    }
                    
                    
                }while( itemChoice != -1);
                System.out.println();
                break;
            }
            case'P':
            {
                do
                {
                    System.out.printf("\nCurrent Gold: %d\n",gold);
                    System.out.printf("==#== Potion list ==#==\n"
                            + "\t1. %s   %dG\n"
                            + "\t2. %s   %dG\n"
                            + "\t3. %s   %dG\n"
                            + "\t4. %s   %dG\n"
                            + "Enter the number of the item you want to buy(0 returns to main menu): "
                            ,ourItem[0].getName(),ourItem[0].getPrice()
                            ,ourItem[1].getName(),ourItem[1].getPrice()
                            ,ourItem[2].getName(),ourItem[2].getPrice()
                            ,ourItem[3].getName(),ourItem[3].getPrice());
                    while(!USERCON.hasNextInt())
                    {
                        System.out.println("Please only use numbers.");
                        USERCON.next();
                    }
                    itemChoice = USERCON.nextInt()-1;
                    
                        if(itemChoice >= 0 && itemChoice <= 3 )
                        {
                            if(gold >= ourItem[itemChoice].getPrice())
                            {
                                System.out.printf("\n=== Item Stats ===\n"
                                        + "\tName: %s\n"
                                        + "\tPrice: %d Gold\n"
                                        + "\tEffect: Restores %d %s\n"
                                        + "Do you want to buy this item?(Y/N): "
                                        ,ourItem[itemChoice].getName()
                                        ,ourItem[itemChoice].getPrice()
                                        ,ourItem[itemChoice].getRestoreAmt()
                                        ,ourItem[itemChoice].getEffectType());

                            buyChoice = USERCON.next().toUpperCase().charAt(0);


                                while(buyChoice != 'Y' && buyChoice != 'N')
                                {
                                    System.out.println("The only valid choices is Y or N.");
                                    System.out.printf("Do you want to buy a %s (Y/N): ", ourItem[itemChoice].getName());

                                    buyChoice = USERCON.next().toUpperCase().charAt(0);
                                }

                                switch(buyChoice)
                                {
                                    case'Y':
                                    {
                                        System.out.printf("\nYou brought a %s\n"
                                                , ourItem[itemChoice].getName());
                                        gold = gold - ourItem[itemChoice].getPrice();
                                        break;
                                    }
                                    case'N':System.out.printf("\nYou did not buy the %s\n", ourItem[itemChoice].getName());break;
                                }
                            }
                            else
                            {
                            System.out.println("\nYou realize you can't afford that item... ");
                            itemChoice = -1;
                            }
                        }
                        
                    
                }while( itemChoice != -1);
                System.out.println();
            }
        }
    }
}
