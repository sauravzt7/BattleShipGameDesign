package com.machinecoding.factory;

import com.machinecoding.models.BattleField;
import com.machinecoding.models.IBattleField;
import com.machinecoding.services.IMissileService;

public class BattleFieldFactory {

    public static IBattleField createBattleField(int size) {
        return new BattleField(size);
    }
}
