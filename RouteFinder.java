package ashesi.edu.gh.ICP313Assignment;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**The RouteFinder class of the project is in charge of computing the optimal
 * routes for a traveller using distance as the indicator. The RouteFinder class has the uniform cost search algorithm with
 * which has a frontier for storing airportcodes and a visted_airports to keep track of already explored airports.
 *
 * This same class also has a method that writes the output which contains optimal route to an output file in the same source*/



public class RouteFinder {
    public static ArrayList<Airport> airportObjects = new ArrayList<>();
    public static ArrayList<Airline> airlineObjects = new ArrayList<>();
    public static ArrayList<Route> routeObjects = new ArrayList<>();
 
    
    public static void main(String[] args) {
        ArrayList<String[]> airportStringArray = new ArrayList<>(
                Document.readFile("C:\\Users\\HP\\Desktop\\CS_YEAR_2_SEMESTER_2\\ICP\\airports.csv"));
        for (String[] array : airportStringArray) {
            Airport object = theObjects.create_airportMap(array);
            airportObjects.add(object);
        }
        ArrayList<String[]> airlineStringArray = new ArrayList<>(
                Document.readFile("C:\\Users\\HP\\Desktop\\CS_YEAR_2_SEMESTER_2\\ICP\\airlines.csv"));
        for (String[] array : airlineStringArray) {
            Airline object = theObjects.airlineObjectCreation(array);
            airlineObjects.add(object);
        }
        ArrayList<String[]> routeStringArray = new ArrayList<>(
                Document.readFile("C:\\Users\\HP\\Desktop\\CS_YEAR_2_SEMESTER_2\\ICP\\routes.csv"));
        for (String[] array : routeStringArray) {
            Route object = theObjects.routesObjectCreation(array);
            routeObjects.add(object);
        }


//
        ArrayList<String[]> input = Document.readFile("C:\\Users\\HP\\Desktop\\CS_YEAR_2_SEMESTER_2\\ICP\\sampleInput.txt");
        String[] sourceAirport = input.get(0);
        System.out.println(Arrays.toString(sourceAirport));
        int sourceAirportID = theObjects.city_and_counttry_AirportID(sourceAirport[0], sourceAirport[1]);
        Airport source = theObjects.getAirport(sourceAirportID, airportObjects);
        String[] destinationAirport = input.get(1);
        int dAirportID = theObjects.city_and_counttry_AirportID(destinationAirport[0], destinationAirport[1]);
        Airport destination = theObjects.getAirport(dAirportID,airportObjects);


        Document.OutputFile("C:\\Users\\HP\\Desktop\\CS_YEAR_2_SEMESTER_2\\ICP\\src\\output");

        Problem prob = new Problem(source.getAirportID(), destination.getAirportID(), routeObjects);
        System.out.println(Arrays.toString(SearchAlgorithm.uniformCostSearch(prob)));
    }
}


class Document {
    public static ArrayList<String[]> readFile(String filelocation) {
        ArrayList<String[]> ArrayString = new ArrayList<>();
        try{
            File fileObj = new File(filelocation);
            BufferedReader br = new BufferedReader(new FileReader(fileObj));
            String line;

            while ((line = br.readLine()) != null){
                String [] eachline = line.split(",");
                ArrayString.add(eachline);
            }
            br.close();
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());

        }catch (IOException e){
            System.out.println( e.getMessage());
        }
        return ArrayString;
    }


    /**This method writes the correct output to the file which consists of the route and the distance*/
    public static void OutputFile(String filenamePath){
        ArrayList<String[]> sampleInput = Document.readFile("C:\\Users\\HP\\Desktop\\CS_YEAR_2_SEMESTER_2\\ICP\\sampleInput.txt");
        String[] sourceAirport = sampleInput.get(0);
        int sourseAirportID = theObjects.city_and_counttry_AirportID(sourceAirport[0], sourceAirport[1]);
        String[] destinationAirport = sampleInput.get(1);
        int dAirportID = theObjects.city_and_counttry_AirportID(destinationAirport[0], destinationAirport[1]);
        Airport myobj = theObjects.getAirport(sourseAirportID, RouteFinder.airportObjects);
        Airport one = theObjects.getAirport(dAirportID, RouteFinder.airportObjects);
        Airline two = theObjects.getAirline(1355, RouteFinder.airlineObjects);
        Route three = theObjects.getRoute(1355, RouteFinder.routeObjects);
        String text = (two.getIATAcode() + " from " + myobj.getIATACode() + " to " +
                one.getIATACode() + "  " +  three.getStops() + " stops");
        String flightdistance = String.valueOf((theObjects.distance(myobj.getLatitude(), myobj.getLongitude(),
                one.getLatitude(), one.getLongitude()))); 
        try {
            File file = new File(filenamePath);
            BufferedWriter bw = new BufferedWriter(new FileWriter(file)); 
            bw.write(text);
            bw.newLine();
            bw.write("Total distance: " + flightdistance + " Km ");
            System.out.println("output written to file");
            bw.close();
        }
        catch (IOException e) {
            System.out.print(e.getMessage());
        }
    }
}

