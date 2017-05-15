import edu.princeton.cs.introcs.StdDraw;

public class Map {

	private int laby[][]=
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
	
	
	private int copy[][]=
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
	
	
	public int[][] getCopy() {
        int[][] newMap = new int[21][17];
        for (int x = 0; x < 21; x++) {
            for (int y = 0; y < 17; y++) {
                newMap[x][y] = copy[y][x];
            }
        }
        return newMap;
    }


	public void setCopy(int[][] copy) {
		this.copy = copy;
	}


	public int[][] getLaby() {
	        int[][] newMap = new int[21][17];
	        for (int x = 0; x < 21; x++) {
	            for (int y = 0; y < 17; y++) {
	                newMap[x][y] = laby[y][x];
	            }
	        }
	        return newMap;
	    }


	public  void setLaby(int x, int y, int set) {
		this.laby[y][x]=set;
	}


	public  void Affichage(){
		
		
		for(int i=0;i<21;i++){
			for(int j=0;j<17;j++){
				if(laby[j][i]==0){
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.picture(i+0.5, j+0.5 ,"///C:/Users/wioui/Documents/Bomberman/src/Image/MetalWall.PNG");
				}
				else if(laby[j][i]==1){
					StdDraw.setPenColor(StdDraw.ORANGE);
					StdDraw.picture(i+0.5, j+0.5 ,"///C:/Users/wioui/Documents/Bomberman/src/Image/Bricks.jpg");
				}
				
				else if (laby[j][i]==2) {
					StdDraw.setPenColor(StdDraw.GREEN);
					StdDraw.picture(i+0.5, j+0.5 ,"///C:/Users/wioui/Documents/Bomberman/src/Image/Floor.PNG");
				}
				else if (laby[j][i]==3) {
					StdDraw.setPenColor(StdDraw.RED);
					StdDraw.picture(i+0.5, j+0.5 ,"///C:/Users/wioui/Documents/Bomberman/src/Image/Floor.PNG");
					StdDraw.picture(i+0.5, j+0.5 ,"///C:/Users/wioui/Documents/Bomberman/src/Image/Bomb.PNG");
								
				}
				else if (laby[j][i]==5) {
					StdDraw.setPenColor(StdDraw.GREEN);
					StdDraw.picture(i+0.5, j+0.5 ,"///C:/Users/wioui/Documents/Bomberman/src/Image/Floor.PNG");
				}
				
				else if(laby[j][i]==10){
					StdDraw.setPenColor(StdDraw.YELLOW);
					StdDraw.filledSquare(i+0.5, j+0.5 ,0.5);
				}
				else if(laby[j][i]==11){
					StdDraw.setPenColor(StdDraw.CYAN);
					StdDraw.filledSquare(i+0.5, j+0.5 ,0.5);
				}
				else if(laby[j][i]==12){
					StdDraw.setPenColor(StdDraw.MAGENTA);
					StdDraw.filledSquare(i+0.5, j+0.5 ,0.5);
				}
				else if(laby[j][i]==13){
					StdDraw.setPenColor(StdDraw.GRAY);
					StdDraw.filledSquare(i+0.5, j+0.5 ,0.5);
				}
				else if(laby[j][i]==14){
					StdDraw.setPenColor(StdDraw.PINK);
					StdDraw.filledSquare(i+0.5, j+0.5 ,0.5);
				}
				else if(laby[j][i]==15){
					StdDraw.setPenColor(StdDraw.WHITE);
					StdDraw.filledSquare(i+0.5, j+0.5 ,0.5);
				}
				else if(laby[j][i]==16){
					StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
					StdDraw.filledSquare(i+0.5, j+0.5 ,0.5);
				}
				else if(laby[j][i]==17){
					StdDraw.setPenColor(StdDraw.BOOK_RED);
					StdDraw.filledSquare(i+0.5, j+0.5 ,0.5);
				}
				else if(laby[j][i]==18){
					StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
					StdDraw.filledSquare(i+0.5, j+0.5 ,0.5);
				}
				
				
			}
		}
	}


	}	

