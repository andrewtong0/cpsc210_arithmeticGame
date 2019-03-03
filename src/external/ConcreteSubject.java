package external;

public class ConcreteSubject extends Subject {
    public ConcreteSubject(){
        state = false;
    }

    public void getState(){
        System.out.println("Current subject state:: " + state);
    }
}
