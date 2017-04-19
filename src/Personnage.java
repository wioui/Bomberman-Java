
import java.awt.*;
import java.awt.event.KeyEvent;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tristanmenager on 05/04/2017.
 */
public class Personnage extends Labyrinthe {

    protected static int nbrPlayer = 0;
    protected double initPosX;
    protected double initPosY;

    protected double posY;
    protected double posX;
    protected int playerID = 10;


    //CARACTERISTIQUE JOUEUR
    protected String name;
    protected Color couleur;
    protected int nbrLife;
    private double vitesse;
    protected int bombeRange;
    protected int nbrBomb;
    protected boolean crossWall ;
    protected boolean canPushBomb;
    protected String pushBombDirection;



    protected List<Bombe> listBomb = new LinkedList<>();
    protected int bombDuration = 4;

    //BONUS:
    private Bonus bonus = new Bonus(this);





    //COMMANDE:

    protected int UP_COM;
    protected int DOWN_COM;
    protected int RIGHT_COM;
    protected int LEFT_COM;
    protected int BOMB_COM;




    public int getBombDuration() {
        return bombDuration;
    }

    public void removeElementFromListBomb(int indice) {

       /* this.listBomb.remove(indice);
        for (int i = 0; i < listBomb.size(); i++) {
            int bombID = listBomb.get(i).getBombeID();
            listBomb.get(i).setBombeID(bombID-1);
        }*/
       // on remplace les bombes utilisé par null
        this.listBomb.set(indice,null);
    }
    public Personnage(String name) {
        if (nbrPlayer == 0) {
            this.initPosX = (SIZE_BLOC)+(SIZE_BLOC/2);
            this.initPosY = (SIZE_BLOC)+(SIZE_BLOC/2);
            this.posX = (SIZE_BLOC)+(SIZE_BLOC/2);
            this.posY = (SIZE_BLOC)+(SIZE_BLOC/2);
            this.name = name;
            this.playerID = 10;
            this.UP_COM = 90;
            this.DOWN_COM = 83;
            this.RIGHT_COM = 68;
            this.LEFT_COM = 81;
            this.BOMB_COM = 32;
            this.nbrLife = 3;
            this.nbrBomb = 1;
            this.bombeRange = 3;
            this.vitesse = 0.6;
            this.couleur = StdDraw.DARK_GRAY;
            this.crossWall = false;
            this.canPushBomb = true;
            nbrPlayer ++;


        }
        else if (nbrPlayer== 1) {
            this.initPosX = (19*SIZE_BLOC)+ (SIZE_BLOC/2);
            this.initPosY = (15*SIZE_BLOC)+ (SIZE_BLOC/2);
            this.posX = (19*SIZE_BLOC)+ (SIZE_BLOC/2);
            this.posY = (15*SIZE_BLOC)+ (SIZE_BLOC/2);
            this.name = name;
            this.playerID = 10;
            this.UP_COM = 73;
            this.DOWN_COM = 75;
            this.RIGHT_COM = 76;
            this.LEFT_COM = 74;
            this.BOMB_COM = 77;
            this.nbrLife = 3;
            this.nbrBomb = 1;
            this.bombeRange = 3;
            this.vitesse = 0.6;
            this.crossWall = false;
            this.couleur = StdDraw.GRAY;
            this.canPushBomb = false;
            nbrPlayer ++;
        }
    }
    public Personnage() {}

    public int getUP_COM() {
        return UP_COM;
    }

    public Bonus getBonus() {
        return bonus;
    }

    public double getVitesse() {
        return vitesse;
    }

    public void setVitesse(double vitesse) {
        this.vitesse = vitesse;
    }

    public int getBombeRange() {
        return bombeRange;
    }

    public void setBombeRange(int bombeRange) {
        this.bombeRange = bombeRange;
    }

    public int getNbrBomb() {
        return nbrBomb;
    }

    public void setNbrBomb(int nbrBomb) {
        this.nbrBomb = nbrBomb;
    }

    public boolean isCrossWall() {
        return crossWall;
    }

    public void setCrossWall(boolean crossWall) {
        this.crossWall = crossWall;
    }

    public void setNbrLife(int nbrLife) {
        this.nbrLife = nbrLife;
    }

    public int getNbrLife() {
        return nbrLife;
    }

    public static int getNbrPlayer() {
        return nbrPlayer;
    }

    public int getBlocX() {
        return (int) posX / (int) SIZE_BLOC;
    }

    public int getBlocY() {
        return (int) posY / (int) SIZE_BLOC;
    }



    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public void drawPerso(double posX, double posY) {
        StdDraw.setPenColor(this.couleur);
         // dessin du personnage
        StdDraw.filledCircle(posX, posY, SIZE_PLAYER / 2);

    }

