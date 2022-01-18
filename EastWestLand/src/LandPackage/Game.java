package LandPackage;
/* 1/16/22
 * Gabe E., Aiden T., David S., and Sudeep S.
 * This program will hold all of the games code.
 */



import java.util.*;
import java.lang.Math;
public class Game {
	//general properties
	Scanner reader;
	
	
	
	//player properties
	private int pHealth,str,luck,con;//other player stats listed here
	private int[] itemBag;
	private boolean dodge;
	
	
	//Boss Properties
	private int bHealth,bossNum;// other Boss related stats.
	private String bDamVul;//this variable will contain different letters that will communicate what types of vulnerabilities the current boss has
	/* b - blunt damage
	 * s - slashing damage
	 * p - piercing damage
	 * r - random damage
	 */
	
	
	
	//constructor
	public Game() {
		//general
		reader = new Scanner(System.in);
		
		
		
		//player
		str = 1;
		luck = 1;
		con = 1;
		pHealth = 30 + 20 * con;
		dodge = false;
		
		itemBag = new int[4];
		for(int i = 0; i < 4;i++)
			itemBag[i] = 0;//0 will stand for an empty slot.
		
		//boss
		bossNum = 1;
		bHealth = bossNum * 25;
		
	}
	//General Behaviors
	public int Input() {//this behavior is here to try and catch errors.
		int input;
		try {
			input = reader.nextInt();
		}catch(Exception e) {
			input = -1;
		}
		return input;
	}
	private int MRand(int min,int max) {
		return (int)((double)(max - min)*Math.random() + (double)(min)+0.5);
	}
	
	
	//player Behaviors
	public void PlayerTurn() {
		System.out.print(BossName()+" : "+bHealth +"/"+(bossNum * 25)+"\n\n\n\nYou : " + pHealth+"/"+(30 + 20 * con)+"\n\nWhat ");
	}
	
	
	
