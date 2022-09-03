package players;
public class ArcherPlayer extends Player {
    final int default_health = 18;
    
    public ArcherPlayer(String name) {
        super(2, name, 7, 18, 20);
    }

    public void heal() {
        setHealth(default_health);
    }
}
