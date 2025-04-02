package com.machinecoding.factory;

import com.machinecoding.services.IMissileService;
import com.machinecoding.services.MissileService;

public class ServiceFactory {

    public static IMissileService createMissileService() {
        return new MissileService();
    }
}