/**This class creates objects for each of the file classes and implements the body of their getters corresponding to the instance variables.*/

class theObjects{
    public static Airport create_airportMap(String[] airportArray){
        int airportID = 0;
        double latitude = 0;
        double longitude = 0;
        double altitude = 0;
        double timezone = 0;
        try{
            airportID = Integer.parseInt(airportArray[0]);
            latitude = Double.parseDouble(airportArray[6]);
            longitude = Double.parseDouble(airportArray[7]);
            altitude = Double.parseDouble(airportArray[8]);
            timezone = Double.parseDouble(airportArray[9]);
        }
        catch(NumberFormatException nfe){
            System.out.println( nfe.getMessage());
        }


        String name = airportArray[1];
        String city = airportArray[2];
        String country = airportArray[3];
        String iataCode = airportArray[4];
        String icaoCode = airportArray[5];
        String DST = airportArray[10];
        String tz = airportArray[11];
        String type = airportArray[12];
        String datasource = airportArray[13];

        return new Airport(
                airportID, name, city, country, iataCode, icaoCode, latitude, longitude,
                altitude, timezone, DST, tz, type, datasource);

    }

    public static Airline airlineObjectCreation(String[] airlineArray){
        int airlineId = 0;
        try{
            airlineId = Integer.parseInt(airlineArray[0]);
        }
        catch(NumberFormatException ne){
            System.out.println(ne.getMessage());

        }
        String name = airlineArray[1];
        String alias = airlineArray[2];
        String iatacode = airlineArray[3];
        String icaocode = airlineArray[4];
        String callsign = airlineArray[5];
        String country = airlineArray[6];
        String active = airlineArray[7];

        return new Airline(airlineId, name, alias, iatacode,icaocode, callsign,
                country, active);

    }

    public static Route routesObjectCreation(String[] routeArray){
        int airlineid = 0;
        int sourceairportid = 0;
        int destairportid = 0;
        int stops = 0;
        try{
            airlineid = Integer.parseInt(routeArray[1]);
            sourceairportid = Integer.parseInt(routeArray[3]);
            destairportid = Integer.parseInt(routeArray[5]);
            stops = Integer.parseInt(routeArray[7]);
        }
        catch (NumberFormatException | ArrayIndexOutOfBoundsException e){
            System.out.println( e.getMessage());
        }
        String airlinecode = routeArray[0];
        String sourceairportcode = routeArray[2];
        String destination_airportcode = routeArray[4];
        String codeshare = routeArray[6];
        String equipment = routeArray[routeArray.length - 1];

        return new Route(airlinecode, airlineid, sourceairportcode, sourceairportid, destination_airportcode,
                destairportid, codeshare, stops, equipment);
    }


    public static Airport getAirport(int airportid, ArrayList<Airport> airportArrayObj) {
        Airport airportObj = new Airport();
        for (Airport airport : airportArrayObj) {
            if (airportid == airport.getAirportID()) {
                airportObj = airport;
            }
        }
        return airportObj;
    }

    public static Airline getAirline(int airlineid, ArrayList<Airline> airlineArrayObj) {
        Airline airlineObj = new Airline();
        for (Airline airline : airlineArrayObj) {
            if (airlineid == airline.getAirlineId()) {
                airlineObj = airline;
            }
        }
        return airlineObj;
    }

    public static Route getRoute(int airlineid, ArrayList<Route> routeArrayObj) {
        Route routeObj = new Route();
        for (Route route : routeArrayObj) {
            if (airlineid == route.getAirlineid()) {
                routeObj = route;
            }
        }
        return routeObj;
    }


    /**This methods computes the distance between two airports using the haversine Formula*/

    private static final int radius = 6371;
    public static double distance(double initial_latitude, double initLong,
                                  double destination_latitude, double finalLong) {
        double LatDistance  = Math.toRadians((destination_latitude - initial_latitude));
        double LongDistance = Math.toRadians((finalLong - initLong));
        initial_latitude = Math.toRadians(initial_latitude);
        destination_latitude   = Math.toRadians(destination_latitude);
        double a = haversineFormula(LatDistance) + Math.cos(initial_latitude) * Math.cos(destination_latitude) * haversineFormula(LongDistance);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return radius * c;
    }

    public static double haversineFormula(double val) {
        return Math.pow(Math.sin(val / 2), 2);
    }


    public static int city_and_counttry_AirportID(String city, String country){
        int ariportIdKeeper = 0;
        for (Airport airport: RouteFinder.airportObjects) {
            if (airport.getCity().equals(city) || airport.getCountry().equals(country)) {
                ariportIdKeeper = airport.getAirportID();
            }
        }

        return ariportIdKeeper;
    }




}


