package extra;

public class WeatherStatistics {
    private Double min;
    private Double avg;
    private Double max;
    private String date;
    private String day;
    private String metric;

    public WeatherStatistics(Double min, Double avg, Double max, String date, String day, String metric) {
        this.min = min;
        this.max = max;
        this.avg = avg;
        this.date = date;
        this.day = day;
        this.metric = metric;
    }

    public Double getMin() {
        return min;
    }

    public Double getMax() {
        return max;
    }

    public Double getAvg() {
        return avg;
    }

    public String getDate() {
        return date;
    }

    public String getDay() {
        return day;
    }

    public String getMetric() {
        return metric;
    }
}
