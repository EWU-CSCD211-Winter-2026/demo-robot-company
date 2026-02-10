package test;

import model.*;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;

public class AppCollections {

    public static void main(String[] args) {
        Lawyer l1 =  new Lawyer(new Robot("legal stuff"));

        Human bob = new Customer("Bob");

        Lawyer[] lawyers = 
            {
                l1,
                new Lawyer(new Human("Alice")),

            };

        for (int i = 0; i < lawyers.length; i++) {
            System.out.println(lawyers[i]);
            lawyers[i].sue(bob);
        }

        // create an army of robot lawyers of size 1000 or larger
        List<Lawyer> armyArray = new ArrayList<>();
        List<Lawyer> armyLinkedList = new LinkedList<>();

        List<List<Lawyer>> arrayOfLists = new ArrayList<>();
        arrayOfLists.add(armyArray);
        arrayOfLists.add(armyLinkedList);

        Random r = new Random();
        for (int i = 0; i < r.nextInt(10000); i++) {
            armyArray.add(new Lawyer(new Robot("law")));
        }
        System.out.println("size of army: " + armyArray.size());

        Set<Lawyer> lawyerSet = new HashSet<>();
        lawyerSet.add(l1);
        // lawyerSet.get(0) won't work! 


    }

}
