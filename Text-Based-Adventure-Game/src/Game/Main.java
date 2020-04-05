package Game;

import java.util.Random;
import java.util.Scanner;

public class Main {
public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
	Random rand=new Random();
//Enemy 
	String[] enemies= {"Skeleton","Zombie","Warrior","Assassin"};
	int maxenemyHealth=100;
	int enemyAttackDamage=25;
	int coins=0;
	int coinDropChance=20;
	int legendaryWeapon=0;
	int legendaryWeaponChance=100;
//Hero
	int health=100;
	int damage=50;
	int numHealthPots=3;
	int healthPotHealAmount=25;
	int potDropChance=30;
	boolean run=true;
	
	System.out.println("Welcome to the Dungeon!");
	GAME:
	while (run) {
		System.out.println("----------------------------------------------");
		int enemyHealth=rand.nextInt(maxenemyHealth);
		String enemy=enemies[rand.nextInt(enemies.length)];
		System.out.println("\t#"+enemy+"appeared!!! #\n");
		while (enemyHealth>0) {
			System.out.println("\tYour HP:"+health);
			System.out.println("\t"+enemy+"'s HP"+enemyHealth);
			System.out.println("\n\tWhat would you like to do?");
			System.out.println("\t1. Attack");
			System.out.println("\t2. Drink helath pot.");
			System.out.println("\t3. Run!");
			String input=scan.nextLine();
			if (input.equals("1")) {
				int damageDealt=rand.nextInt(damage);
				if (legendaryWeapon>=1) {
					 damageDealt+=50;
				}
				int damageTaken=rand.nextInt(enemyAttackDamage);
				enemyHealth-=damageDealt;
				health-=damageTaken;
				System.out.println("\t> You strike the "+enemy+" for "+damageDealt+" damage!");
				System.out.println("\t> You recieve "+damageTaken+" in retaliation!");
				if (health<1) {
					System.out.println("\t> Youhave taken too much damage, you are too weak to go on!");
					break;
				}
			}else if (input.equals("2")) {
				if (numHealthPots>0) {
					health+=healthPotHealAmount;
					numHealthPots--;
					System.out.println("\t> You drink a health pot, healing yourself for"
							+healthPotHealAmount+".\n\t> You now have "+health+" HP.\n\t> You have "
							+numHealthPots+"health pot left \n");
				}else {
					System.out.println("\t> You have no health pot left! Defeat enemies for a chance to get one!\n");
				}
			}else if (input.equals("3")) {
				System.out.println("\t> You run away from the"+enemy+"!");
				continue GAME;
			}else {
				System.out.println("\t> Invalid command.");
			}
		}
		if (health<1) {
			System.out.println("You limp out the dungeon, weak from battle.");
			break;
		}
		System.out.println("----------------------------------------------");
		System.out.println("# "+enemy+"was defeated!#");
		System.out.println("# You have "+health+"HP left. #");
		if (rand.nextInt(100)<potDropChance) {
			numHealthPots++;
			System.out.println(" # The "+enemy+" dropped a health pot! #");
			
		}
		if (rand.nextInt(100)<coinDropChance) {
			coins++;
			System.out.println(" # The "+enemy+"dropped a coin! #\n # You have "+coins+" coins. #");
		}if (rand.nextInt(100)<legendaryWeaponChance) {
			System.out.println("# YOU DROPPED LEGENDARY WEAPON!!! #");
			legendaryWeapon++;
		}
		if (coins>100) {
			System.out.println("# You can buy Legendary Weapon!!! \n Do you want to buy? \n\t> 1. Yes\n\t> 2.No");
			String input=scan.nextLine();
			if (input.equals("1")) {
				System.out.println("# You have Legendary Weapon now. #");
				legendaryWeapon++;
			}else if (input.equals("2")) {
				System.out.println("# See you later. #");
			}else {
				System.out.println("# Invalid command. #");
			}
		}
		System.out.println("----------------------------------------------");
		System.out.println("What do you like to do now?");
		System.out.println("1. Continue fighting");
		System.out.println("2. Exit dungeon");
		String input=scan.nextLine();
		while (!input.equals("1")&&!input.equals("2")) {
			System.out.println("Invalid command!");
			input=scan.nextLine();
		}
		if (input.equals("1")) {
			System.out.println("You continue on your adventure!");
		}else if (input.equals("2")) {
			System.out.println("You exit the dungeon,succesful from your adventures!");
			break;
		}
	}
	System.out.println("########################");
	System.out.println("# THANKS FOR PLAYING #");
	System.out.println("########################");
}
}
