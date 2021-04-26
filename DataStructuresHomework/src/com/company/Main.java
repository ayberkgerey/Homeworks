package com.company;

public class Main {
    public static void main(String[] args){

        PlayGround game = new PlayGround();
        game.obstacles();
        game.setKey();

        while(game.isInside()){ game.movement(); }

        System.out.println("Game Over...\n");
        game.lastLogs();

    }
}
