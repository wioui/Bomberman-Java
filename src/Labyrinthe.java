import java.awt.*;

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


    /*                //gauche
    protected int map[][] =
              {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
               {1,0,0,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
               {1,0,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1},
               {1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1},
               {1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1},
               {1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1},
               {1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1},
               {1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1},
               {1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1},
   *//* bas  *//*  {1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1},         // haut
               {1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1},
               {1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1},
               {1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1},
               {1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1},
               {1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1},
               {1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1},
               {1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1},
               {1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1},
               {1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1},
               {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
               {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};


                        //droite
*/

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
        for (int x = 0; x < 21; x++) {
            for (int y = 0; y < 17; y++) {
                if (map[y][x] == 1 || map[y][x] == 9) {
                    // SIZE_BLOC/2 permet de décaler les obstacle vers la droite
                    StdDraw.setPenColor(49,122,174);
                    StdDraw.filledSquare(x*SIZE_BLOC+(SIZE_BLOC/2),(y*SIZE_BLOC+(SIZE_BLOC/2)),SIZE_BLOC/2);
                }
                else if  (map[y][x] == 2) {
                    StdDraw.setPenColor(236,150,73);
                    StdDraw.filledSquare(x*SIZE_BLOC+(SIZE_BLOC/2),(y*SIZE_BLOC+(SIZE_BLOC/2)),SIZE_BLOC/2);
                }
                else if (map[y][x] == 3 ) {
                    /*StdDraw.setPenColor(Color.red);
                    StdDraw.filledSquare(x*SIZE_BLOC+(SIZE_BLOC/2),(y*SIZE_BLOC+(SIZE_BLOC/2)),SIZE_BLOC/2);*/

                    StdDraw.setPenColor(StdDraw.RED);
                    StdDraw.filledCircle(x*SIZE_BLOC+(SIZE_BLOC/2),(y*SIZE_BLOC+(SIZE_BLOC/2)),SIZE_PLAYER/2);
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
                    StdDraw.setPenColor(Color.red);
                    StdDraw.filledCircle(x*SIZE_BLOC+(SIZE_BLOC/2),(y*SIZE_BLOC+(SIZE_BLOC/2)),SIZE_PLAYER/2);
                }
                else if (map[y][x] == 23 ) {
                    StdDraw.setPenColor(Color.green);
                    StdDraw.filledCircle(x*SIZE_BLOC+(SIZE_BLOC/2),(y*SIZE_BLOC+(SIZE_BLOC/2)),SIZE_PLAYER/2);
                }
                else if (map[y][x] == 24 ) {
                    StdDraw.setPenColor(Color.yellow);
                    StdDraw.filledCircle(x*SIZE_BLOC+(SIZE_BLOC/2),(y*SIZE_BLOC+(SIZE_BLOC/2)),SIZE_PLAYER/2);
                }
                else if (map[y][x] == 25 ) {
                    StdDraw.setPenColor(Color.blue);
                    StdDraw.filledCircle(x*SIZE_BLOC+(SIZE_BLOC/2),(y*SIZE_BLOC+(SIZE_BLOC/2)),SIZE_PLAYER/2);
                }
                else if (map[y][x] == 26 ) {
                    StdDraw.setPenColor(Color.black);
                    StdDraw.filledCircle(x*SIZE_BLOC+(SIZE_BLOC/2),(y*SIZE_BLOC+(SIZE_BLOC/2)),SIZE_PLAYER/2);
                }
                else if (map[y][x] == 27 ) {
                    StdDraw.setPenColor(Color.CYAN);
                    StdDraw.filledCircle(x*SIZE_BLOC+(SIZE_BLOC/2),(y*SIZE_BLOC+(SIZE_BLOC/2)),SIZE_PLAYER/2);
                }


            }
        }
    }
}
