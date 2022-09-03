import java.util.Scanner;

import players.*;
import locations.*;

public class Main {
    private static Player characterMenu(String playerName) {
        
        Scanner scan = new Scanner(System.in);
        int choice = -1;
        boolean isTaken = false;
        
        System.out.println("Welcome " + playerName + " !!");
        do {
            System.out.println("Select Warrior !");
            System.out.println("1) Samurai");
            System.out.println("2) Sniper");
            System.out.println("3) Knight");
            System.out.print("Your choice = ");

            if (scan.hasNextInt()) {
                choice = scan.nextInt();
                if (1<=choice && choice<=3) {
                    isTaken = true;
                }
            }

            else {
                scan.nextLine();
                System.out.println("Enter a number in range 1-3 !!");
            }

        }while (!isTaken);
    
        Player player = new SamurayPlayer(playerName);
        switch(choice) {
            case 1 :
                player = new SamurayPlayer(playerName);
                break;

            case 2 :
                player = new ArcherPlayer(playerName);
                break;

            case 3 :
                player = new KnightPlayer(playerName);
                break;
        }

        System.out.println("Warrior created successfully!");
        System.out.println(player.toString());
        return player;
    }

    private static String nameMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter your name : ");
        
        return scan.nextLine();
    }

    private static Location locationMenu(Player player) {
        Scanner scan = new Scanner(System.in);
        int choice = -1;
        boolean isTaken = false;
        
        do {
            System.out.println("Please select location you want to go!");
            System.out.println("1) Safehouse -> Your village, no enemies!");
            System.out.println("2) Restaurant -> There will be zombies!");
            System.out.println("3) Forest -> There will be vampires!");
            System.out.println("4) River -> There will be bears!");
            System.out.println("5) Toolstore -> You can buy armors/weapons!");
            System.out.print("Your choice = ");

            if (scan.hasNextInt()) {
                choice = scan.nextInt();
                if (1<=choice && choice<=5) {
                    isTaken = true;
                }
            }

            else {
                scan.nextLine();
                System.out.println("Enter a number in range 1-4 !!");
            }

        }while (!isTaken);
    
        Location loc = new SafeHouseLoc(player);
        switch(choice) {
            case 1 :
                break;

            case 2 :
                loc = new RestaurantLoc(player);
                break;

            case 3 :
                loc = new ForestLoc(player);
                break;

            case 4 :
                loc = new RiverLoc(player);
                break;

            case 5 :
                loc = new ToolStoreLoc(player);
                break;
        }

        return loc;
    }
    public static void main(String[] args) {
        Player player = characterMenu(nameMenu());
        
        boolean isRunning = true;
        do {
            Location loc = locationMenu(player);
            loc.menu();

            if (player.isFinished()) {
                System.out.println("You collected all of stuff !");
                System.out.println("You won !");
                isRunning = false;
            }

            else if (player.isAlive() == false) {
                isRunning = false;
            }

        }while (isRunning);
        
    }
}