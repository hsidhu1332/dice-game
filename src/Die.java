import java.util.Random;
public class Die {
    int die;
    Random rand;
    
    
    public Die() { // Default constructor
        die = 0;
        rand = new Random();
    }

    public void roll() {
        die = rand.nextInt(6) + 1; // Die roll of 1 to 6
    }

    public boolean equals(int die1, int die2) { // Check if both die rolls are equal
        if(die1 == die2) {
            return true;
        }
        else {
            return false;
        }
    }

    public String toString() {
        String dieName = null;
        switch(die) { // Assigns dieName to the number as a word
            case 1:
                dieName = "one";
                break;
            
            case 2:
                dieName = "two";
                break;
            
            case 3:
                dieName = "three";
                break;
            
            case 4:
                dieName = "four";
                break;
            
            case 5:
                dieName = "five";
                break;
            
            case 6:
                dieName = "six";
                break;
            
        }
        return dieName;
   
    }
}