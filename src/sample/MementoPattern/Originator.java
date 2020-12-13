package sample.MementoPattern;

import sample.buildings.Building;
import sample.buildings.LoggersHut;
import sample.buildings.MiniLumbermill;
import sample.buildings.Quarry;

import java.util.ArrayList;

public class Originator {

    private Building building;

    public void set(Building newBuilding) {
        System.out.println("The latest building is: " + newBuilding.getClass());
        building = newBuilding;
    }

    public Memento storeInMemento() {
        System.out.println("Saving to Memento");
        return new Memento(building);
    }

    public Building restoreFromMemento(Memento memento) {
        building = memento.getSavedBuilding();
        System.out.println("Building restored from memento");
        return building;
    }

    public boolean areConditionsMet(ArrayList<Memento> builtBuildings) {
        return (quarryBuilt(builtBuildings) &&
                miniLumbermillBuilt(builtBuildings) &&
                loggersHutBuilt(builtBuildings));
    }


    private boolean quarryBuilt(ArrayList<Memento> builtBuildings) {
        for (Memento builtBuilding : builtBuildings) {
            if (builtBuilding.getSavedBuilding() instanceof Quarry) return true;
        }
        return false;
    }

    private boolean miniLumbermillBuilt(ArrayList<Memento> builtBuildings) {
        for (Memento builtBuilding : builtBuildings) {
            if (builtBuilding.getSavedBuilding() instanceof MiniLumbermill) return true;
        }
        return false;
    }

    private boolean loggersHutBuilt(ArrayList<Memento> builtBuildings) {
        for (Memento builtBuilding : builtBuildings) {
            if (builtBuilding.getSavedBuilding() instanceof LoggersHut) return true;
        }
        return false;
    }


}
