package external;

public class Component {
    protected String name;

    public Component(String name){
        this.name = name;
    }

    public void print(){
        System.out.println(name);
    }
}
