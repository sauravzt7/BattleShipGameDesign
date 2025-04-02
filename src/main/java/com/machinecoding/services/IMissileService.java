package com.machinecoding.services;

import com.machinecoding.models.Player;

public interface IMissileService {
    void fireMissile(Player current, Player opponent, int battlefieldSize);
}
