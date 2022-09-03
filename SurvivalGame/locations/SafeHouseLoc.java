package locations;

import players.Player;

public class SafeHouseLoc extends Location {
    public SafeHouseLoc(Player player) {
        super(player, "Safe House");
    }

    @Override
    public void menu() {
        player.heal();
        System.out.println("Welcome to SafeHouse !");
        System.out.println("------ You are healed --------");
    }
}
