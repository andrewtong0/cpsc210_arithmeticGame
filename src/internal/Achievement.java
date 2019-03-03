package internal;

import java.util.ArrayList;

public class Achievement {
    public ArrayList<User> achievers = new ArrayList<>();
    public String name;

    public Achievement(String name){
        this.name = name;
    }

    public void addAchiever(User user){
        if (!achievers.contains(user) && user != null){
            achievers.add(user);
            user.addAchievement(this);
        }
    }

    public void removeAchiever(User user){
        if (achievers.contains(user)){
            achievers.remove(user);
            user.removeAchievement(this);
        }
    }
}
