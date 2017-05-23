

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by tristanmenager on 06/04/2017.
 */
public class Bombe extends Personnage {
    private double posBombX ;
    private double posBombY ;
    private int posBombBlocX;
    private int posBombBlocY ;

    private double dropTime ;


    private int bombeID;
    public int bombeRange ;
    private boolean escape;
    private boolean explosion;

    //DEPLACEMENT
    boolean move = false;
    int direction;


    // ANIMATION
    private double animationTime;
    private boolean beginAnimation;
    private LinkedList<Integer> listRangePosExplosionX = new LinkedList<>();
    private LinkedList<Integer> listRangePosExplosionY = new LinkedList<>();
    public  List<Integer[]> listCoordExplosion = new LinkedList<>();
    private Animation animation = new Animation();
    private Integer middleCoord[] = new Integer[2];





    public Bombe(double posBombX, double posBombY, double dropTime, int bombeRange) {
        this.posBombX = posBombX*SIZE_BLOC+SIZE_BLOC/2;
        this.posBombY = posBombY*SIZE_BLOC+SIZE_BLOC/2;
//        this.posBombBlocX = (int) posBombX / (int) SIZE_BLOC;
//        this.posBombBlocY = (int) posBombY / (int) SIZE_BLOC;
        this.dropTime = dropTime;
        this.bombeRange = bombeRange;
        this.escape = true;
        this.beginAnimation = false;
    }








    //TODO animation bombe trop gouremande => supprimer les element de la liste en trop

