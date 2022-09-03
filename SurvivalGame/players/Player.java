package players;

import armors.Armor;
import stuffs.Stuff;
import weapons.Weapon;

public abstract class Player {
    private String name;
    private int id;
    private int damage;
    private int health;
    private Inventory inventory;

    public Player(int id, String name, int damage, int health, int money)  {
        this.inventory = new Inventory(money);
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.health = health;
    }

    public String toString() {
        return "ID=" + id + ", Name=" + name + ", Damage=" + damage + ", Health=" + health + 
                ", Money=" + inventory.getMoney();
    }

    public String stats() {
        return "Player Stats\n" +
                "------------------\n" +
                "Health: " + health + "\n" +
                "Damage: " + damage + "\n" +
                "Weapons: " + inventory.weaponsToString() + "\n" +
                "Armors: " + inventory.armorsToString() + "\n" +
                "Money: " + inventory.getMoney() + "\n"; 
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return inventory.getMoney();
    }

    public void addMoney(int _money) {
        inventory.addMoney(_money);
    }

    public int getHealth() {
        return health;
    }
    
    public boolean isAlive() {
        if (health > 0) return true;
        else return false;
    }

    public boolean isFinished() {
        return inventory.checkStuffs();
    }

    public int attack() {
        int damage = inventory.totalDamage() + this.damage;
        return damage;
    }

    public void getDamage(int enemy_damage) {
        int protection = inventory.totalProtection();
        int absorbed_damage = enemy_damage - protection;
        if (absorbed_damage > 0) {
            health -= absorbed_damage;
        }
    }

    public abstract void heal();
    protected void setHealth(int health) {this.health = health;} 

    public void buyWeapon(Weapon weapon, int amount) {
        inventory.buyWeapon(weapon, amount);
    }

    public void buyArmor(Armor armor, int amount) {
        inventory.buyArmor(armor, amount);
    }

    public void addStuff(Stuff stuff) {
        inventory.addStuff(stuff);
    }

}
