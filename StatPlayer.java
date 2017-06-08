import edu.princeton.cs.introcs.StdDraw;

/*import edu.princeton.cs.introcs.StdDraw;*/

public class StatPlayer {


    int speed = 1;
    double time ;


    public StatPlayer(double time) {
        this.time = time;
    }


    public void display() {


        int life, numberBomb, rangeBomb;
        String couleur;

        for (int i = 0; i < Main.listPerso.size(); i++) {
            if(Main.listPerso.get(i)!=null){
                life = Main.listPerso.get(i).getVie();
                /*numberBomb = Main.listPerso.get(i).getNbBomb();*/
                numberBomb =Main.listPerso.get(i).getNbBombInMoment();
                couleur = Main.listPerso.get(i).getCouleur();



                if (i == 0) {
                    StdDraw.picture(-1.5,-1.4,returnHeadPlayer(couleur,0));
                    numberToImage(life,"normal",-0.4f,-3.8f);
                    numberToImage(numberBomb,"normal", 2.5f, -3.8f);
                    numberToImage(this.speed,"normal", 5.4f, -3.8f);
                }
                else if (i == 1) {
                    StdDraw.picture(19.5,-1.4,returnHeadPlayer(couleur,1));
                    numberToImage(life,"normal",11.5f,-3.8f);
                    numberToImage(numberBomb,"normal", 14.5f, -3.8f);
                    numberToImage(this.speed,"normal", 17.1f, -3.8f);
                }
            }

        }
    }

    public String returnHeadPlayer(String couleur, int id) {
        String urlToHead = "";
        if (couleur.equals("black")) {
            urlToHead = "menu-in-game/head/"+id+"/black.png";
        }
        else if (couleur.equals("blue")){
            urlToHead = "menu-in-game/head/"+id+"/blue.png";
        }
        else if (couleur.equals("white")) {
            urlToHead = "menu-in-game/head/"+id+"/white.png";
        }
        else if (couleur.equals("green")) {
            urlToHead = "menu-in-game/head/"+id+"/green.png";
        }
        return urlToHead;
    }
    public void displayTime() {
        // debut timer
        double timeStart = this.time;
        // durée jeu
        double timeGame = 240;
        // temp restant en seconde
        double timeLeft = (timeStart+timeGame) - (System.currentTimeMillis() / 1000) ;

        int time = (int)timeLeft;
        if (time >=10) {
            numberToImage(time,"black",21 - 24 / 2,-0.6f);
        }
        else {
            numberToImage(time,"red",21 - 24 / 2,-0.6f);
        }


        //float timeConv = (float)timeLeft/60f;
       /* DecimalFormat df = new DecimalFormat("#.");
        String time = df.format(timeLeft);
        System.out.println(time);*/





        /*df.setRoundingMode(RoundingMode.DOWN);*/

        /*String time = df.format(timeConv);
        System.out.println(time);*/

        /*float timeFloat = Float.parseFloat(time);
        float floatNumber = (int)timeFloat - timeFloat;
        System.out.println(floatNumber);*/








    }



