import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import extra.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/* (C)2024 */
public class Main {

    private static String[] METRICS_NAMES = {"Air Temperature", "Atmospheric Pressure", "Gust Speed", "Precipitation",
            "Relative Humidity", "Solar", "Strike Distance", "Strikes", "Vapour Pressure", "Wind Direction", "Wind Speed"};

    public static void main(String[] args) throws IOException, ParseException {
        //Reading json
        JSONParser parser = new JSONParser();
        Reader reader = new FileReader("src/main/resources/weather-stations-city-of-geelong.json");
        Object jsonObj = parser.parse(reader);

        JSONArray json = (JSONArray) jsonObj;

        //Parsing json to List
        List<WeatherRecord> records = parseToList(json);

        //Getting all dates
        List<String> dates = records.stream().map(WeatherRecord::getTime).distinct().map(LocalDate::toString).toList();

        List<List<DayMetrics>> values = getMetricsValues(records);

        List<WeatherStatistics> resultsGeneral = calculateMetrics(values);
        displayResult(resultsGeneral);

        var resultsByDay = calculateMetrics(values, dates);

        System.out.println("\nMetrics By Day");
        displayResult(resultsByDay, dates);
    }

    private static List<WeatherRecord> parseToList(JSONArray json) {
        JSONObject temp;
        List<WeatherRecord> weatherRecords = new ArrayList<>();

        double tempLon;
        double tempLat;

        OffsetDateTime tempDate;

        for (Object o : json) {
            temp = (JSONObject) o;
            tempLon = (double) ((JSONObject) temp.get("location")).get("lon");
            tempLat = (double) ((JSONObject) temp.get("location")).get("lat");
            tempDate = OffsetDateTime.parse(temp.get("time").toString());

            if(temp.get("airtemp") == null) continue;

            weatherRecords.add(new WeatherRecord(
                            temp.get("dev_id").toString(),
                            temp.get("name").toString(),
                            new Location(tempLon, tempLat),
                            temp.get("keep_record").toString(),
                            tempDate.toLocalDate(),
                            temp.get("year").toString(),
                            temp.get("month").toString(),
                            temp.get("dayofweek").toString(),
                            (double) temp.get("airtemp"),
                            (double) temp.get("atmosphericpressure"),
                            (double) temp.get("gustspeed"),
                            (double) temp.get("precipitation"),
                            (double) temp.get("relativehumidity"),
                            (double) temp.get("solar"),
                            (double) temp.get("strikedistance"),
                            (double) temp.get("strikes"),
                            (double) temp.get("vapourpressure"),
                            (double) temp.get("winddirection"),
                            (double) temp.get("windspeed")
                    )
            );
        }
        return weatherRecords;
    }

    private static List<List<DayMetrics>> getMetricsValues(List<WeatherRecord> records){
        List<List<DayMetrics>> values = new ArrayList<>();

        List<DayMetrics> airTemps = new ArrayList<>();
        List<DayMetrics> atmPress = new ArrayList<>();
        List<DayMetrics> gustsSpeeds = new ArrayList<>();
        List<DayMetrics> precipitations = new ArrayList<>();
        List<DayMetrics> humidities = new ArrayList<>();
        List<DayMetrics> solars = new ArrayList<>();
        List<DayMetrics> strikeDist = new ArrayList<>();
        List<DayMetrics> strikes = new ArrayList<>();
        List<DayMetrics> vapourPress = new ArrayList<>();
        List<DayMetrics> windDirections = new ArrayList<>();
        List<DayMetrics> windSpeeds = new ArrayList<>();

        String date, day;

        for(WeatherRecord record : records) {
            date = record.getTime().toString();
            day = record.getDayOfWeek();

            airTemps.add(new DayMetrics(date, day, record.getAirTemp()));
            atmPress.add(new DayMetrics(date, day, record.getAtmosphericPressure()));
            gustsSpeeds.add(new DayMetrics(date, day, record.getGustSpeed()));
            precipitations.add(new DayMetrics(date, day, record.getPrecipitation()));
            humidities.add(new DayMetrics(date, day, record.getRelativeHumidity()));
            solars.add(new DayMetrics(date, day, record.getSolar()));
            strikeDist.add(new DayMetrics(date, day, record.getStrikeDistance()));
            strikes.add(new DayMetrics(date, day, record.getStrikes()));
            vapourPress.add(new DayMetrics(date, day, record.getVapourPressure()));
            windDirections.add(new DayMetrics(date, day, record.getWindDirection()));
            windSpeeds.add(new DayMetrics(date, day, record.getWindSpeed()));
        }

        values.add(airTemps);
        values.add(atmPress);
        values.add(gustsSpeeds);
        values.add(precipitations);
        values.add(humidities);
        values.add(solars);
        values.add(strikeDist);
        values.add(strikes);
        values.add(vapourPress);
        values.add(windDirections);
        values.add(windSpeeds);

        return values;
    }

    private static List<WeatherStatistics> calculateMetrics(List<List<DayMetrics>> records){
        List<WeatherStatistics> weatherStatistics = new ArrayList<>();
        for(int i = 0; i < records.size(); i++) {
            var l = records.get(i).stream().map(DayMetrics::getVal).toList();
            var res = Statistics.getStatistics(l);
            weatherStatistics.add(new WeatherStatistics(res.get(0), res.get(1), res.get(2), null, null,
                    Main.METRICS_NAMES[i]));
        }

        return weatherStatistics;
    }

    private static HashMap<String, List<WeatherStatistics>> calculateMetrics(List<List<DayMetrics>> records, List<String> dates){
        HashMap<String, List<WeatherStatistics>> result = new HashMap<>();
        LocalDate d;
        for(String date : dates){
            List<WeatherStatistics> weatherStatistics = new ArrayList<>();
            for(int i = 0; i < records.size(); i++) {
                d = LocalDate.parse(date);
                var l = records.get(i).stream().filter(r -> r.getDate().equals(date)).map(DayMetrics::getVal).toList();
                var res = Statistics.getStatistics(l);
                weatherStatistics.add(new WeatherStatistics(res.get(0), res.get(1), res.get(2),
                        date, d.getDayOfWeek().toString(),
                        Main.METRICS_NAMES[i]));
            }
            result.put(date, weatherStatistics);
        }

        return result;
    }


    private static void displayResult(List<WeatherStatistics> results){
        for(int i = 0; i < results.size(); i++) {
            System.out.print(Main.METRICS_NAMES[i] + ":\n\t");
            System.out.printf("Min: %.2f" + "\n\t", results.get(i).getMin());
            System.out.printf("Max: %.2f" + "\n\t",results.get(i).getMax());
            System.out.printf("Average: %.2f" + "\n",results.get(i).getAvg());
        }
    }

    private static void displayResult(HashMap<String, List<WeatherStatistics>> results, List<String> dates){
        LocalDate d;
        String day;
        char aux;
        for(String date : dates){
            d = LocalDate.parse(date);
            System.out.print("\n" + d.getDayOfWeek().toString().toLowerCase() + " " + date  + ":\n");
            displayResult(results.get(date));
        }
    }
}
