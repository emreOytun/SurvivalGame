package locations;
import java.util.ArrayList;

import mobs.BearMob;
import mobs.Mob;
import players.Player;
import stuffs.WaterStuff;

public class RiverLoc extends BattleLoc {
    private ArrayList<Mob> generateBears() {
        int zombie_num = 1 + (int)Math.random()*100 / 3;     
        
        ArrayList<Mob> bears = new ArrayList<Mob>();
        for (int i = 0; i < zombie_num; i++) {
            bears.add(new BearMob());
        }   
    
        return bears;
    }
    
    public RiverLoc(Player player) {
        super(player, "Restaurant", new WaterStuff());
        super.setMobs(generateBears()); 
    }
}
