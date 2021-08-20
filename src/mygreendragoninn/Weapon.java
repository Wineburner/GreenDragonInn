/* Project: Green Dragon Inn
 * This: Weapon.Java
 * Date: 5/5/2021
 * Author: Devin Wineburner
 * Purpose: A sub-class that handles the weapons.
 */
package mygreendragoninn;


public class Weapon extends Item
{
    private int damage;
    private String weaType;//Type of weapon, Blade, Blunt, Axe, etc.
    
    //=========== constructor ==================================================
    public Weapon()
    {
        super();
    }
    
    //========== setters/getters ===============================================

    public int getDamage() 
    {
        return damage;
    }

    public void setDamage(int damage) 
    {
        this.damage = damage;
    }

    public String getWeaType() 
    {
        return weaType;
    }

    public void setWeaType(String weaType) 
    {
        this.weaType = weaType;
    }
    
}
