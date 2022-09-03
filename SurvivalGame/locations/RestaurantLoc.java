package locations;
import java.util.ArrayList;

import mobs.Mob;
import mobs.ZombieMob;
import players.Player;
import stuffs.FoodStuff;

public class RestaurantLoc  extends BattleLoc{
    private ArrayList<Mob> generateZombies() {
        int zombie_num = 1 + (int)Math.random()*100 / 3;     
        
        ArrayList<Mob> zombies = new ArrayList<Mob>();
        for (int i = 0; i < zombie_num; i++) {
            zombies.add(new ZombieMob());
        }   
    
        return zombies;
    }
    
    public RestaurantLoc(Player player) {
        super(player, "Restaurant", new FoodStuff());
        super.setMobs(generateZombies()); 
    }
}
