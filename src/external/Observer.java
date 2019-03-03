package external;

abstract class Observer {
    protected Boolean state;

    public Observer(){
        state = false;
    }

    abstract public void update();
}
