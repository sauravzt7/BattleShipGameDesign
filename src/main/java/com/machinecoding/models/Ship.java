package com.machinecoding.models;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    private final String id;
    private final int size;
    private final List<Coordinate> occupiedCoordinates;

    public Ship(String id, int size, int startX, int startY){
        this.id = id;
        this.size = size;
        this.occupiedCoordinates = new ArrayList<>();
        for(int i = 0; i < +size; i++){
            for(int j = 0; j < size; j++){
                occupiedCoordinates.add(new Coordinate(startX + i, startY + j));
            }
        }
    }

    public String getId() {
        return id;
    }

    public int getSize() {
        return size;
    }

    public List<Coordinate> getOccupiedCoordinates() {
        return occupiedCoordinates;
    }

    public boolean occupiesCoordinate(Coordinate c){
        return occupiedCoordinates.contains(c);
    }
}
