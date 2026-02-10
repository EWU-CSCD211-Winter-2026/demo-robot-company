
package universe;
import model.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Universe implements Configurable {

    private List<Lawyer> army;
    private Marketer marketer;

    public Universe() {
        configureRandom();
    }

    @Override
    public void configureRandom() {
        Random r = new Random(0);

        army = new ArrayList<>();
        String[] specialties = {"property", "civil rights", "tort", "tax"};
        
        String[] marketing_specialties= {"advertising", "PR", "personalization"};
        int marketingIndex = r.nextInt(marketing_specialties.length);
        marketer = new Marketer(new Robot(marketing_specialties[marketingIndex]));

        
    
        for (int i = 0; i < 5; i++) {
            int specialtyIndex = r.nextInt(specialties.length);
            Robot ro = new Robot(specialties[specialtyIndex]);
            CorporateLawyer lawyer = new CorporateLawyer(ro);
            army.add(lawyer);
            
        }
        
    }

    @Override
    public boolean equals(Object o) {
        // 1. check if it's null, if so, return false
        if (o == null) {
            return false;
        }
        // 2. check if o is a Universe
        if (o instanceof Universe) {
            // if it is, cast it
            Universe other = (Universe) o;
            return other.army.equals(this.army);
        }
        return false;
    }

}
