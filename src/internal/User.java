package internal;

import java.util.ArrayList;
import java.util.Objects;

public class User {
    public String username;
    public Integer uuid;
    public ArrayList<Achievement> achievements = new ArrayList<Achievement>();

    public User(String username, Integer uuid){
        this.username = username;
        this.uuid = uuid;
    }

    public void addAchievement(Achievement achievement){
        if (!achievements.contains(achievement)){
            achievements.add(achievement);
            achievement.addAchiever(this);
        }
    }

    public void removeAchievement(Achievement achievement){
        if (achievements.contains(achievement)){
            achievements.remove(achievement);
            achievement.removeAchiever(this);
        }
    }

    public void getAchievements(){
        for (Achievement achievement : achievements){
            System.out.println(achievement.name);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(uuid, user.uuid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(uuid);
    }
}
