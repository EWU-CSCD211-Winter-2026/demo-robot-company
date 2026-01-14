package model;

public class Employee extends Person {

    private String W2;
    private int baseSalary;

    public Employee(String name) {
        super(name);
        this.W2 = "Taxes";
        this.baseSalary = 100000;
        
    }

    public int getSalary() {
        boolean hasAccess = true;
        if (hasAccess) {
            return baseSalary;
        } else {
            throw new RuntimeException("You do not have access to Employee salary data.");
        }
        // return salary;
    }

    public String getW2() {
        return W2;
    }

    public void generateW2() {
        System.out.println("Generating W2");
        this.W2 = "1098 form for the current year.";
    }

    public void setSalary(int salary) {
        boolean hasAccess = false; // or true if some other conditions are met

        if (hasAccess) {
            this.baseSalary = salary;
        } else {
            throw new RuntimeException("You do not have privilege necessary to change the salary.");
        }
    }

    
    
}