    public boolean isObstacle(double posX, double posY,Labyrinthe laby) {

        // on prend en compte le décalage à cause du square
        Box joueur = new Box(posX - (SIZE_PLAYER / 2), posY - (SIZE_PLAYER / 2), SIZE_PLAYER, SIZE_PLAYER);
        for (int x = 0; x < 21; x++) {
            for (int y = 0; y < 17; y++) {
                if (laby.getMap()[x][y] == 1 || laby.getMap()[x][y] == 2 || laby.getMap()[x][y] == 9 ) {
                    Box obstacle = new Box((x) * SIZE_BLOC, (y) * SIZE_BLOC, SIZE_BLOC, SIZE_BLOC);
                    StdDraw.setPenColor(Color.yellow);
                    StdDraw.filledSquare(x * SIZE_BLOC + SIZE_BLOC / 2, y * SIZE_BLOC + SIZE_BLOC / 2, SIZE_BLOC / 2);
                    if (obstacle.collision(joueur)) {

                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean isObstacleBomb(double posX,double posY,Labyrinthe laby,String direction) {
        Box joueur = new Box(posX - (SIZE_PLAYER / 2), posY - (SIZE_PLAYER / 2), SIZE_PLAYER, SIZE_PLAYER);
        if (!listBomb.isEmpty()) {
            for (int bombe = 0; bombe < listBomb.size(); bombe++) {

                if (listBomb.get(bombe) != null) {
                        if (!listBomb.get(bombe).isEscape()) {
                            Box bomb = new Box(listBomb.get(bombe).getPosBombBlocX() * SIZE_BLOC+ SIZE_BLOC/3, listBomb.get(bombe).getPosBombBlocY() * SIZE_BLOC+SIZE_BLOC/3, SIZE_BOMB, SIZE_BOMB);
                        if (bomb.collision(joueur)) {
                            if (canPushBomb) {
                                listBomb.get(bombe).setDirection(direction);
                                listBomb.get(bombe).setMove(true);
                            }
                            // activation du bonus bombe
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }



    public void pushBomb(Personnage player,Bombe bomb) {
        bomb.bombMove(this);
        /*for (int bombe = 0; bombe < listBomb.size(); bombe++) {
            if (!listBomb.isEmpty()) {
                listBomb.
            }
        }*/
    }

    public boolean isChangingBloc(double posX, double posY) {
        if ( (int)posX/(int)SIZE_BLOC != this.getBlocX() || (int)posY/(int)SIZE_BLOC!= this.getBlocY()) {
            return true;
        }
        return false;
    }

    public void move(Labyrinthe laby) {
        if (StdDraw.isKeyPressed(DOWN_COM)) {
            if (isObstacle(posX, posY - 2, laby) || isObstacleBomb(posX, posY-SIZE_BLOC/2+5, laby,"down") ) {
                this.posY -=0;
            } else {
                this.posY -= vitesse;
            }
        }
        if (StdDraw.isKeyPressed(UP_COM)) {
            if (isObstacle(posX, posY + 2, laby) || isObstacleBomb(posX, posY+SIZE_BLOC/2-5, laby, "up")){
                this.posY += 0;
            } else {

                this.posY += vitesse;
            }
        }
        if (StdDraw.isKeyPressed(LEFT_COM)) {
            if (isObstacle(posX - 2, posY, laby) || isObstacleBomb(posX - SIZE_BLOC/2+5 , posY, laby, "left")) {
                this.posX += 0;
            } else {

                this.posX -= vitesse;
            }

        }
        if (StdDraw.isKeyPressed(RIGHT_COM)) {
            if (isObstacle(posX + 2, posY, laby) || isObstacleBomb(posX + SIZE_BLOC/2-5, posY, laby, "right")) {
                this.posX += 0;
            } else {

                this.posX += vitesse;
            }
        }
        this.bonus.takeBonus(this,laby,this.getBlocX(),this.getBlocY());

        /*setPlayerOnMap(laby);*/

    }


    public void setPlayerOnMap(Labyrinthe laby) {
        for (int x = 0; x < 21; x++) {
            for (int y = 0; y < 17; y++) {
                if (laby.getMap()[x][y] == 10) {
                    laby.setMap(x,y,0);
                }
            }
        }
        laby.setMap(this.getBlocX(),this.getBlocY(), 10);
    }

    public void repopPosition(Personnage player) {

        player.posX = player.initPosX;
        player.posY = player.initPosY;
    }

    public void dropBomb(Labyrinthe laby, double time) {
        // dans le cas ou on appuie sur space on pose une bombe et on met la l'objet bombe dans la liste
        if (StdDraw.isKeyPressed(BOMB_COM) ) {
            int compteurBomb = 0;
            if (!listBomb.isEmpty()) {
                for (int bomb = 0; bomb < listBomb.size(); bomb++) {
                    if (listBomb.get(bomb) != null) {
                        compteurBomb++;
                    }
                }
            }
            if (compteurBomb < this.nbrBomb) {
                if (!alreadyBombOnBloc()) {
                        Bombe bombe = new Bombe(this.posX, this.posY, time, this.bombeRange);
                        listBomb.add(bombe);


                        bombe.setBombeID(listBomb.size() - 1);
                        bombe.putBomb(laby);
                }
            }
        }

        // on parcours toute les bombes du tableau et on les fait explosés
        for (int bomb = 0; bomb < listBomb.size(); bomb++) {
            if (listBomb.get(bomb) != null)
                /*pushBomb(this,);*/


                listBomb.get(bomb).bombExplosion(laby,this);


        }
    }
   // verifie qu'il n'ya pas deja une bombe
    public boolean alreadyBombOnBloc() {
        for (int bomb = 0; bomb < listBomb.size(); bomb++) {
            if (listBomb.get(bomb) != null)
                if ((listBomb.get(bomb).getPosBombBlocX()== this.getBlocX())
                        && (listBomb.get(bomb).getPosBombBlocY()== this.getBlocY())) {
                    return true;
            }
        }
        return false;
    }


    //TODO fonctionne ne pas supprimer
    /*public void setPlayerOnMap(Labyrinthe laby) {
        for (int x = 0; x < 21; x++) {
            for (int y = 0; y < 17; y++) {
                if (laby.getMap()[x][y] == 10) {
                        laby.setMap(x,y,0);
                }
                if (laby.getMap()[x][y] == laby.getMap()[this.blocX][this.blocY]) {
                    laby.setMap(this.getBlocX(), this.getBlocY(), 10);
                }
            }
        }
    }*/
}