	public void PlayerAttack() {
		System.out.print("you can either attack with...\n(1) Your Hammer\n(2) Your Spear\n(3) Your Sword\n(4) Your Dice\n>>");
		int choice = 0;
		choice = Input();
		if(choice > 4|| choice < 1)
			choice = MRand(1,4);
		switch(choice) {
		case 1:
			System.out.println("You hit the "+ BossName()+" with your hammer.");
			if(bDamVul.indexOf("b") == -1) {
				System.out.println("You deal " + 3*str+ " damage.");
				bHealth -= 3*str;
			}
			else {
				System.out.println("You hear a crunch and deal " + 6*str+ " damage.");
				bHealth -= 6*str;
			}
				
			break;
		case 2:
			System.out.println("You strike the "+ BossName()+" with your Spear.");
			if(MRand(1,100)>= 100 - luck*3) {
				System.out.println("You deal a critical strike causing " + 20*str+ " damage.");
				bHealth -= 20*str;
			}
			else if(bDamVul.indexOf("p") == -1) {
				System.out.println("You deal " + 2*str+ " damage.");
				bHealth -= 2*str;
			}
			else {
				System.out.println("You hear a squelch and deal " + 4*str+ " damage.");
				bHealth -= 4*str;
			}
			break;
		case 3:
			System.out.println("You slash at the "+ BossName()+" with your sword.");
			if(bDamVul.indexOf("s") == -1) {
				System.out.println("You deal " + 5*str+ " damage.");
				bHealth -= 5*str;
			}
			else {
				System.out.println("You hear a slice and deal " + 10*str+ " damage.");
				bHealth -= 10*str;
			}
			break;
		case 4:
			int rollvalue = 0;
			
			if(str > 1)
				System.out.println("You throw a die at the "+ BossName()+".");
			else
				System.out.println("You throw some dice at the "+ BossName()+".");
			if(bDamVul.indexOf("r") == -1) {
				for(int i = 0; i < str;i++)
					rollvalue += MRand(1,8);
				System.out.println("You deal " + rollvalue+ " damage.");
				bHealth -= rollvalue;
			}
			else {
				for(int i = 0; i < str*2;i++)
					rollvalue += MRand(1,8);
				System.out.println("Your attack is strangely effective and deals " + rollvalue+ " damage.");
				bHealth -= rollvalue;
			}
			break;
		}
	}
	
	
	public void PlayerItem() {
		
	}
	
	
	public void PlayerCheck() {
		switch(bossNum) {
		case 1:
			 System.out.println("The " + BossName() + " looks very brittle and probably doesn't want probibility anywhere near it's mathematical concepts.");//Mathematical
			break;
		case 2:
			System.out.println("The " + BossName() + " is actually a Skeleton in a robe and has a heart in the middle of it's ribcage.");//
			break;
		case 3:
			System.out.println("The " + BossName() + " it is too quick for your hammer, but You can still spear it or slice it pretty easly.");//
			break;
		case 4:
			System.out.println("The " + BossName() + " You think you could easily slice it in half.");//
			break;
		case 5:
			System.out.println("The " + BossName() + " has weak points in their armor at the joints. You can also easily dent his armor.");//
			break;
		default:
			System.out.println("The " + BossName() + " has no weekness.");//
			break;
		}
	}
	
	
	public void PlayerDodge() {
		System.out.print("You begin preparing to dodge The "+BossName()+" attack.");
		if(MRand(1,100)>= 100 - luck *10)
			dodge = true;
	}
	
	
	//Boss Behaviors
	public void BossAttack() {//the behavior that regulates the bosses attacks.
		if(!dodge) {
			switch(bossNum) {
			case 1:
				System.out.println("The " + BossName() + " proposes a series of intricate and dense series of formulas and theories that you can't quite comprehend.");//
				break;
			case 2:
				System.out.println("The " + BossName() + " raises a few skeletons from the ground who then throw their ribcages at you before falling apart.");//
				break;
			case 3:
				System.out.println("The " + BossName() + " slithers through some thorn bushes and you take the most direct path to catch it.");//
				break;
			case 4:
				System.out.println("The " + BossName() + " summons all words that include \"T\" to attack you.");//
				break;
			case 5:
				System.out.println("The " + BossName() + " raises his sword to reflect the light of the eclipse directly back into your eyes.");//
				break;
			default:
				System.out.println("The " + BossName() + " Starts breaking the world around you.");//
				break;
			}
			System.out.println("You take "+(5*bossNum)+" damage.\n");
			pHealth -= 5*bossNum;
			System.out.println("You have "+pHealth+" hp remaining.");
		}
		else
			System.out.println("You roll to the left and dodge The "+BossName()+"'s attack.");
		dodge = false;
	}
	public void BossSetUp() {//this sets up the boss once the previous one has been killed. It also serves as the behavior that levels up the player between bosses.
		System.out.print("You have Successfully killed the " + BossName() + ".\nPlease choose a stat to level up.\n(1)Strength : " + str + "\n(2)Constitution : " + con + "\n(3)Luck : " + luck + "\n>>");//Constitution
		int choice = 0;
		choice = Input();
		if(choice > 3|| choice < 1)
			choice = MRand(1,3);
		switch(choice) {
		case 1:
			str++;
			System.out.println("Strength increased to " + str + ".");
			break;
		case 2:
			con++;
			System.out.println("Constitution increased to " + con + ".");
			break;
		case 3:
			luck++;
			System.out.println("Luck increased to " + luck + ".");
			break;
		default:
			System.out.println("Somehow you get no stats.");
			break;
		}
		bossNum++;
		bHealth = bossNum * 25;
		System.out.println("You suddenly encounter an even more deadlier foe than the "+BossName(1)+", the " +BossName()+".");
		switch(bossNum) {
		case 1:
			bDamVul = "br";
			break;
		case 2:
			bDamVul = "bp";
			break;
		case 3:
			bDamVul = "sp";
			break;
		case 4:
			bDamVul = "s";
			break;
		case 5:
			bDamVul = "pb";
			break;
		default:
			bDamVul = "";
			break;
		}
	}
	public String BossName(int offset) {//this overloaded behavior will display the current boss's name unless a number is put into the parameter which offsets the current boss to refer to previous bosses.
		String name = "";
		switch(bossNum-offset) {
		case 1:
			name = "Parallelogram";
			break;
		case 2:
			name = "Bone Mage";
			break;
		case 3:
			name = "Garden Snake";
			break;
		case 4:
			name = "Letter T";
			break;
		case 5:
			name = "Knight of the Eclipse";
			break;
		default:
			name = "Error";
			break;
		}
		return name;
	}
	public String BossName() {
		String name = "";
		switch(bossNum) {
		case 1:
			name = "Parallelogram";
			break;
		case 2:
			name = "Bone Mage";
			break;
		case 3:
			name = "Garden Snake";
			break;
		case 4:
			name = "Letter T";
			break;
		case 5:
			name = "Knight of the Eclipse";
			break;
		default:
			name = "Error";
			break;
		}
		return name;
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
}
