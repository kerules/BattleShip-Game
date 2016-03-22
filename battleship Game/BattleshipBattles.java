package ms4;
/* The Testing of the two algorithms against each other, I found:
 * 1) the Difficult Player won 100% of the time. 
 *		Explanation: the Difficult player was able to win every time because of the placement 
 *			of the ships, in particular, the patrol boat that is very hard to hit. Also, the 
 *			firing strategy was better in that it enabled the difficult player to get to the 
 *			easy player's ships faster and more efficient. 
 * 2) the number of guesses alternated all the time between fewer guesses and more guesses.
 * 		Explanation: This depended on the randomness of the Easy AIPlayer's Placement of the 
 * 			ships.However, The number of Guesses will not exceed 80 times in the most difficult  
 *			game to sink all the ships. The best Game was a win for the difficult AI PLayer in 
 * 			34 guesses.
 * 
 */


public class BattleshipBattles {

	public static void main(String[] args) {
		int hits=0;
		int hits2 = 0;
		int Guesses= 0;
		int Guesses2=0;
		System.out.println("*******Welcome To BattleshipBattles Class******");
		System.out.println("\n"+"Here, we will test different AI Strategies Aganist Each Other to determine which one is the best");
		Boolean turn=true;
		System.out.println("\n"+"Easy Player placing the Ships!!");
		Player p1 = new EaAIPlayer_kaf206();
		p1.placeShips();
		System.out.println("\n"+"difficults player placing the ships !!");
		Player p2 = new DifAIPlayer_kaf206();
		p2.placeShips();
		System.out.println("Starting the Game");
		boolean playertwowon = p1.lost();
		boolean playeronewon = p2.lost();
		
		
		do{	
		
			if(turn == true){
				
				System.out.println("Player one!!!");
				Coordinate p1coordinates = p1.fire();
				char p1result = p2.fireUpon(p1coordinates);
					p1.fireResult(p1result);
					Guesses++;
					if(p1result != 'M' ){
						hits++;
					//System.out.println(hits);
					}
					if(hits == 17){
						System.out.println("Congratulations, Esay Player  , YOU WON !!!!");
						System.out.println("Number Of Guesses = "+ Guesses);
						return;
					}
				turn = false;
				
			}else if (turn == false){
				
				System.out.println(" \n"+"Player two!!!");
				Coordinate p2c1 = p2.fire();
				char p2result = p1.fireUpon(p2c1);
				p2.fireResult(p2result);
				Guesses2++;
				if(p2result != 'M'){
					
					hits2++;
					//System.out.println(hits2);
				}
				if(hits2 == 17){
					System.out.println("Congratulations, Difficult Player, YOU WON!!");
					System.out.println("Number Of Guesses = "+ Guesses);

					return;
				}
				turn = true;
			}
			
		}while (playertwowon == false || playeronewon == false );
	}
	


	}


