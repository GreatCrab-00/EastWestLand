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
	
	
	
	
	//Boss Behaviors
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
}
