public class Person {
    private String firstName;
    private String lastName;
    private String ID;
    private String title;
    private int YOB;


   // Constructor
    public Person(String firstName, String lastName, String ID, String title, int YOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.title = title;
        this.YOB = YOB;
    }

    // getters and setters

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

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }
    //tostring method
    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ID='" + ID + '\'' +
                ", title='" + title + '\'' +
                ", YOB=" + YOB +
                '}';
    }
//additional methods
    public String fullName() { return firstName + " " + lastName; }
    public String formalName() { return title + " " + fullName(); }
    public int getAge() {
        return java.util.Calendar.getInstance().get(java.util.Calendar.YEAR) - YOB;
    }
    public int getAge(int year) { return year - YOB; }
    /* trying a new CSV format
    public String toCSV() { return toString(); }*/
    public String toCSV() {
        return ID + "," + firstName + "," + lastName + "," + title + "," + YOB;
    }
    public String toJSON() { /* Implement JSON */ return ""; }
    public String toXML() { /* Implement XML */ return ""; }
}
