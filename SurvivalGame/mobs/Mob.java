package mobs;
public abstract class Mob {
    private String name;
    private int damage;
    private int health;
    private int money;

    public Mob(String name, int damage, int health, int money) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.money = money;
    }

    public String stats() {
        return "Enemy Stats\n" +
                "------------------\n" +
                "Health: " + health + "\n" +
                "Damage: " + damage + "\n";
    }

    public boolean isAlive() {
        if (health > 0) return true;
        else return false;
    }

    public int getMoney() {return money;}
    public String getName() {return name;}
    public int getHealth() {return health;}

    public void getDamage(int enemy_damage) {
        health -= enemy_damage;
    }

    public int attack() {
        return damage;
    }
}
