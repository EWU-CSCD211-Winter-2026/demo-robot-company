package model;

public class Marketer extends Employee {

    public Marketer(String name) {
        super(name);
    }
    @Override
    public int getSalary() {
        return super.getSalary() + 50000;
    }
}
