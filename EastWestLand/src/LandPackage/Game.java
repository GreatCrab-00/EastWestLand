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
	private int pHealth,pHMax;//other player stats listed here
	private int[] itemBag;
	
	
	
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
		pHMax = 50;
		pHealth = pHMax;
		
		
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
	
	
	
	//player Behaviors
	public void PlayerAttack() {
		
	}
	public void PlayerItem() {
		
	}
	public void PlayerCheck() {
		
	}
	public void PlayerDodge() {
		
	}
	
	
	//Boss Behaviors
	public void BossAttack() {
		switch(bossNum) {
		case 1:
			 System.out.println("The " + BossName() + " Proposes a series of intricate and dense series of formulas and theories that you can't quite comprehend.");//
			break;
		case 2:
			System.out.println("The " + BossName() + " Raises a few skeletons from the ground who then throw their ribcages at you before falling apart.");//
			break;
		case 3:
			System.out.println("The " + BossName() + " Slithers through some thorn bushes and you take the most direct path to catch it.");//
			break;
		case 4:
			System.out.println("The " + BossName() + " summons all words that include \"T\" to attack you.");//
			break;
		case 5:
			System.out.println("The " + BossName() + " Raises his sword to reflect the light of the eclipse directly back into your eyes.");//
			break;
		default:
			System.out.println("The " + BossName() + " Starts breaking the world around you.");//
			break;
		}
	}
	public void BossSetUp() {
		
	}
	public String BossName() {
		String name = "";
		switch(bossNum) {
		case 1:
			name = "Rombus";
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
