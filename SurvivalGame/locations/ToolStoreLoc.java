package locations;
import java.util.Scanner;

import players.Player;
import weapons.*;
import armors.*;

public class ToolStoreLoc extends Location {
    public ToolStoreLoc(Player player) {
        super(player, "ToolStore");
    }

    private int mainMenu() {
        Scanner scan = new Scanner(System.in);
        
        boolean taken = false;
        int choice = -1;
        do {

            System.out.println("Welcome to ToolStore!");
            System.out.println("What do you want to purchase?");
            System.out.println("1-Weapon");
            System.out.println("2-Armor");
            System.out.println("3-Cancel");
            System.out.println("Your money = " + player.getMoney());
            System.out.print("Your choice = ");
            
            if (scan.hasNextInt()) {
                choice = scan.nextInt();
                if (1<=choice && choice <= 3) {
                    taken = true;
                }
            
            } else {
                scan.nextLine();
                System.out.println("Enter a number in range 1-3 !");
            }

        }while(!taken);

        return choice;
    }

    private void weaponMenu() {
        
        Scanner scan = new Scanner(System.in);
        
        boolean taken = false;
        int choice = -1;
        do {
            System.out.println("1.Pistol <Price: 25 - Damage: +2");
            System.out.println("2.Sword <Price: 34 - Damage: +4");
            System.out.println("3.Rifle <Price: 45 - Damage: +7");
            System.out.println("4.Cancel");
            System.out.print("Your choice = ");

            if (scan.hasNextInt()) {
                choice = scan.nextInt();
                if (1<=choice && choice <= 4) {
                    taken = true;
                }
            
            } else {
                scan.nextLine();
                System.out.println("Enter a number in range 1-3 !");
            }

        }while(!taken);

        switch(choice) {
            case 1 :
                player.buyWeapon(new PistolWeapon(), 25);
                break;

            case 2 :
                player.buyWeapon(new SwordWeapon(), 34);
                break;

            case 3 :
                player.buyWeapon(new RifleWeapon(), 45);
                break;

            case 4 :
                System.out.println("Toolstore: Goodbye!");
                break;
        }
    
    }

    private void armorMenu() {
        Scanner scan = new Scanner(System.in);
        
        boolean taken = false;
        int choice = -1;
        do {
            System.out.println("1.Low Armor <Price: 15 - Protection: +1");
            System.out.println("2.Medium Armor <Price: 25 - Protection: +3");
            System.out.println("3.Heavy Armor <Price: 40 - Protection: +5");
            System.out.println("4.Cancel");
            System.out.print("Your choice = ");

            if (scan.hasNextInt()) {
                choice = scan.nextInt();
                if (1<=choice && choice <= 4) {
                    taken = true;
                }
            
            } else {
                scan.nextLine();
                System.out.println("Enter a number in range 1-3 !");
            }

        }while(!taken);

        switch(choice) {
            case 1 :
                player.buyArmor(new LowArmor(), 15);
                break;

            case 2 :
                player.buyArmor(new MediumArmor(), 25);
                break;

            case 3 :
                player.buyArmor(new HeavyArmor(), 40);
                break;

            case 4 :
                System.out.println("Toolstore: Goodbye!");
                break;
        }
    
    }

    @Override
    public void menu() {
        int choice = mainMenu();
        switch(choice) {
            case 1 :
                weaponMenu();
                break;

            case 2 :
                armorMenu();
                break;

            case 3 :
                System.out.println("Toolstore: Goodbye!");
                break;
        }

    }
}