    public void bombExplosion(Labyrinthe laby, Personnage player) {

        /*bombMove(player);*/


//    	StdDraw.setPenColor(Color.red);
//    	StdDraw.circle(posBombX, posBombY, 15);

    	if(player.canPushBomb) {
            bonusPushBomb(player,laby);
        }

        this.posBombBlocX = this.getPosBombBlocX();
        this.posBombBlocY = this.getPosBombBlocY();
        animation.drawSpriteBombe(this.posBombX, this.posBombY, this);
//    	



        if (this.posBombBlocY == player.getBlocY() && this.posBombBlocX == player.getBlocX()) {
            this.escape = true;
        }
        else {
            this.escape = false;
        }

        if (this.dropTime+player.getBombDuration() == System.currentTimeMillis()/1000 || this.explosion) {


            this.animationTime = System.currentTimeMillis()+1500;
            // explosion en croix au bout de 3 seconde
            boolean propaUp = true;
            boolean propaDown = true;
            boolean propaLeft = true;
            boolean propaRight = true;
            hitOnBomb(player);
            for (int range = 1; range <= this.bombeRange; range ++) {

                if (laby.getMap()[this.posBombBlocX][this.posBombBlocY] !=1 ) {
                    laby.setMap(this.posBombBlocX, this.posBombBlocY, 0);
                    addPosToList(this.posBombBlocX, this.posBombBlocY);
                }


                if ((this.posBombBlocY+range) < 17) {

                    if ((laby.getMap()[this.posBombBlocX][this.posBombBlocY + range] == 1)) {
                        propaUp = false;

                    }

                    else if ((laby.getMap()[this.posBombBlocX][this.posBombBlocY + range] == 2 && propaUp)) {

                        addPosToList(this.posBombBlocX, this.posBombBlocY + range);
                        laby.setMap(this.posBombBlocX, this.posBombBlocY + range, 0);
                        player.getBonus().showBonus(laby, this.posBombBlocX,this.posBombBlocY+range);
                        if (!player.crossWall) {
                            propaUp = false;
                        }
                    }
                    else if  (laby.getMap()[this.posBombBlocX][this.posBombBlocY + range] == 3 && propaUp) {
                        propaUp = false;

                    }
                    if ((laby.getMap()[this.posBombBlocX][this.posBombBlocY + range] == 0  && propaUp)) {
                        addPosToList(this.posBombBlocX, this.posBombBlocY + range);
                    }

                    hitPlayer(player, this.posBombBlocX,this.posBombBlocY+range, propaUp);
                }




                if (this.posBombBlocY-range >= 0){
                    if ((laby.getMap()[this.posBombBlocX][this.posBombBlocY - range] == 1)) {
                        propaDown = false;
                    }
                    else if ((laby.getMap()[this.posBombBlocX][this.posBombBlocY - range] == 2 && propaDown)) {
                        addPosToList(this.posBombBlocX, this.posBombBlocY - range);
                        laby.setMap(this.posBombBlocX, this.posBombBlocY - range, 0);
                        player.getBonus().showBonus(laby, this.posBombBlocX,this.posBombBlocY-range);
                        if (!player.crossWall) {
                            propaDown = false;
                        }
                    }
                    else if (laby.getMap()[this.posBombBlocX][this.posBombBlocY - range] == 3 && propaDown) {
                        chainExplosion(this.posBombBlocX,this.posBombBlocY-range);
                        propaDown = false;
                    }
                    if ((laby.getMap()[this.posBombBlocX][this.posBombBlocY - range] == 0  && propaDown)) {
                        addPosToList(this.posBombBlocX, this.posBombBlocY - range);
                    }
                    hitPlayer(player,this.posBombBlocX,this.posBombBlocY-range,propaDown);
                }

                if (this.posBombBlocX-range >= 0){
                    if ((laby.getMap()[this.posBombBlocX-range][this.posBombBlocY] == 1)) {
                        propaLeft = false;
                    }
                    else if ((laby.getMap()[this.posBombBlocX-range][this.posBombBlocY ] == 2 && propaLeft)) {
                        addPosToList(this.posBombBlocX -range, this.posBombBlocY);
                        laby.setMap(this.posBombBlocX-range, this.posBombBlocY, 0);
                        player.getBonus().showBonus(laby, this.posBombBlocX-range,this.posBombBlocY);
                        if (!player.crossWall) {
                            propaLeft = false;
                        }
                    }
                    else if (laby.getMap()[this.posBombBlocX - range][this.posBombBlocY] == 3 && propaLeft) {
                        chainExplosion(this.posBombBlocX - range,this.posBombBlocY);
                        propaLeft = false;
                    }
                    if ((laby.getMap()[this.posBombBlocX-range][this.posBombBlocY] == 0  && propaLeft)) {
                        addPosToList(this.posBombBlocX -range, this.posBombBlocY);
                    }
                    hitPlayer(player,this.posBombBlocX -range,this.posBombBlocY, propaLeft);
                }

                if (this.posBombBlocX+range < 21){
                    if ((laby.getMap()[this.posBombBlocX+range][this.posBombBlocY] == 1)) {
                        propaRight = false;
                    }
                    else if ((laby.getMap()[this.posBombBlocX+range][this.posBombBlocY ] == 2 && (propaRight))) {
                        addPosToList(this.posBombBlocX + range, this.posBombBlocY);
                        laby.setMap(this.posBombBlocX+range, this.posBombBlocY, 0);
                        player.getBonus().showBonus(laby, this.posBombBlocX+range,this.posBombBlocY);
                        if (!player.crossWall) {
                            propaRight = false;
                        }
                    }
                    else if (laby.getMap()[this.posBombBlocX + range][this.posBombBlocY] == 3 && propaRight) {
                        chainExplosion(this.posBombBlocX + range,this.posBombBlocY);
                        propaRight = false;
                    }
                    if ((laby.getMap()[this.posBombBlocX + range][this.posBombBlocY] == 0  && propaRight)) {
                        addPosToList(this.posBombBlocX + range, this.posBombBlocY);
                    }
                    hitPlayer(player,this.posBombBlocX +range,this.posBombBlocY, propaRight);
                }

            }
            /*showArray(listCoordExplosion);*/
            Animation bombeAnimation = new Animation(this, this.bombeID);
            Main.listAnimationBomb.add(this.bombeID,bombeAnimation);


            player.removeElementFromListBomb(this.bombeID);
        }



    }


    public void bonusPushBomb(Personnage player, Labyrinthe laby) {
    	if (this.direction == 1) {
    	    if (isObstacle(this.posBombX,this.posBombY+2,laby)) {
    	        /*this.direction = 3;*/
    	        this.posBombY+=0;

            }
            else {
                this.posBombY+=1;

            }
        }
        else if (this.direction == 3) {
            if (isObstacle(posBombX,posBombY-2,laby)) {
                /*this.direction = 1;*/
                this.posBombY-=0;
            }
            else {
                this.posBombY-=1;
            }


        }
        else if (direction == 2) {
            if (isObstacle(posBombX+2,posBombY,laby)) {
                /*this.direction = 4;*/
                this.posBombX += 0;
            }
            else {
                this.posBombX += 1;

            }


        }

        else if (direction == 4) {
            if (isObstacle(posBombX-2,posBombY,laby)) {
                /*this.direction = 2;*/
                this.posBombX -= 0;
            }
            else {
                this.posBombX -= 1;

            }


        }


    }
//    public void pushBomb() {
//    	this.posBombX += 1;
//    	
//    }


