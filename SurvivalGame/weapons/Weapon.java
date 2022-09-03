package weapons;

public abstract class Weapon {
    private int id;
    private String name;
    private int damage;

    public Weapon(int id, String name, int damage) {
        this.name = name;
        this.damage = damage;
        this.id = id;
    }

    public String toString() {
        return name + " +" + damage + " damage";
    }
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public int getDamage() {
        return damage;
    }

}
