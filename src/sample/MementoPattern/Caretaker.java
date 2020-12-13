package sample.MementoPattern;

import java.util.ArrayList;

public class Caretaker {
    ArrayList<Memento> buildings = new ArrayList<>();

    public void addMemento(Memento m) {
        buildings.add(m);
    }

    public Memento getMemento(int index) {
        return buildings.get(index);
    }

    public ArrayList<Memento> getMementos() {
        return buildings;
    }

}
