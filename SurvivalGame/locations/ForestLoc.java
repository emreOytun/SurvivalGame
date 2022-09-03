package locations;
import java.util.ArrayList;

import mobs.Mob;
import mobs.VampireMob;
import players.Player;
import stuffs.FirewoodStuff;

public class ForestLoc extends BattleLoc {
    private ArrayList<Mob> generateVampires() {
        int zombie_num = 1 + (int)Math.random()*100 / 3;     
        
        ArrayList<Mob> vampires = new ArrayList<Mob>();
        for (int i = 0; i < zombie_num; i++) {
            vampires.add(new VampireMob());
        }   
    
        return vampires;
    }
    
    public ForestLoc(Player player) {
        super(player, "Restaurant", new FirewoodStuff());
        super.setMobs(generateVampires()); 
    }
}
