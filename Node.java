package ashesi.edu.gh.ICP313Assignment;
import java.util.*;
import java.util.ArrayList;


/** This is my node class which is the integral part of the search SearchAlgorithm used for finding the route
 * It has 4 instance variables which consists of the parent node which makes it possible to backtrack the visited airports to write the
 * correct sequence of the search path*/
public class Node {
    private final int state;
    private final Node parent;
    private final int action;
    private final double pathcost;


    public Node(int state, Node parent, int action, double pathcost) {
        this.state = state;
        this.parent = parent;
        this.action = action;
        this.pathcost = pathcost;
    }

    public Node(int init_state) {
        this.state = init_state;
        this.parent = null;
        this.action = 0;
        this.pathcost = 0;
    }

    /**The following are the accessor methods of the instances variables of the node class*/
    public int getState() {
        return this.state;
    }

    public Node getParent() {
        return this.parent;
    }

    public int getAction() {
        return this.action;
    }

    public double getPathcost() {
        return pathcost;
    }

    @Override
    public String toString() {
        return "Node{" +
                "state=" + state +
                ", parent=" + parent +
                ", action=" + action +
                ", pathcost=" + pathcost +
                '}';
    }

    /**The solution path is the method that uses the parent variable and backtracks the route and airports visited to arrive at 
     * the required destination of the search problem*/
    public Object[] solutionPath() {
        ArrayList<Integer> successive_actions = new ArrayList<>();
        ArrayList<Integer> successive_states = new ArrayList<>();
        double flight_path_cost = this.getPathcost();

        while (!(this.parent == null)) {
            successive_states.add(this.parent.getState()); 
            successive_actions.add(this.action);
        } 
        return new Object[]{successive_actions, successive_states, flight_path_cost};
    }

    public static void print_frontier(PriorityQueue<Node> frontier) {
        System.out.println("Frontier has: " + frontier.size() + " items");
        if (frontier.size() > 0) {
            Node minitem = frontier.peek();
            System.out.println(" and the min item is " + minitem.getState() + " with priority " + minitem.getPathcost());
        }
    }
}

/**This comparator class compares two node objects relays information to the priority queue used in the search
 * SearchAlgorithm in order to give it an idea as to how the ordering of the objects should be done in the priority queue*/
class NodeComparator implements Comparator<Node>{
    public int compare(Node key1, Node key2) {
        return Double.compare(key1.getPathcost(), key2.getPathcost()); 

    } 
}



/**This algorithm class is the main search algorithm. This is where the uniform cost search is performed.*/
class SearchAlgorithm {

    public static Object[] uniformCostSearch(Problem problem){
        System.out.println("About to do UCS on problem: " + problem);
        Node node = new Node(problem.getInit_state());
        PriorityQueue<Node> frontier = new PriorityQueue<>(new NodeComparator()); //priority queue for storing airport node
        frontier.add(node); // adds nodes to the frontier at the beginning of the search algorithm
        HashSet<Integer> visitedAirports = new HashSet<>(); // the visited hashset keeps the various already visited airports to avoid repetitive algorithm visitation


      /** In this while loop the algorithm first checks if a given node is the goal node between conducting a more intense search*/
        while(frontier.size() > 0){
            node = frontier.poll();
            if(problem.goal_test(node.getState())){
                System.out.println("Arrived at the destination" + node);
                return node.solutionPath();
            }
            visitedAirports.add(node.getState()); // if the node does not pass the goal test, it then goes ahead to explored the neighbouring airports connected to it
            System.out.println("Generating successive airports nodes: " + node);
            ArrayList<Integer> neighbours = problem.actions(node.getState());
            for (Integer neighbour : neighbours) {
                int sourceID = node.getState();
                int destinationID = neighbour;
                Airport destinationAirportObject = theObjects.getAirport(destinationID, RouteFinder.airportObjects);
                Airport sourceAirportObject = theObjects.getAirport(sourceID, RouteFinder.airportObjects);
                double distance = theObjects.distance(sourceAirportObject.getLatitude(), sourceAirportObject.getLongitude(),
                        destinationAirportObject.getLatitude(), destinationAirportObject.getLongitude());

                double pathCost = node.getPathcost() + distance;
                Node child = new Node(neighbour, node, neighbour, pathCost);
                if (!visitedAirports.contains(child.getState()) && !frontier.contains(child)) {
                    frontier.add(child);
                } else if (frontier.contains(child)) {
                    double oldCost = frontier.peek().getPathcost();
                    if (oldCost > child.getPathcost()) {
                        frontier.remove();
                        frontier.add(child);
                    }
                }

            }
        }
        return null;
    }
}