    public void chainExplosion(int blocX, int blocY) {
        // on parcours tout les personnages
        for (int i = 0; i < listPlayer.size(); i++) {
            // on parcours toutes les bombes des personnage
            for (int bomb = 0; bomb < listPlayer.get(i).listBomb.size(); bomb++) {
                if (listPlayer.get(i).listBomb.get(bomb) != null) {
                    // si la range atteint une case ou il y'a une bombe alors on met explosion a true
                    if (blocX == listPlayer.get(i).listBomb.get(bomb).getPosBombBlocX() && blocY == listPlayer.get(i).listBomb.get(bomb).getPosBombBlocY()) {
                        listPlayer.get(i).listBomb.get(bomb).setExplosion(true);
                    }
                }
            }
        }
    }
    public void hitPlayer(Personnage player ,int blocX, int blocY, boolean propa) {
        if (propa) {
            for (int i = 0; i < listPlayer.size(); i++) {
                if (listPlayer.get(i).getBlocX() == blocX && listPlayer.get(i).getBlocY() == blocY) {
                    listPlayer.get(i).setNbrLife(listPlayer.get(i).getNbrLife() - 1);
                    player.repopPosition(listPlayer.get(i));
                }
            }
        }
    }
    public void hitOnBomb(Personnage player) {
        for (int i = 0; i < listPlayer.size(); i++) {
            if (this.getPosBombBlocX() == listPlayer.get(i).getBlocX() && this.getPosBombBlocY() == listPlayer.get(i).getBlocY()) {
                listPlayer.get(i).setNbrLife(listPlayer.get(i).getNbrLife() - 1);
                player.repopPosition(listPlayer.get(i));

            }
        }

    }

    // verifie que les coordoonné ne sont pas déja entré
    public void addPosToList(int blocX, int blocY) {
        Integer arrayPos [] = new Integer[2];
        arrayPos[0] = blocX;
        arrayPos[1] = blocY;
        boolean addToList = true;

        if (this.listCoordExplosion.isEmpty()) {
            this.listCoordExplosion.add(arrayPos);
        }
        else {
            for (int item = 0; item < this.listCoordExplosion.size(); item++) {
                int inListBlocX = this.listCoordExplosion.get(item)[0];
                int inListBlocY = this.listCoordExplosion.get(item)[1];
                if (blocX == inListBlocX && blocY == inListBlocY) {
                    addToList = false;
                }
            }
            if (addToList) {
                this.listCoordExplosion.add(arrayPos);
            }
        }
    }
    public boolean canCrossBonus(int blocX, int blocY ,boolean direction) {
        for (int bonus = 20; bonus < 30; bonus++) {
            if (laby.getMap()[blocX][blocY] != bonus  && direction) {
                return false;
            }
        }
        return true;
    }

    public void showArray(List<Integer[]> listCoord) {
        for (int item = 0; item < listCoord.size(); item++) {
            System.out.println("X : " + listCoord.get(item)[0]);
            System.out.println("Y : "+ listCoord.get(item)[1]);
        }
        System.out.println("FIN ===============");
    }

    public Integer[] getMiddleCoord() {
        middleCoord[0] = this.posBombBlocX;
        middleCoord[1] = this.posBombBlocY;
        return middleCoord ;
    }



    public List<Integer[]> getListCoordExplosion() {
        return listCoordExplosion;
    }

    public void setExplosion(boolean explosion) {
        this.explosion = explosion;
    }





    public double getDropTime() {
        return dropTime;
    }


    public void setDropTime(double dropTime) {
        this.dropTime = dropTime;
    }


    public double getAnimationTime() {
        return animationTime;
    }

    public LinkedList<Integer> getListRangePosExplosionX() {
        return listRangePosExplosionX;
    }

    public LinkedList<Integer> getListRangePosExplosionY() {
        return listRangePosExplosionY;
    }

    public boolean isMove() {
        return move;
    }

    public void setMove(boolean move) {
        this.move = move;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getPosBombBlocX() {
        return (int) posBombX / (int) SIZE_BLOC;
    }

    public int getPosBombBlocY() {
        return (int) posBombY / (int) SIZE_BLOC;
    }

    public double getPosBombX() {
        return posBombX;
    }

    public double getPosBombY() {
        return posBombY;
    }

    public void setPosBombX(double posBombX) {
        this.posBombX = posBombX;
    }

    public void setPosBombY(double posBombY) {
        this.posBombY = posBombY;
    }

    public void setBombeID(int bombeID) {
        this.bombeID = bombeID;
    }

    public void putBomb(Labyrinthe laby){
        laby.setMap(this.posBombBlocX,this.posBombBlocY,3);
    }

    public boolean isEscape() {
        return escape;
    }




}
