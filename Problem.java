package ashesi.edu.gh.ICP313Assignment;
import java.util.ArrayList;
import java.util.Objects;

/** This is my problem class which defines the various components of the search problem.
 * The problem class has initial airport and destination airport and a map formed from the route showing the various routes available for solving
 * any route problem*/

public class Problem{
    private  final int init_state;
    private final int goal_state;
    private final ArrayList<Route> airportMap;

    public Problem(int init_state, int goal_state, ArrayList<Route> airportMap){
        this.init_state = init_state;
        this.goal_state = goal_state;
        this.airportMap = airportMap;
    }

    public int getInit_state() {
        return init_state;
    }

    public int getDestination_state() {
        return goal_state;
    }

    public ArrayList<Route> getMap() {
        return airportMap;
    }

    //This method checks if a particular airport is the required destination of the route.
    public boolean goal_test(int state){
        return (Objects.equals(this.goal_state, state));
    }

    // The action methods tries to create a airport code with their corresponding connected airports known as neighbours
    public ArrayList<Integer> actions(int state){
        ArrayList<Integer> neighbours = new ArrayList<>();
        for (Route object: this.airportMap) {
            if (state == object.getSourceairportid()) {
                neighbours.add(object.getDestinationairportid());
            }
        }
        return neighbours;

    }
}
