package armors;
public abstract class Armor {
    private int id;
    private String name;
    private int protection;

    public Armor(int id, String name, int protection) {
        this.id = id;
        this.name = name;
        this.protection = protection;
    }

    public String toString() {
        return name + " +" + protection + " protection"; 
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getProtection() {
        return protection;
    }

}
