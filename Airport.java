package ashesi.edu.gh.ICP313Assignment;




public class Airport {
    /**
     * Instance Variables for the Airport
     */
    private final int airportID;
    private final String name;
    private final String city;
    private final String country;
    private final String IATACode;
    private final String ICAOCode;
    private final double latitude;
    private final double longitude;
    private final double altitude;
    private final double timezone;
    private final String DST;
    private final String tz;
    private final String type;
    private final String datasource;

    /**
     * @author Abigail Efua Tetteh - 37222024
     * Computer Science 2024
     *
     * @param airportID is the airport ID
     * @param name is the name of the airport
     * @param city is the airport city
     * @param country is the country where the airport is located
     * @param IATACode three-letter IATA code.
     * @param ICAOCode four-letter ICAO code.
     * @param latitude 	latitude.
     * @param longitude longitude
     * @param altitude vertical distance
     * @param timezone
     * @param DST Daylight Saving time
     * @param tz Timezone in tz
     * @param type airport type
     * @param datasource Source of this data
     */


    public Airport(int airportID, String name, String city, String country, String IATACode,
                   String ICAOCode, double latitude, double longitude, double altitude,
                   double timezone, String DST, String tz, String type, String datasource) {

        this.airportID = airportID;
        this.name = name;
        this.city = city;
        this.country = country;
        this.IATACode = IATACode;
        this.ICAOCode = ICAOCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.timezone = timezone;
        this.DST = DST;
        this.tz = tz;
        this.type = type;
        this.datasource = datasource;
    }


    public Airport() {
        this.airportID = 0;
        this.name = "";
        this.city = "";
        this.country = "";
        this.IATACode = "";
        this.ICAOCode = "";
        this.latitude = 0;
        this.longitude = 0;
        this.altitude = 0;
        this.timezone = 0;
        this.DST = "";
        this.tz = "";
        this.type = "";
        this.datasource = "";
    }

    /**
     *
     * @return toString method which prints out more
     *      * information about my instance variables
     */
    @Override
    public String toString() {
        return "Airport{" +
                "airportID=" + airportID +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", IATACode='" + IATACode + '\'' +
                ", ICAOCode='" + ICAOCode + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", altitude=" + altitude +
                ", timezone=" + timezone +
                ", DST='" + DST + '\'' +
                ", tz='" + tz + '\'' +
                ", type='" + type + '\'' +
                ", datasource='" + datasource + '\'' +
                '}';
    }


    public int getAirportID() {
        return airportID;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getIATACode() {
        return IATACode;
    }

    public String getICAOCode() {
        return ICAOCode;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public double getTimezone() {
        return timezone;
    }

    public String getDST() {
        return DST;
    }

    public String getTz() {
        return tz;
    }

    public String getType() {
        return type;
    }

    public String getDatasource() {
        return datasource;
    }
}