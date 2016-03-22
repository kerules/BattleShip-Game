package ms4;

public class DifAIPlayer_kaf206 implements Player{

	private int coordX = 0;
	private int coordY = 0;
	private char [][] boardA= new char [10][10]; 
	private char [][] boardB = new char [10][10];
	 private Coordinate c2 ; 
	 public DifAIPlayer_kaf206(){
		 initBoard(boardA);
		 initBoard(boardB);
	 }
	
	
	public char fireUpon(Coordinate x){
		Coordinate c1 = x;
		if(boardA[c1.x][c1.y] == 'A'){
			
			System.out.println("OUTCH!!!!!you hit A Ship ");
			return 'A';
		
		}else if(boardA[c1.x][c1.y] == 'B'){
		
			System.out.println("OUTCH!!!!!!you hit A Ship ");
			return 'B';
		
		}else if(boardA[c1.x][c1.y] == 'S'){
			
			System.out.println("OUTCH!!!!!!you hit a Ship ");
			return 'S';
		
		}else if(boardA[c1.x][c1.y] == 'D'){
			
			System.out.println("OUTCH!!!!!you hit a Ship");
			return 'D';
		
		}else if (boardA[c1.x][c1.y] == 'P'){
		
			System.out.println("OUTCH!!!!!you hit a Ship ");
			return 'P';
	
		}else{
		
			boardA[c1.x][c1.y] = 'M';
			System.out.println("You Missed Dude!!");
			return 'M';	
			
		}
	}
	/*My Firing strategy is as follows:
	 * 1) I divided the board into two halves. The computer player will first fire in the first
	 * half randomly five times, then it will switch to the second have of the board and fire 
	 * five times. 
	 * 2) the player will alternate back and forth between the two halves of the board till
	 * the ships are sunk.   
	 * 3)This strategy will enable the player to have a better grasp at the board and hit all
	 * the ships efficiently.
	 * 4)this Strategy will also enable the player too seek out the ships and sink them in less
	 * tries or guesses than the easy player.
	 * 
	 */
public Coordinate fire(){
	int count=0;
	boolean Switch = false;
	
	do{
		if(Switch == false){
	int coordX = (int)(Math.random()*5);
	int coordY = (int)(Math.random()*5);
	
	Coordinate c1 = new Coordinate(coordX, coordY);
	c2 = c1;
	count++;
	
	
	if(count == 5)
		Switch = true;
		return c1;
	}else if(Switch == true){
		
		int coordX = (int)(Math.random()*9+5);
		int coordY = (int)(Math.random()*9+5);
		
		Coordinate c1 = new Coordinate(coordX, coordY);
		c2 = c1;
		count++;
		
		
		if(count == 5)
			Switch = false;
		return c1;
		
	}
	
	}while(count<25);
	return c2; 
}

public void fireResult(char result){
			
			if(result == 'M'){
				boardB[c2.x][c2.y] = 'M';
				printBoardB();
			}else if(result == 'H'){
				boardB[c2.x][c2.y] = 'H';
				printBoardB();
			}
			
		}
		public static void initBoard(char[][] board){
			 for (int i=0;i<board.length;i++){
				 for(int j=0;j<board[i].length;j++){
					 board[i][j]='~';
			 }
		 }	 
	}
		/*My Strategy for placing the Ships will follow these simple steps:
		 * 1) Place the smallest ship (patrol Board) on the far Edge-side of the 
		 * Board(column #9) or the very bottom row (row #9) but not on the corner. That way 
		 * it will be harder to be found because it is small and players don't usually guess 
		 * on the edge that often. 
		 * 2) have at least two ships touch in a perpendicular fashion, or an L shaped fashion
		 * that way it will confuse the player when firing.(this strategy will require the 
		 * fireUpon() method to only produce a "hit" message or a "miss" message, not the ship 
		 * type, to make it even tougher for the player to guess.  
		 * 3)Always Place the AirCraft Carrier (the biggest ship) vertically. This method will make it 
		 * harder for the player to find the ship.
		 * 
		 */
		public void placeShips(){
			
			//placing a patrol boat size 2.
			 int coordYP = (int)(Math.random()*7+1);
			 int coordXP = (int)(Math.random()*7+1);
			 int choice5 = (int)(Math.random()*2+1);
			 if(choice5 == 1){
				 
				 boardA[9][coordYP]= 'P';
				 boardA[9][coordYP+1] = 'P';
			
				 
			 
			 }else if(choice5 == 2 ){
				 
				 boardA[coordXP][9] = 'P';
				 boardA[coordXP+1][9] = 'P';
			
			 }
			//placing an Aircraft Carrier size 5.
			 int coordXA = 0;
			 int coordYA = 0;
		
				do{ 
			 		  coordXA = (int)(Math.random()*4);
					  coordYA = (int)(Math.random()*4);
				
				//choice =1 is horizontal, choice = 2 is vertical.
				
				}while(boardA[coordXA][coordYA] != '~' || boardA[coordXA+1][coordYA] !='~' || boardA[coordXA+2][coordYA] !='~' || boardA[coordXA+3][coordYA] !='~' || boardA[coordXA+4][coordYA] !='~' );
				
				boardA[coordXA][coordYA] = 'A';
				boardA[coordXA+1][coordYA] = 'A';
				boardA[coordXA+2][coordYA] = 'A';
				boardA[coordXA+3][coordYA] = 'A';
				boardA[coordXA+4][coordYA] = 'A';
			//placing a submarine 
				 int coordXS =0;
				 int coordYS = 0;
				
					 do{
							
						 coordXS = (int)(Math.random()*4);
						 coordYS = (int)(Math.random()*4);
					
					//choice =1 is horizontal, choice = 2 is vertical.
					
					}while(boardA[coordXS][coordYS] != '~' || boardA[coordXS][coordYS+1] !='~' || boardA[coordXS][coordYS+2] !='~');
					
					 boardA[coordXS][coordYS] = 'S';
					 boardA[coordXS][coordYS+1] = 'S';
					 boardA[coordXS][coordYS+2] = 'S';
					 
			//placing a battleship size 4.
			 int coordXB = (int)(Math.random()*3);
			 int coordYB = (int)(Math.random()*3);
			 int choice2 = (int)(Math.random()*2+1);
			 if(choice2 == 1){
				 do{
						
					 coordXB = (int)(Math.random()*3);
					 coordYB = (int)(Math.random()*2);
				
				//choice =1 is horizontal, choice = 2 is vertical.
				
				}while(boardA[coordXB][coordYB] != '~' || boardA[coordXB][coordYB+1] !='~' || boardA[coordXB][coordYB+2] !='~' || boardA[coordXB][coordYB+3] !='~');
				
				 boardA[coordXB][coordYB] = 'B';
				 boardA[coordXB][coordYB+1] = 'B';
				 boardA[coordXB][coordYB+2] = 'B';
				 boardA[coordXB][coordYB+3] = 'B';
			 
			 }else if(choice2 == 2 ){
				 do{
						
					 coordXB = (int)(Math.random()*3);
					 coordYB = (int)(Math.random()*3);
				
				//choice =1 is horizontal, choice = 2 is vertical.
				
				}while(boardA[coordXB][coordYB] != '~' || boardA[coordXB+1][coordYB] !='~' || boardA[coordXB+2][coordYB] !='~' || boardA[coordXB+3][coordYB] !='~' );
				
				 boardA[coordXB][coordYB] = 'B';
				 boardA[coordXB+1][coordYB] = 'B';
				 boardA[coordXB+2][coordYB] = 'B';
				 boardA[coordXB+3][coordYB] = 'B';
				 
			 }
		
			  
		//placing a Destroyer size 3
			 int coordXD = (int)(Math.random()*6);
			 int coordYD = (int)(Math.random()*6);
			 int choice4 = (int)(Math.random()*2+1);
			 if(choice4 == 1){
				 do{
						
					 coordXD = (int)(Math.random()*6);
					 coordYD = (int)(Math.random()*6);
				
				//choice =1 is horizontal, choice = 2 is vertical.
				
				}while(boardA[coordXD][coordYD] != '~' || boardA[coordXD][coordYD+1] !='~' || boardA[coordXD][coordYD+2] !='~' );
				
				 boardA[coordXD][coordYD] = 'D';
				 boardA[coordXD][coordYD+1] = 'D';
				 boardA[coordXD][coordYD+2] = 'D';
				 
			 
			 }else if(choice4 == 2 ){
				 do{
						
					 coordXD = (int)(Math.random()*6);
					 coordYD = (int)(Math.random()*6);
				
				//choice =1 is horizontal, choice = 2 is vertical.
				
				}while(boardA[coordXD][coordYD] != '~' || boardA[coordXD+1][coordYD] !='~' || boardA[coordXD+2][coordYD] !='~' );
				 
				 boardA[coordXD][coordYD] = 'D';
				 boardA[coordXD+1][coordYD] = 'D';
				 boardA[coordXD+2][coordYD] = 'D';
			 	}
			
			 printBoard();
			}
	

		
		
		
		public void printBoardB(){
			for(int i=0;i<10; i++ )
				System.out.print("  "+ i+"  ");
					
			System.out.println();
			for(int i=0; i <boardB.length; i++){
				System.out.print(i+" ");
				for(int j=0; j<boardB[i].length; j++){
				System.out.print(boardB[i][j] +"    ");
					}
				System.out.println();
		}
	}

		public void printBoard() {
			for(int i=0;i<10; i++ )
				System.out.print("  "+ i+"  ");
					
			System.out.println();
			for(int i=0; i <boardA.length; i++){
				System.out.print(i+" ");
				for(int j=0; j<boardA[i].length; j++){
				System.out.print(boardA[i][j] +"    ");
					}
				System.out.println();
			}
			
		}
		
		public boolean lost() {
			int hits=0;
			for(int i= 0; i<boardA.length; i++){
				for(int j= 0; j<boardA[i].length; j++){
					if(boardA[i][j] =='H')
						hits++;
				}}
			if(hits == 17){
				System.out.println("Player has won!!");
			return true;
			}else{
			return false;
		}
	}
}