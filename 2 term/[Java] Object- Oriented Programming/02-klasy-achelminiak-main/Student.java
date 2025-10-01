package main;

public class Student {
    private String firstName;
    private String lastName;
    private int indexNumber;
    private double attendance;
    private int grade;

    // Konstruktor dla NN
    public Student(int indexNumber, double attendance, int grade) {
        this.firstName = "Unknown";
        this.lastName = "Unknown";
        this.indexNumber = indexNumber;
        this.attendance = attendance;
        this.grade = (attendance < 50) ? 2 : grade;
    }

    // Konstruktor z podanymi danymi
    public Student(String firstName, String lastName, int indexNumber, double attendance, int grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.indexNumber = indexNumber;
        this.attendance = attendance;
        this.grade = (attendance < 50) ? 2 : grade;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(int indexNumber) {
        this.indexNumber = indexNumber;
    }

    public double getAttendance() {
        return attendance;
    }

    public void setAttendance(double attendance) {
        this.attendance = attendance;
        // Aktualizacja oceny po zmianie obecności
        this.grade = (attendance < 50) ? 2 : grade;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}