package ashesi.edu.gh.ICP313Assignment;

public class Airline{
    /**
     * Instance variables for the Airline
     */
    private final int airlineId;
    private final String name;
    private final String alias;
    private final String IATAcode;
    private final String ICAOcode;
    private final String callsign;
    private final String country;
    private final String active;

    /**
     *
     * @param airlineId the ID of the airline
     * @param name the name of the airline
     * @param alias is the alias of the airline
     * @param IATAcode two letter IATA code
     * @param ICAOcode three letter ICAO code
     * @param callsign airline callsign
     * @param country country where airport is located
     * @param active "y" if airline is active, and "n"  for not working
     */

    public Airline(int airlineId, String name, String alias, String IATAcode, String ICAOcode, String callsign,
                   String country, String active){
        this.airlineId = airlineId;
        this.name = name;
        this.alias = alias;
        this.IATAcode = IATAcode;
        this.ICAOcode = ICAOcode;
        this.callsign = callsign;
        this.country = country;
        this.active = active;
    }

    public Airline() {
        this.airlineId = 0;
        this.name = "";
        this.alias = "";
        this.IATAcode = "";
        this.ICAOcode = "";
        this.callsign = "";
        this.country = "";
        this.active = "";

    }


    public int getAirlineId() {
        return airlineId;
    }

    public String getName() {
        return name;
    }

    public String getAlias() {
        return alias;
    }

    public String getIATAcode() {
        return IATAcode;
    }

    public String getICAOcode() {
        return ICAOcode;
    }

    public String getCallsign() {
        return callsign;
    }

    public String getCountry() {
        return country;
    }

    public String getActive() {
        return active;
    }


    /**
     *
     * @return toString method which prints out more
     *      * information about my instance variables
     */
    @Override
    public String toString() {
        return "Airline{" +
                "airlineId=" + airlineId +
                ", name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                ", IATAcode='" + IATAcode + '\'' +
                ", ICAOcode='" + ICAOcode + '\'' +
                ", callsign='" + callsign + '\'' +
                ", country='" + country + '\'' +
                ", active='" + active + '\'' +
                '}';
    }
}
