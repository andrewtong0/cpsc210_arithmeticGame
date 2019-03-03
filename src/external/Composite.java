package external;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component{
    List<Component> componentList = new ArrayList<>();

    public Composite(String name){
        super(name);
    }

    public void print(){
        System.out.println(name);
        getChildren();
    }

    public void addComponent(Component c){
        componentList.add(c);
    }

    public void removeComponent(Component c){
        componentList.remove(c);
    }

    public void getChildren(){
        for (Component c : componentList){
            if (c instanceof Composite){
                System.out.print("Team: ");
                c.print();
            }
            else if (c instanceof Leaf){
                System.out.print("Player: ");
                c.print();
            }
        }
    }
}
