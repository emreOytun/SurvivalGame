package locations;
import java.util.ArrayList;
import java.util.Scanner;

import mobs.Mob;
import players.Player;
import stuffs.Stuff;


public abstract class BattleLoc extends Location{
    private ArrayList<Mob> mobs;
    private Stuff prize;
    
    BattleLoc(Player player, String locationName, Stuff prize) {
        super(player, locationName);
        this.prize = prize;
    }

    public void setMobs(ArrayList<Mob> mobs) {
        this.mobs = mobs;
    }

    @Override
    public void menu() {
        Scanner scan = new Scanner(System.in);
        boolean isTaken = false;
        String choice = "";
        do {
            System.out.println("You are in " + getName() + " !!!");
            System.out.println("!! Be careful !! There are " + mobs.size() + " " + mobs.get(0).getName() + " in the " + getName());
            System.out.print("<C>ombat or <F>lee ? = ");

            choice = scan.next();
            if (choice.toLowerCase().equals("c")) {
                combat();
                isTaken = true;
            } 

            else if (choice.toLowerCase().equals("f")) {
                System.out.println("COWARD !");
                isTaken = true;
            }

            else {  /* !!! SCAN.NEXTLINE() YAPMAK GEREKIR MI ???  */
                System.out.println("Enter 'c' or 'f' characters !! ");
            }
        
        }while(!isTaken);
    }

    private void combat() {
        Scanner scan = new Scanner(System.in);
        boolean isDone = false;
        do {
            System.out.println(player.stats());    
            System.out.println(mobs.get(0).stats());    
            
            System.out.print("<H>it or <F>lee ? = ");
            String choice = scan.next();

            if (choice.toLowerCase().equals("h")) {
                System.out.println("You hit the enemy !");
                mobs.get(0).getDamage(player.attack());    
                System.out.println("Player health = " + player.getHealth());
                System.out.println(mobs.get(0).getName() + " health = " + mobs.get(0).getHealth());
                
                System.out.println("\nEnemy hits you !");
                player.getDamage(mobs.get(0).attack());
                System.out.println("Player health = " + player.getHealth());
                System.out.println(mobs.get(0).getName() + " health = " + mobs.get(0).getHealth());
             
                // If player is dead after combat
                if (player.isAlive() == false) {
                    System.out.println("You died !!!");
                    isDone = true;
                }

                // If enemy is dead after combat
                else if (mobs.get(0).isAlive() == false) {
                    System.out.println("You killed the enemy!");
                    player.addMoney(mobs.get(0).getMoney());
                    mobs.remove(0);
                
                    // If there are no enemies anymore in the location
                    if (mobs.isEmpty() || mobs.size() == 0) {
                        System.out.println("\nYou killed all of the enemies !");
                        System.out.println("You earned " + prize.getName() + " :) :)") ;
                        player.addStuff(prize);       
                        isDone = true;
                    }
                }
            }
            
            else if (choice.toLowerCase().equals("f")) {
                System.out.println("COWARD !");
                isDone = true;
            }

            else {  /* !!! SCAN.NEXTLINE() YAPMAK GEREKIR MI ???  */
                System.out.println("Enter 'c' or 'f' characters !! ");
            }

        }while(!isDone);
    }

}
