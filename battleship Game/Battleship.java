package ms4;


public class Battleship {

	public static void main(String[] args) {
	/*Comments for Grader:
	 *1) Please note that I put the playing Against the two AI Players (#1 on the extra credit) option
	 * and playing against a human player option(#2 on the extra Credit) option in one menu and 
	 * one loop. Prof. Zjang said it is fine to do so. so Please do not Penalize me for that. 
	 * 2)the program will only print the boards if the player missed,
	 * it will not print the board in case of a hit. 
	 * 3)when testing the error checking for the firing coordinates, please 
	 * enter the x and the y. I programmed the game to wait for the two coordinates then 
	 * check for the errors. 
	 * 
	 */
		
		
		int hits = 0;
		int hits2 = 0;
		int Guesses= 0;
		int Guesses2 = 0;
		
		System.out.println("*******Welcome To Battleship******");
		System.out.println("\n"+"The Objective of This Game is to Sink Your Opponint's Ships as Fast as You Can by Guessing The Coordinates on the Board");
		System.out.println("How do You Want to Play The Game?");
		System.out.println("\n"+"Choose(1 or 2 or 3) from the menu below:");   
		System.out.println("1. Vs Easy Computer player");
		System.out.println("2. Vs Another Player. ");
		System.out.println("3. Vs Difficult Computer Player");
		int gamechoice = IO.readInt();
			if(gamechoice > 3 || gamechoice < 1)
					do{
					System.out.println("Invalid Choice, Please Try Again"); 
					System.out.println("\n"+"Choose(1 or 2 or 3) From the Menu:");   
					System.out.println("1. Vs. Easy Computer Player");
					System.out.println("2. Vs. Another Player. ");
					System.out.println("3. Vs  Difficult Computer Player");

					gamechoice = IO.readInt();
			 	}while(gamechoice > 3 || gamechoice < 1);
			
		 if(gamechoice == 1){
				
				
			System.out.println("************* Starting Easy Computer AI-Player Vs. Human Player Mood***************"+"\n");
			Boolean turn=true;
			System.out.println("Player, Please Place Your Ships!!");
			Player p1 = new Player_kaf206();
			p1.placeShips();
			
			Player p2 = new EaAIPlayer_kaf206();
			p2.placeShips();
			System.out.println("\n"+"Starting the Game");
			boolean playertwowon = p1.lost();
			boolean playeronewon = p2.lost();
			
			do{	
			
				if(turn == true){
					//int hits = 0;
					System.out.println("\n"+"\n"+"Player!!!");
					Coordinate p1coordinates = p1.fire();
					char p1result = p2.fireUpon(p1coordinates);
						p1.fireResult(p1result);
						Guesses++;
						if(p1result != 'M'){
							hits++;
						}
						if(hits == 17){
							System.out.println("\n"+"******Congratulations Player 1, YOU WON*******");
							System.out.println("Number of Guesses"+ Guesses);
							return;
						}
					turn = false;
					
				}else if (turn == false){
					
					System.out.println(" \n"+"Computer Player!!!");
					Coordinate p2c1 = p2.fire();
					char p2result = p1.fireUpon(p2c1);
					p2.fireResult(p2result);
					Guesses2++;
					if(p2result != 'M'){
						hits2++;
					}
					if(hits2 == 17){
						System.out.println("\n"+"*******Computer Player WON!!!*******");
						System.out.println("Number of Guesses"+ Guesses);

						return;
						
					}
					turn = true;
				}
				
			}while (playertwowon == false || playeronewon == false );
			
	
		
	
		}else if (gamechoice == 2 ){
			System.out.println("************  Starting Player Vs Human Player Mood****" +"\n"+"Welcome Players");
			
			Boolean turn=true;
			System.out.println("\n"+"Player one, Please Place Your Ships!!");
			Player p1 = new Player_kaf206();
			p1.placeShips();
			System.out.println("\n"+"Player Two, Please Place Your Ships!!");
			Player p2 = new Player_kaf206();
			p2.placeShips();
			System.out.println("\n"+"Starting the Game");
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
						
						}
						
	
						if(hits == 17){
							System.out.println("\n"+"**************Congratulations, Player 1 , YOU WON !!!!*************");
							System.out.println("Number of Guesses"+ Guesses);

							return;
						}
					turn = false;
					
				}else
					
					if (turn == false){
					//int hits2 = 0;
					System.out.println(" \n"+"Player two!!!");
					Coordinate p2c1 = p2.fire();
					char p2result = p1.fireUpon(p2c1);
					p2.fireResult(p2result);
					Guesses2++;
					if(p2result != 'M'){
						hits2++;
						
					}
					
					if(hits2 == 17){
						System.out.println("\n"+"**********Congratulations, Player 2, YOU WON!!********");
						System.out.println("Number of Guesses"+ Guesses);
						return;
					}
					turn = true;
				}
				
			}while (playertwowon == false || playeronewon == false );
					
		
		}else  if(gamechoice == 3){
			
			
		System.out.println("************* Starting Difficult Computer AI-Player Vs. Human Player Mood***************"+"\n");
		Boolean turn=true;
		System.out.println("Player, Please Place Your Ships!!");
		Player p1 = new Player_kaf206();
		p1.placeShips();
		
		Player p2 = new DifAIPlayer_kaf206();
		p2.placeShips();
		System.out.println("\n"+"Starting the Game");
		boolean playertwowon = p1.lost();
		boolean playeronewon = p2.lost();
		
		do{	
		
			if(turn == true){
				//int hits = 0;
				System.out.println("\n"+"\n"+"Player!!!");
				Coordinate p1coordinates = p1.fire();
				char p1result = p2.fireUpon(p1coordinates);
					p1.fireResult(p1result);
					Guesses++;
					if(p1result != 'M'){
						hits++;
					}
					if(hits == 17){
						System.out.println("\n"+"******Congratulations Player 1, YOU WON*******");
						System.out.println("Number of Guesses"+ Guesses);

						return;
					}
				turn = false;
				
			}else if (turn == false){
				
				System.out.println(" \n"+"Computer Player!!!");
				Coordinate p2c1 = p2.fire();
				char p2result = p1.fireUpon(p2c1);
				p2.fireResult(p2result);
				Guesses2++;
				if(p2result != 'M'){
					hits2++;
				}
				if(hits2 == 17){
					System.out.println("\n"+"*******Computer Player WON!!!*******");
					System.out.println("Number of Guesses"+ Guesses);

					return;
					
				}
				turn = true;
			}
			
		}while (playertwowon == false || playeronewon == false );
		
				
		}
			
	}
	
}
		
	
	
