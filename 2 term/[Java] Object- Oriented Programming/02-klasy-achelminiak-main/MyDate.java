package main;

public class MyDate {
    private int day;
    private int month;
    private int year;

    public MyDate(int day, int month, int year) {
        if (isValidDate(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            throw new IllegalArgumentException("Invalid date values.");
        }
    }
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (isValidDay(day)) {
            this.day = day;
        } else {
            throw new IllegalArgumentException("Invalid day value.");
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (isValidMonth(month)) {
            this.month = month;
        } else {
            throw new IllegalArgumentException("Invalid month value.");
        }
    }
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (isValidYear(year)) {
            this.year = year;
        } else {
            throw new IllegalArgumentException("Invalid year value.");
        }
    }

    public void displayDate() {
        System.out.printf("%02d/%02d/%04d%n", day, month, year);
    }

    private boolean isValidDate(int day, int month, int year) {
        return isValidDay(day) && isValidMonth(month) && isValidYear(year);
    }

    private boolean isValidDay(int day) {
        return day >= 1 && day <= 31;
    }

    private boolean isValidMonth(int month) {
        return month >= 1 && month <= 12;
    }

    private boolean isValidYear(int year) {
        return year >= 1990 && year <= 2050;
    }
}
