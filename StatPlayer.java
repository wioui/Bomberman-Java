
/*import edu.princeton.cs.introcs.StdDraw;*/

public class StatPlayer {



    private double time ;
    private int playerSpeed1 = 8;
    private int playerSpeed2 = 8;
    private boolean playerKick;
    private boolean playerShield;
    private boolean playerCross;
    private int range;


    


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
                    this.playerCross = Main.listPerso.get(0).isCrossWall();
                    this.playerKick = Main.listPerso.get(0).isCanPushBomb();
                    this.playerShield = Main.listPerso.get(0).isBouclier();
                    this.range = Main.listPerso.get(0).getRange();


                    StdDraw.picture(-1.5,-1.4,returnHeadPlayer(couleur,0));
                    numberToImage(life,"normal",-0.4f,-3.8f);
                    numberToImage(numberBomb,"normal", 2.5f, -3.8f);
                    numberToImage(this.playerSpeed1,"normal", 5.4f, -3.8f);
                    numberToImage(this.range,"normal", 8.1f, -3.8f);
                    if (playerKick) {
                        StdDraw.picture(1.4, -1.7, "menu-in-game/super-bonus/football.png");
                    }
                    if (playerCross) {
                        StdDraw.picture(2.9, -1.7, "menu-in-game/super-bonus/crosswall.png");
                    }
                    if (playerShield) {
                        StdDraw.picture(4.4, -1.7, "menu-in-game/super-bonus/bouclier.png");
                    }

                }
                else if (i == 1) {
                    this.playerCross = Main.listPerso.get(1).isCrossWall();
                    this.playerKick = Main.listPerso.get(1).isCanPushBomb();
                    this.playerShield = Main.listPerso.get(1).isBouclier();
                    this.range = Main.listPerso.get(1).getRange();

                    StdDraw.picture(19.5,-1.4,returnHeadPlayer(couleur,1));
                    numberToImage(life,"normal",11.5f,-3.8f);
                    numberToImage(numberBomb,"normal", 14.5f, -3.8f);
                    numberToImage(this.playerSpeed2,"normal", 17.1f, -3.8f);
                    numberToImage(this.range,"normal", 20f, -3.8f);
                    if (playerKick) {
                        StdDraw.picture(13.5, -1.7, "menu-in-game/super-bonus/football.png");
                    }
                    if (playerCross) {
                        StdDraw.picture(15.1, -1.7, "menu-in-game/super-bonus/crosswall.png");
                    }
                    if (playerShield) {
                        StdDraw.picture(16.6, -1.7, "menu-in-game/super-bonus/bouclier.png");
                    }
                }
            }

        }
    }

    public void setSpeed (int plus,int id) {
        if (plus == 1) {
            if (id == 0) {
                playerSpeed1 += 1;
            } else if (id == 1) {
                playerSpeed2 += 1;
            }
        }
        else  {
            if (id == 0) {
                playerSpeed1 -= 1;
            } else if (id == 1) {
                playerSpeed2 -= 1;
            }
        }
    }
    /*public int getSpeed(int id) {
        if (id == 0) {
            return playerSpeed1;
        }
        else {
            return playerSpeed2;
        }
    }*/

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


}


