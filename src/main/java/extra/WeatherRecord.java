package extra;

import java.time.LocalDate;

public class WeatherRecord {
    private String dev_id;
    private String name;
    private Location location;
    private String keep_record;
    private LocalDate time;
    private String year;
    private String month;
    private String dayOfWeek;
    private double airTemp;
    private double atmosphericPressure;
    private double gustSpeed;
    private double precipitation;
    private double relativeHumidity;
    private double solar;
    private double strikeDistance;
    private double strikes;
    private double vapourPressure;
    private double windDirection;
    private double windSpeed;

    public WeatherRecord(String dev_id, String name, Location location, String keep_record, LocalDate time, String year, String month, String dayOfWeek, double airTemp, double atmosphericPressure, double gustSpeed, double precipitation, double relativeHumidity, double solar, double strikeDistance, double strikes, double vapourPressure, double windDirection, double windSpeed) {
        this.dev_id = dev_id;
        this.name = name;
        this.location = location;
        this.keep_record = keep_record;
        this.time = time;
        this.year = year;
        this.month = month;
        this.dayOfWeek = dayOfWeek;
        this.airTemp = airTemp;
        this.atmosphericPressure = atmosphericPressure;
        this.gustSpeed = gustSpeed;
        this.precipitation = precipitation;
        this.relativeHumidity = relativeHumidity;
        this.solar = solar;
        this.strikeDistance = strikeDistance;
        this.strikes = strikes;
        this.vapourPressure = vapourPressure;
        this.windDirection = windDirection;
        this.windSpeed = windSpeed;
    }

    public String getDev_id() {
        return dev_id;
    }

    public void setDev_id(String dev_id) {
        this.dev_id = dev_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getKeep_record() {
        return keep_record;
    }

    public void setKeep_record(String keep_record) {
        this.keep_record = keep_record;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public double getAirTemp() {
        return airTemp;
    }

    public void setAirTemp(double airTemp) {
        this.airTemp = airTemp;
    }

    public double getAtmosphericPressure() {
        return atmosphericPressure;
    }

    public void setAtmosphericPressure(double atmosphericPressure) {
        this.atmosphericPressure = atmosphericPressure;
    }

    public double getGustSpeed() {
        return gustSpeed;
    }

    public void setGustSpeed(double gustSpeed) {
        this.gustSpeed = gustSpeed;
    }

    public double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(double precipitation) {
        this.precipitation = precipitation;
    }

    public double getRelativeHumidity() {
        return relativeHumidity;
    }

    public void setRelativeHumidity(double relativeHumidity) {
        this.relativeHumidity = relativeHumidity;
    }

    public double getSolar() {
        return solar;
    }

    public void setSolar(double solar) {
        this.solar = solar;
    }

    public double getStrikeDistance() {
        return strikeDistance;
    }

    public void setStrikeDistance(double strikeDistance) {
        this.strikeDistance = strikeDistance;
    }

    public double getStrikes() {
        return strikes;
    }

    public void setStrikes(double strikes) {
        this.strikes = strikes;
    }

    public double getVapourPressure() {
        return vapourPressure;
    }

    public void setVapourPressure(double vapourPressure) {
        this.vapourPressure = vapourPressure;
    }

    public double getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(double windDirection) {
        this.windDirection = windDirection;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    @Override
    public String toString() {
        return "WeatherRecord{" +
                "dev_id='" + dev_id + '\'' +
                ", name='" + name + '\'' +
                ", location=" + location +
                ", keep_record='" + keep_record + '\'' +
                ", time=" + time +
                ", year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", dayOfWeek='" + dayOfWeek + '\'' +
                ", airTemp='" + airTemp + '\'' +
                ", atmosphericPressure='" + atmosphericPressure + '\'' +
                ", gustSpeed='" + gustSpeed + '\'' +
                ", precipitation='" + precipitation + '\'' +
                ", relativeHumidity='" + relativeHumidity + '\'' +
                ", solar='" + solar + '\'' +
                ", strikeDistance='" + strikeDistance + '\'' +
                ", strikes='" + strikes + '\'' +
                ", vapourPressure='" + vapourPressure + '\'' +
                ", windDirection='" + windDirection + '\'' +
                ", windSpeed='" + windSpeed + '\'' +
                '}';
    }

}
