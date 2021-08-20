/* Project: Green Dragon Inn
 * This: Potion.Java
 * Date: 5/5/2021
 * Author: Devin Wineburner
 * Purpose: A sub-class that handles the Potions.
 */
package mygreendragoninn;


public class Potion extends Item
{
    private String effectType;//restores (M)ana,(H)ealth,(S)tamina 
    private int restoreAmt;//The amount restored by the potion
    
    //=========== construtor ===================================================
    public Potion()
    {
        super();
    }
    
    //========== setter/getter =================================================

    public String getEffectType() 
    {
        return effectType;
    }

    public void setEffectType(String effectType) 
    {
        this.effectType = effectType;
    }

    public int getRestoreAmt() 
    {
        return restoreAmt;
    }

    public void setRestoreAmt(int restoreAmt) 
    {
        this.restoreAmt = restoreAmt;
    }
    
}
