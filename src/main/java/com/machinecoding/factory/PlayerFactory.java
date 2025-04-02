package com.machinecoding.factory;

import com.machinecoding.models.Player;

public class PlayerFactory {
    public static Player createPlayer(String name){
        return new Player(name);
    }
}
