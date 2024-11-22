package extra;

public class DayMetrics {
    private final String date;
    private final String day;
    private final Double val;

    public DayMetrics(String date, String day, Double val) {
        this.date = date;
        this.day = day;
        this.val = val;
    }

    public String getDate() {
        return date;
    }

    public String getDay() {
        return day;
    }

    public Double getVal() {
        return val;
    }
}
