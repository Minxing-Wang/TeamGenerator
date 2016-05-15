import java.util.ArrayList;
import java.util.List;

public class Team {
    String name;
    public List<Player> Players = new ArrayList<Player>();

    public Team(String name){
        this.name = name;
    }

    public void addPlayer(Player p){
        Players.add(p);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Player> getPlayers() {
        return Players;
    }

    public int getSize(){
        return Players.size();
    }



}
