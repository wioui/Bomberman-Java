import java.awt.*;

import javax.xml.transform.ErrorListener;

/**
 * Created by tristanmenager on 05/04/2017.
 */
public class Labyrinthe extends Main {


    private double posX = (WIN_WIDTH/SIZE_BLOC)/2;
    private double posY = (WIN_WIDTH/SIZE_BLOC)/2;
    private int nombre;



//TODO refaire la map pour avoir map[x][y] au lieu de refaire getMap()
    protected int map[][] =
            {{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
             {9,0,0,0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,9},
             {9,0,1,0,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,9},
             {9,0,0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,9},
             {9,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,9},
             {9,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,9},
             {9,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,9},
             {9,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,9},
             {9,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,9},
             {9,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,9},
             {9,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,9},
             {9,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,9},
             {9,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,9},
             {9,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0,0,9},
             {9,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,0,1,0,9},
             {9,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0,0,0,9},
             {9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9}};


  

    public void setMap(int X,int Y, int set) {
        this.map[Y][X] = set;
    }
    
    

    // absolument changer cette merde (plein de calcul pour rien)
    public int[][] getMap() {
        int[][] newMap = new int[21][17];
        for (int x = 0; x < 21; x++) {
            for (int y = 0; y < 17; y++) {
                newMap[x][y] = map[y][x];
            }
        }
        return newMap;
    }

    public void dessineLaby() {
    	
    	String mapName = "map1";
    	if (animation ) {
            StdDraw.picture(WIN_WIDTH / 2 - 90, (SIZE_BLOC * 17) / 2, "ressources/map/" + mapName + "/map.png");
        }
    	
        for (int x = 0; x < 21; x++) {
            for (int y = 0; y < 17; y++) {
//
            	
                if (map[y][x] == 1) {
                	StdDraw.picture(x*SIZE_BLOC+(SIZE_BLOC/2), (y*SIZE_BLOC+(SIZE_BLOC/2)), "ressources/map/"+mapName+"/obstacle1.png");
                }
               
                else if (map[y][x] == 2) {
                	StdDraw.picture(x*SIZE_BLOC+(SIZE_BLOC/2), (y*SIZE_BLOC+(SIZE_BLOC/2)), "ressources/map/"+mapName+"/obstacle2.png");
                }

                else if (map[y][x] == 10) {
                    StdDraw.setPenColor(Color.black);
                    StdDraw.filledCircle(x*SIZE_BLOC+(SIZE_BLOC/2),(y*SIZE_BLOC+(SIZE_BLOC/2)),SIZE_PLAYER/2);
                }
                else if (map[y][x] == 21 ) {
                    StdDraw.setPenColor(Color.blue);
                    StdDraw.filledCircle(x*SIZE_BLOC+(SIZE_BLOC/2),(y*SIZE_BLOC+(SIZE_BLOC/2)),SIZE_PLAYER/2);
                }
                else if (map[y][x] == 22 ) {
                	StdDraw.picture(x*SIZE_BLOC+(SIZE_BLOC/2), (y*SIZE_BLOC+(SIZE_BLOC/2)), "ressources/bonus/flamme-jaune.png");
                }
                else if (map[y][x] == 23 ) {
                	StdDraw.picture(x*SIZE_BLOC+(SIZE_BLOC/2), (y*SIZE_BLOC+(SIZE_BLOC/2)), "ressources/bonus/main.png");
                }
                else if (map[y][x] == 24 ) {
                	StdDraw.picture(x*SIZE_BLOC+(SIZE_BLOC/2), (y*SIZE_BLOC+(SIZE_BLOC/2)), "ressources/bonus/bombe10.png");
                }
                else if (map[y][x] == 25 ) {
                	StdDraw.picture(x*SIZE_BLOC+(SIZE_BLOC/2), (y*SIZE_BLOC+(SIZE_BLOC/2)), "ressources/bonus/vie.png");
                }
                else if (map[y][x] == 26 ) {
                	StdDraw.picture(x*SIZE_BLOC+(SIZE_BLOC/2), (y*SIZE_BLOC+(SIZE_BLOC/2)), "ressources/bonus/speed-up.png");
                }
//                else if (map[y][x] == 27 ) {
//                    StdDraw.setPenColor(Color.CYAN);
//                    StdDraw.filledCircle(x*SIZE_BLOC+(SIZE_BLOC/2),(y*SIZE_BLOC+(SIZE_BLOC/2)),SIZE_PLAYER/2);
//                }
                else if (map[y][x] == 28) {
                	StdDraw.picture(x*SIZE_BLOC+(SIZE_BLOC/2), (y*SIZE_BLOC+(SIZE_BLOC/2)), "ressources/bonus/bombe-plus.png");
                }
                else if (map[y][x] == 29) {
                    StdDraw.picture(x*SIZE_BLOC+(SIZE_BLOC/2), (y*SIZE_BLOC+(SIZE_BLOC/2)), "ressources/bonus/shoot.png");
                }

                

            }
        }
    }
}
