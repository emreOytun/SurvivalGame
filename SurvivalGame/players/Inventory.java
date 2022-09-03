package players;
import java.util.ArrayList;

import armors.Armor;
import stuffs.Stuff;
import weapons.Weapon;

public class Inventory {
    private ArrayList<Weapon> weapons = new ArrayList<Weapon>();    
    private ArrayList<Armor> armors = new ArrayList<Armor>();
    private ArrayList<Stuff> stuffs = new ArrayList<Stuff>();
    private int money;

    Inventory(int money) {
        this.money = money;
    }

    public int getMoney() {return this.money;}
    public void addMoney(int _money) {
        money += _money;
    }

    public String weaponsToString() {
        String s = "\n";
        if (weapons.size() == 0) {s = "No weapon !"; return s;}
        
        for (Weapon w : weapons) {
            s += "\t" + w.toString() + "\n";
        }
        return s;
    }

    public String armorsToString() {
        String s = "\n";
        if (armors.size() == 0) {s = "No armors !"; return s;}

        for (Armor a : armors) {
            s += "\t" + a.toString() + "\n";
        }
        return s;
    }

    public void buyWeapon(Weapon weapon, int amount) {
        if (amount > money) {
            System.out.println("You do not have " + amount + " money!");
        }
        
        else {
            weapons.add(weapon);
            money -= amount;
        }
    }

    public void buyArmor(Armor armor, int amount) {
        if (amount > money) {
            System.out.println("You do not have " + amount + " money!");
        }
        
        else {
            armors.add(armor);
            money -= amount;
        }
    }

    public void addStuff(Stuff stuff) {
        stuffs.add(stuff);
    }

    public boolean checkStuffs() {  // For end of the game!
        int[] bitset = new int[] {0, 0, 0};
        
        for (Stuff s : stuffs) {
            bitset[s.getId() - 1] = 1;
        }

        for (int b : bitset) {
            if (b == 0) return false;
        }

        return true;
    }

    public int totalDamage() {
        int damage = 0;
        for (Weapon w : weapons) {
            damage += w.getDamage();
        }
        return damage;
    }

    public int totalProtection() {
        int protection = 0;
        for (Armor a : armors) {
            protection += a.getProtection();
        }
        return protection;
    }

}
