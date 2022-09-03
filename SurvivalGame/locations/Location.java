package locations;
import players.Player;

public abstract class Location {
    protected Player player;
    private String name;

    public Location(Player player, String name) {
        this.player = player;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void menu();
}
