package players;
public class KnightPlayer extends Player {
    final int default_health = 24;

    public KnightPlayer(String name) {
        super(3, name, 8, 24, 5);
    }

    public void heal() {
        setHealth(default_health);
    }
}
