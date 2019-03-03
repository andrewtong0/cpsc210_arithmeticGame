package external;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    Boolean state;

    List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer o){
        observers.add(o);
    }

    public void removeObserver(Observer o){
        observers.remove(o);
    }

    public void updateObservers(){
        for (Observer o : observers){
            o.update();
        }
    }
}