package ms4;


public class Player_kaf206 implements Player{
	// Fields
	 private  char [][] boardA = new char [10][10];
	 private char [][] boardB = new char [10][10];
	 private Coordinate c2 ; 
public Player_kaf206(){
		 initBoard(boardA);
		 initBoard(boardB);
	 }
	 
	//methods
	public char fireUpon(Coordinate x){
		Coordinate c1 = x;
		if(boardA[c1.x][c1.y] == 'A'){
			System.out.println("OUTCH!!!!!!you hit my AirCraft Carrier ");
			return 'A';
		
		}else if(boardA[c1.x][c1.y] == 'B'){
		
			System.out.println("OUTCH!!!!!!you hit my Battleship ");
			return 'B';
		
		}else if(boardA[c1.x][c1.y] == 'S'){
			
			System.out.println("OUTCH!!!!!!you hit my submarine ");
			return 'S';
		
		}else if(boardA[c1.x][c1.y] == 'D'){
			
			System.out.println("OUTCH!!!!!you hit my Destroyer ship");
			return 'D';
		
		}else if (boardA[c1.x][c1.y] == 'P'){
		
			System.out.println("OUTCH!!!!!you hit my patrol boat ");
			return 'P';
	
		}else{
		
			boardA[c1.x][c1.y] = 'M';
			System.out.println("You Missed Dude!!");
			return 'M';	
			
		}
	}
	public Coordinate fire(){
		
		
		System.out.print("\n"+"Enter your coordinate firing guess between 0-9, Enter X: ");
		int userGuess1 = IO.readInt();
		System.out.println("Enter your coordinate firing guess between, Enter Y:" );
		int userGuess2= IO.readInt();
		if(userGuess1 >9 || userGuess1<0 || userGuess2 >9 || userGuess2<0)
		do{
			System.out.println("Your Guess is Outside the Grid Dude, Try Again!!!!");
			System.out.print("\n"+"Enter your coordinate firing guess between 0-9, Enter X: ");
			userGuess1 = IO.readInt();
			System.out.println("Enter your coordinate firing guess between, Enter Y:" );
			userGuess2= IO.readInt();
		}while(userGuess1 >9 || userGuess1<0 || userGuess2 >9 || userGuess2<0);
			
		
		Coordinate c1 = new Coordinate(userGuess1, userGuess2);
		c2 = c1;
		return c1; 
		
		
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
	public void placeShips(){
		
		System.out.println("Air Craft Carrier          Size 5 ");
		System.out.println("Position The Ship By Entering one position: Enter Row:");
		int x= IO.readInt();
		System.out.println("Enter Column:");
		int y= IO.readInt();
		int choice;
	
			System.out.println("choose(1-2)   1.Horizontal    2.Vertical");
			choice = IO.readInt();
			
			 if(choice == 1){

					boardA[x][y] = 'A';
					boardA[x][y+1]= 'A';
					boardA[x][y+2]= 'A';
					boardA[x][y+3]= 'A';
					boardA[x][y+4]= 'A';
					
				}else if(choice == 2){
					boardA[x+1][y]= 'A';
					boardA[x+2][y]= 'A';
					boardA[x+3][y]= 'A';
					boardA[x+4][y]= 'A';
						
				
			}
		
			System.out.println("BattleShip   Size 4 ");
			System.out.println("Position The Ship: enter row:");
			int x2= IO.readInt();
			System.out.println("enter column:");
			int y2= IO.readInt();
			
			System.out.println("Choose(1-2)     1.Horizontal    2.Vertical");
			int choice2 = IO.readInt();
			
				if(choice2 == 1){
						boardA[x2][y2] = 'B';
						boardA[x2][y2+1]= 'B';
						boardA[x2][y2+2]= 'B';
						boardA[x2][y2+3]= 'B';
						
				}else if(choice2 == 2){
						boardA[x2][y2] = 'B';
						boardA[x2+1][y2]= 'B';
						boardA[x2+2][y2]= 'B';
						boardA[x2+3][y2]= 'B';
				}
			
			System.out.println("Submarine        Size 3 ");
			System.out.println("Position The Ship: enter row:");
			int x3= IO.readInt();
			System.out.println("Enter Column:");
			int y3= IO.readInt();
			
			System.out.println("choose (1-2)     1.Horizontal      2.Vertical");
			int choice3= IO.readInt();
				
				boardA[x3][y3] = 'S';
	
					if(choice3 == 1){
						boardA[x3][y3+1]= 'S';
						boardA[x3][y3+2]= 'S';
					}else if(choice3 == 2){
						boardA[x3+1][y3]= 'S';
						boardA[x3+2][y3]= 'S';
					}
				
			
			System.out.println("Destroyer   Size 3 ");
			System.out.println("Position The Ship: Enter row:");
			int x4= IO.readInt();
			System.out.println("Enter column:");
			int y4= IO.readInt();
			
			System.out.println("choose(1-2)    1.Horizontal    2.Vertical");
			int choice4 = IO.readInt();
				
				boardA[x4][y4] = 'D';

				if(choice4 == 1){
					boardA[x4][y4+1]= 'D';
					boardA[x4][y4+2]= 'D';
					
				}else if(choice4 == 2){
					boardA[x4+1][y4]= 'D';
					boardA[x4+2][y4]= 'D';
					
					}
				
			System.out.println("petrol boat  size 2");
			System.out.println("Position The Ship: enter row:");
			int x5= IO.readInt();
			System.out.println("enter column:");
			int y5= IO.readInt();
			
				System.out.println("choose(1-2)    1.Horizontal    2.Vertical");
				int choice5 = IO.readInt();
				boardA[x5][y5] = 'P';

					if(choice5 == 1){
						boardA[x5][y5+1]= 'P';
						
					}else if (choice5 == 2){
						
						boardA[x5+1][y5]= 'P';
					}			
		
	
			
		printBoard();
			
	}
	public boolean lost(){
		int hits=0;
		for(int i= 0; i<boardA.length; i++){
			for(int j= 0; j<boardA[i].length; j++){
				if(boardA[i][j] =='H')
					hits++;
			}}
		if(hits == 17){
			//System.out.println("Player has won!!");
		return true;
		}else{
		return false;
			}
		}
		
	
	public void printBoard(){
		
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
	public static void initBoard(char[][] board){
		 for (int i=0;i<board.length;i++){
			 for(int j=0;j<board[i].length;j++){
				 board[i][j]='~';
		 }
	 }	 
}
}