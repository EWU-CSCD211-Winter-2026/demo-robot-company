package model;

public class Lawyer extends Employee {

    private String JD;
    private String[] licenses;

    public Lawyer(String name) {
        super(name);
    }

    @Override
    public int getSalary() {
        return super.getSalary() + 10000;
    }

    public boolean sue(Person person) {
        System.out.println("Suing " + person);
        return true;
    }

    
    
}
