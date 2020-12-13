package sample.MementoPattern;

import sample.buildings.Building;

public class Memento {

    private Building building;

    public Memento(Building buildingSave) {
        building = buildingSave;
    }

    public Building getSavedBuilding(){
        return building;
    }



}
