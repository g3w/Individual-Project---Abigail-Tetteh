
package ashesi.edu.gh.ICP313Assignment;
public class Route {

/** The instance variables of
 * the Route file class*/
    private final String airlinecode;
    private final int airlineid;
    private final String sourceairportcode;
    private final int sourceairportid;
    private final String destinationairportcode;
    private final int destinationairportid;
    private final String codeshare;
    private final int stops;
    private final String equipment;

    /**
     *
     * @param airlinecode IATA or ICAO code of the airline
     * @param airlineid ID of the airline
     * @param sourceairportcode IATA or ICAO code of the source airport
     * @param sourceairportid ID of the source airport
     * @param destinationairportcode IATA or ICAO code of destination airporty
     * @param destinationairportid ID of the destination airport
     * @param codeshare "y" if this flight is a codeshare, empty otherwise
     * @param stops number of stops on this flight
     * @param equipment three-letter code(s) for plane types generally used on this flight
     */
    public Route(String airlinecode, int airlineid, String sourceairportcode,
                 int sourceairportid, String destinationairportcode, int destinationairportid,
                 String codeshare, int stops, String equipment) {
        this.airlinecode = airlinecode;
        this.airlineid = airlineid;
        this.sourceairportcode = sourceairportcode;
        this.sourceairportid = sourceairportid;
        this.destinationairportcode = destinationairportcode;
        this.destinationairportid = destinationairportid;
        this.codeshare = codeshare;
        this.stops = stops;
        this.equipment = equipment;
    }

    public Route() {
        this.airlinecode = "";
        this.airlineid = 0;
        this.sourceairportcode = "";
        this.sourceairportid = 0;
        this.destinationairportcode = "";
        this.destinationairportid = 0;
        this.codeshare = "";
        this.stops = 0;
        this.equipment = "";
    }




    /**
     *
     * @return toString method which prints out more
     * information about my instance variables
     */

    @Override
    public String toString() {
        return "Routes{" +
                "airlinecode='" + airlinecode + '\'' +
                ", airlineid=" + airlineid +
                ", sourceairportcode='" + sourceairportcode + '\'' +
                ", sourceairportid=" + sourceairportid +
                ", destinationairportcode='" + destinationairportcode + '\'' +
                ", destinationairportid=" + destinationairportid +
                ", codeshare='" + codeshare + '\'' +
                ", stops=" + stops +
                ", equipment='" + equipment + '\'' +
                '}';
    }

    /** The  following methods are accessor methods or gethods which retrieves information
     * about each instance variable*/
    public String getAirlinecode() {
        return airlinecode;
    }

    public int getAirlineid() {
        return airlineid;
    }

    public String getSourceairportcode() {
        return sourceairportcode;
    }

    public int getSourceairportid() {
        return sourceairportid;
    }

    public String getDestinationairportcode() {
        return destinationairportcode;
    }

    public int getDestinationairportid() {
        return destinationairportid;
    }

    public String getCodeshare() {
        return codeshare;
    }

    public int getStops() {
        return stops;
    }

    public String getEquipment() {
        return equipment;
    }
}


