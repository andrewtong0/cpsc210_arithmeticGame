package external;

public class ConcreteObserver extends Observer {
    @Override
    public void update() {
        state = true;
    }

    public void getState(){
        if (state == false){
            System.out.println("State: False");
        }
        else if (state == true){
            System.out.println("State: True");
        }
    }
}
