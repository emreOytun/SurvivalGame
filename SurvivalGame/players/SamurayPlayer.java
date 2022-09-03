package players;
public class SamurayPlayer extends Player {
    final int default_health = 21;

    public SamurayPlayer(String name) {
        super(1, name, 5, 21, 15);
    }

    public void heal() {
        setHealth(default_health);
    }
}
