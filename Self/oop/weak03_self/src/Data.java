public class Data {

    private int day;
    private int month;
    private int year;

    public Data() {
    }

    public Data(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (day < 1 || day > 31) {
            System.out.println("Invalid day");
        }
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month < 1 || month > 12) {
            System.out.println("Invalid month");
        }
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {

        if (year < 1 || year > 12) {
            System.out.println("Invalid year");
        }
        this.year = year;
    }

    @Override
    public String toString() {
        return "Date[day=" + day + ", month=" + month + ", year=" + year + "]";
    }
}
