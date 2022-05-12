import java.util.Random;

public class Customer {
    String name;
    String lastName;
    String IDNumber;
    public Customer() {
        name = "Add customer name";
        lastName = "Add last name";
        IDNumber = "00000";
    }

    public String getIDNumber() {
        return IDNumber;
    }

    public void setIDNumber() {
        Random r = new Random();
        int newID = r.nextInt(999999)+111111;
        this.IDNumber = String.valueOf(newID);
    }

    public void setName(String name) {
        this.name = name.substring(0,1).toUpperCase() + name.substring(1);
    }
    public void setLastName(String lastName) {
        this.lastName = lastName.substring(0,1).toUpperCase() + lastName.substring(1);
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }
    public void writeOutput() {
        System.out.println("Name: " +getLastName() + ", " + getName());
        System.out.println("ID NUMBER: " + getIDNumber());
    }
}
