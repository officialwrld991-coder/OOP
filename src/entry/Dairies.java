package entry;

import java.util.ArrayList;
import java.util.List;

public class Dairies {

    private boolean dairiesStatus = true;
    private int count;
    private List<Dairy> dairies = new ArrayList<Dairy>();

    public boolean isEmpty() {
       if (count == 0) return true;
       else return false;
    }

    public void addDairy(String username, String password) {
        for(Dairy dairy : dairies) {
            if(dairy.getUsername().equalsIgnoreCase(username)) {
                throw new IllegalArgumentException("Username already exists!");
            }
        }
        Dairy newDairy = new Dairy(username, password);
        dairies.add(newDairy);
        count++;
    }

    public Dairy findDairy(String username) {
        for (Dairy found : dairies) {
            if (found.getUsername().equalsIgnoreCase(username))
           return found;
        }
        throw new IllegalArgumentException("Dairy Not Found");
    }

    public void deleteDairy(String second, String password) {
       try {
           Dairy deleted = findDairy(second);
           deleted.unlockDairy(password);
           dairies.remove(deleted);
       } catch (Exception e ) {
           throw new IllegalArgumentException("Incorrect password!");
       }
    }
}