    // permet de transformer un int en array
    public void numberToImage(int numberToConvert, String color, float posX, float posY) {
        // split du nombre dans un tableau
        String[] numberToStrings = Integer.toString(numberToConvert).split("");
        String colorNumber = color;
        float decalage1 = 0.4f;
        float decalage2 = decalage1 + 0.4f;
        for (int number = 0; number < numberToStrings.length; number++) {
            if (numberToStrings[number].equals("0")) {
                if (number == 0) {
                    StdDraw.picture(posX, posY, "menu-in-game/numero/"+color+"/0.png");
                } else if (number == 1) {
                    StdDraw.picture(posX + decalage1, posY, "menu-in-game/numero/"+color+"/0.png");
                }
                else if (number == 2) {
                    StdDraw.picture(posX + decalage2, posY, "menu-in-game/numero/"+color+"/0.png");
                }
            }
            if (numberToStrings[number].equals("1")) {
                if (number == 0) {
                    StdDraw.picture(posX, posY, "menu-in-game/numero/"+color+"/1.png");
                } else if (number == 1) {
                    StdDraw.picture(posX + decalage1, posY, "menu-in-game/numero/"+color+"/1.png");
                }
                else if (number == 2) {
                    StdDraw.picture(posX + decalage2, posY, "menu-in-game/numero/"+color+"/1.png");
                }
            }
            if (numberToStrings[number].equals("2")) {
                if (number == 0) {
                    StdDraw.picture(posX, posY, "menu-in-game/numero/"+color+"/2.png");
                } else if (number == 1) {
                    StdDraw.picture(posX + decalage1, posY, "menu-in-game/numero/"+color+"/2.png");
                }
                else if (number == 2) {
                    StdDraw.picture(posX + decalage2, posY, "menu-in-game/numero/"+color+"/2.png");
                }
            }
            if (numberToStrings[number].equals("3")) {
                if (number == 0) {
                    StdDraw.picture(posX, posY, "menu-in-game/numero/"+color+"/3.png");
                } else if (number == 1) {
                    StdDraw.picture(posX + decalage1, posY, "menu-in-game/numero/"+color+"/3.png");
                }
                else if (number == 2) {
                    StdDraw.picture(posX + decalage2, posY, "menu-in-game/numero/"+color+"/3.png");
                }
            }
            if (numberToStrings[number].equals("4")) {
                if (number == 0) {
                    StdDraw.picture(posX, posY, "menu-in-game/numero/"+color+"/4.png");
                } else if (number == 1) {
                    StdDraw.picture(posX + decalage1, posY, "menu-in-game/numero/"+color+"/4.png");
                }
                else if (number == 2) {
                    StdDraw.picture(posX + decalage2, posY, "menu-in-game/numero/"+color+"/4.png");
                }
            }
            if (numberToStrings[number].equals("5")) {
                if (number == 0) {
                    StdDraw.picture(posX, posY, "menu-in-game/numero/"+color+"/5.png");
                } else if (number == 1) {
                    StdDraw.picture(posX + decalage1, posY, "menu-in-game/numero/"+color+"/5.png");
                }
                else if (number == 2) {
                    StdDraw.picture(posX + decalage2, posY, "menu-in-game/numero/"+color+"/5.png");
                }
            }
            if (numberToStrings[number].equals("6")) {
                if (number == 0) {
                    StdDraw.picture(posX, posY, "menu-in-game/numero/"+color+"/6.png");
                } else if (number == 1) {
                    StdDraw.picture(posX + decalage1, posY, "menu-in-game/numero/"+color+"/6.png");
                }
                else if (number == 2) {
                    StdDraw.picture(posX + decalage2, posY, "menu-in-game/numero/"+color+"/6.png");
                }
            }
            if (numberToStrings[number].equals("7")) {
                if (number == 0) {
                    StdDraw.picture(posX, posY, "menu-in-game/numero/"+color+"/7.png");
                } else if (number == 1) {
                    StdDraw.picture(posX + decalage1, posY, "menu-in-game/numero/"+color+"/7.png");
                }
                else if (number == 2) {
                    StdDraw.picture(posX + decalage2, posY, "menu-in-game/numero/"+color+"/7.png");
                }
            }
            if (numberToStrings[number].equals("8")) {
                if (number == 0) {
                    StdDraw.picture(posX, posY, "menu-in-game/numero/"+color+"/8.png");
                } else if (number == 1) {
                    StdDraw.picture(posX + decalage1, posY, "menu-in-game/numero/"+color+"/8.png");
                }
                else if (number == 2) {
                    StdDraw.picture(posX + decalage2, posY, "menu-in-game/numero/"+color+"/8.png");
                }
            }
            if (numberToStrings[number].equals("9")) {
                if (number == 0) {
                    StdDraw.picture(posX, posY, "menu-in-game/numero/"+color+"/9.png");
                } else if (number == 1) {
                    StdDraw.picture(posX + decalage1, posY, "menu-in-game/numero/"+color+"/9.png");
                }
                else if (number == 2) {
                    StdDraw.picture(posX + decalage2, posY, "menu-in-game/numero/"+color+"/9.png");
                }
            }
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}


