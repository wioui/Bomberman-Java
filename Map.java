import edu.princeton.cs.introcs.StdDraw;

public class Map {

	private int Laby[][]=
		{{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,2,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
        {0,2,0,2,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
        {0,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
        {0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
        {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
        {0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
        {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
        {0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
        {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
        {0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
        {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
        {0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
        {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,0},
        {0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,2,0,2,0},
        {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
	
	
	 public int[][] getLaby() {
	        int[][] newMap = new int[21][17];
	        for (int x = 0; x < 21; x++) {
	            for (int y = 0; y < 17; y++) {
	                newMap[x][y] = Laby[y][x];
	            }
	        }
	        return newMap;
	    }


	public  void setLaby(int x, int y, int set) {
		this.Laby[y][x]=set;
	}


	public  void Affichage(){
		
		
		for(int i=0;i<21;i++){
			for(int j=0;j<17;j++){
				if(Laby[j][i]==0){
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.filledSquare(i+0.5, j+0.5 ,0.5);
				}
				else if(Laby[j][i]==1){
					StdDraw.setPenColor(StdDraw.ORANGE);
					StdDraw.filledSquare(i+0.5, j+0.5 ,0.5);
				}
				
				else if (Laby[j][i]==2) {
					StdDraw.setPenColor(StdDraw.GREEN);
					StdDraw.filledSquare(i+0.5, j+0.5 ,0.5);
				}
				else if (Laby[j][i]==3) {
					StdDraw.setPenColor(StdDraw.RED);
					StdDraw.filledCircle(i+0.5, j+0.5 ,0.3);
				}
				
				else if(Laby[j][i]==10){
					StdDraw.setPenColor(StdDraw.YELLOW);
					StdDraw.filledSquare(i+0.5, j+0.5 ,0.5);
				}
				else if(Laby[j][i]==11){
					StdDraw.setPenColor(StdDraw.CYAN);
					StdDraw.filledSquare(i+0.5, j+0.5 ,0.5);
				}
				else if(Laby[j][i]==12){
					StdDraw.setPenColor(StdDraw.MAGENTA);
					StdDraw.filledSquare(i+0.5, j+0.5 ,0.5);
				}
				else if(Laby[j][i]==13){
					StdDraw.setPenColor(StdDraw.GRAY);
					StdDraw.filledSquare(i+0.5, j+0.5 ,0.5);
				}
				else if(Laby[j][i]==14){
					StdDraw.setPenColor(StdDraw.PINK);
					StdDraw.filledSquare(i+0.5, j+0.5 ,0.5);
				}
				else if(Laby[j][i]==15){
					StdDraw.setPenColor(StdDraw.WHITE);
					StdDraw.filledSquare(i+0.5, j+0.5 ,0.5);
				}
				else if(Laby[j][i]==16){
					StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
					StdDraw.filledSquare(i+0.5, j+0.5 ,0.5);
				}
				else if(Laby[j][i]==17){
					StdDraw.setPenColor(StdDraw.BOOK_RED);
					StdDraw.filledSquare(i+0.5, j+0.5 ,0.5);
				}
				else if(Laby[j][i]==18){
					StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
					StdDraw.filledSquare(i+0.5, j+0.5 ,0.5);
				}
				
				
			}
		}
	}


	}	

