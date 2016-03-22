package ms4;

public class EaAIPlayer_kaf206 implements Player{
	
	private char [][] boardA= new char [10][10]; 
	private char [][] boardB = new char [10][10];
	 private Coordinate c2 ; 
	 public EaAIPlayer_kaf206(){
		 initBoard(boardA);
		 initBoard(boardB);
	 }
	
	
	public char fireUpon(Coordinate x){
		Coordinate c1 = x;
		if(boardA[c1.x][c1.y] == 'A'){
			
			System.out.println("OUTCH!!!!!you hit my Aircraft Carrier ");
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
		
			System.out.println("OUTCH!!!!!you hit my potrol boat ");
			return 'P';
	
		}else{
		
			boardA[c1.x][c1.y] = 'M';
			System.out.println("You Missed Dude!!");
			return 'M';	
			
		}
	}
	
public Coordinate fire(){
		
		int coordX = (int)(Math.random()*10);
		int coordY = (int)(Math.random()*10);
		Coordinate c1 = new Coordinate(coordX, coordY);
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
		public static void initBoard(char[][] board){
			 for (int i=0;i<board.length;i++){
				 for(int j=0;j<board[i].length;j++){
					 board[i][j]='~';
			 }
		 }	 
	}
		
		public void placeShips(){
			//placing an Aircraft Carrier size 5.
			int coordXA = (int)(Math.random()*5);
			int coordYA = (int)(Math.random()*5);
			int choice = (int)(Math.random()*2+1);
			if(choice == 1){
			do{
			
				 coordXA = (int)(Math.random()*5);
				 coordYA = (int)(Math.random()*5);
			
			//choice =1 is horizontal, choice = 2 is vertical.
			
			}while(boardA[coordXA][coordYA] != '~' || boardA[coordXA][coordYA+1] !='~' || boardA[coordXA][coordYA+2] !='~' || boardA[coordXA][coordYA+3] !='~' || boardA[coordXA][coordYA+4] !='~' );
			
				boardA[coordXA][coordYA] = 'A';
				boardA[coordXA][coordYA+1] = 'A';
				boardA[coordXA][coordYA+2] = 'A';
				boardA[coordXA][coordYA+3] = 'A';
				boardA[coordXA][coordYA+4] = 'A';
				
			}else if(choice == 2){
				do{
					
					 coordXA = (int)(Math.random()*5);
					 coordYA = (int)(Math.random()*5);
				
				//choice =1 is horizontal, choice = 2 is vertical.
				
				}while(boardA[coordXA][coordYA] != '~' || boardA[coordXA+1][coordYA] !='~' || boardA[coordXA+2][coordYA] !='~' || boardA[coordXA+3][coordYA] !='~' || boardA[coordXA+4][coordYA] !='~' );
				
				
				boardA[coordXA][coordYA] = 'A';
				boardA[coordXA+1][coordYA] = 'A';
				boardA[coordXA+2][coordYA] = 'A';
				boardA[coordXA+3][coordYA] = 'A';
				boardA[coordXA+4][coordYA] = 'A';
			
			}
			//placing a battleship size 4.
			 int coordXB = (int)(Math.random()*6);
			 int coordYB = (int)(Math.random()*6);
			 int choice2 = (int)(Math.random()*2+1);
			 if(choice2 == 1){
				 do{
						
					 coordXB = (int)(Math.random()*6);
					 coordYB = (int)(Math.random()*6);
				
				//choice =1 is horizontal, choice = 2 is vertical.
				
				}while(boardA[coordXB][coordYB] != '~' || boardA[coordXB][coordYB+1] !='~' || boardA[coordXB][coordYB+2] !='~' || boardA[coordXB][coordYB+3] !='~');
				
				 boardA[coordXB][coordYB] = 'B';
				 boardA[coordXB][coordYB+1] = 'B';
				 boardA[coordXB][coordYB+2] = 'B';
				 boardA[coordXB][coordYB+3] = 'B';
			 
			 }else if(choice2 == 2 ){
				 do{
						
					 coordXB = (int)(Math.random()*6);
					 coordYB = (int)(Math.random()*6);
				
				//choice =1 is horizontal, choice = 2 is vertical.
				
				}while(boardA[coordXB][coordYB] != '~' || boardA[coordXB+1][coordYB] !='~' || boardA[coordXB+2][coordYB] !='~' || boardA[coordXB+3][coordYB] !='~' );
				
				 boardA[coordXB][coordYB] = 'B';
				 boardA[coordXB+1][coordYB] = 'B';
				 boardA[coordXB+2][coordYB] = 'B';
				 boardA[coordXB+3][coordYB] = 'B';
				 
			 }
			 //placing a Submarine size 3 
			 int coordXS = (int)(Math.random()*6);
			 int coordYS = (int)(Math.random()*6);
			 int choice3 = (int)(Math.random()*2+1);
			 if(choice3 == 1){
				 do{
						
					 coordXS = (int)(Math.random()*6);
					 coordYS = (int)(Math.random()*6);
				
				//choice =1 is horizontal, choice = 2 is vertical.
				
				}while(boardA[coordXS][coordYS] != '~' || boardA[coordXS][coordYS+1] !='~' || boardA[coordXS][coordYS+2] !='~');
				
				 boardA[coordXS][coordYS] = 'S';
				 boardA[coordXS][coordYS+1] = 'S';
				 boardA[coordXS][coordYS+2] = 'S';
				 
			 
			 }else if(choice3 == 2 ){
				 do{
						
					 coordXS = (int)(Math.random()*6);
					 coordYS = (int)(Math.random()*6);
				
				//choice =1 is horizontal, choice = 2 is vertical.
				
				}while(boardA[coordXS][coordYS] != '~' || boardA[coordXS+1][coordYS] !='~' || boardA[coordXS+2][coordYS] !='~');
				
				 boardA[coordXS][coordYS] = 'S';
				 boardA[coordXS+1][coordYS] = 'S';
				 boardA[coordXS+2][coordYS] = 'S';
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
		//placing a patrol boat size 2.
			 int coordXP = (int)(Math.random()*7);
			 int coordYP = (int)(Math.random()*7);
			 int choice5 = (int)(Math.random()*2+1);
			 if(choice5 == 1){
				 do{
						
					 coordXP = (int)(Math.random()*7);
					 coordYP = (int)(Math.random()*7);
				
				//choice =1 is horizontal, choice = 2 is vertical.
				
				}while(boardA[coordXP][coordYP] != '~' || boardA[coordXP][coordYP+1] !='~' );
				
				 boardA[coordXP][coordYP] = 'P';
				 boardA[coordXP][coordYP+1] = 'P';
				
				 
			 
			 }else if(choice5 == 2 ){
				 do{
						
					 coordXP = (int)(Math.random()*7);
					 coordYP = (int)(Math.random()*7);
				
				//choice =1 is horizontal, choice = 2 is vertical.
				
				}while(boardA[coordXP][coordYP] != '~' || boardA[coordXP+1][coordYP] !='~' );
				
				 boardA[coordXP][coordYP] = 'P';
				 boardA[coordXP+1][coordYP] = 'P';
			
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