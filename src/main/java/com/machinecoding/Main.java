package com.machinecoding;

import com.machinecoding.services.GameEngine;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine();

        // 1) Initialize an 8x8 battlefield
        gameEngine.initGame(8);

        // 2) Add ships
        gameEngine.addShip("SH1", 2, 1, 1, 5, 1);
        gameEngine.addShip("SH2", 2, 3, 3, 6, 4);

        // 3) Start game
        gameEngine.startGame();
    }
}