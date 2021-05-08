package _01_MurderOfCrows;

import java.util.ArrayList;
import java.util.Random;

public class MurderOfCrows {

    ArrayList<Crow> theMurder = new ArrayList<Crow>();

    public static void main(String[] args) {
        MurderOfCrows murderOfCrows = new MurderOfCrows();
        murderOfCrows.initializeCrows();
        murderOfCrows.findTheDiamond();
    }

    private void findTheDiamond() {
        // 1. One of the Crows has eaten the diamond. You need to search
        //    through the stomach of each Crow, then print the name of the
        //    guilty Crow.

        // 2. How many innocent crows had to die before the diamond was found?

    }

    private void initializeCrows() {
        theMurder.add(new Crow("Rok"));
        theMurder.add(new Crow("Merle"));
        theMurder.add(new Crow("Poe"));
        theMurder.add(new Crow("Grenwyn"));
        theMurder.add(new Crow("Crawford"));
        hideTheDiamond();
    }

    private void hideTheDiamond() {
        int randomness = new Random().nextInt(theMurder.size());
        theMurder.get(randomness).getStomachContents().add("diamond");
        //THE RANDOMNESS VARIABLE SORTS THROUGH EACH CROW AND RANDOMLY ASSIGNS ONE OF THEM
        //WITH THE DIAMOND. theMurder is the array with all the crows
        //BASICALLY YOU NEED TO GO THROUGH ALL THE CROWS IN THE theMurder array using a
        //for loop and look in each crows stomach contents. If themurder.get(i).stomachContents
        //.contains "diamond" then print theMurder.get(i)
        //IDK If that's right, try it, but go through the class again to see what's going on
    }
}

class Crow {
    private String name;
    private ArrayList<String> stomachContents = new ArrayList<String>();
//NOTE, EACH CROW HAS AN ARRAY OF STOMACH CONTENTS
    public Crow(String name) {
        this.name = name;
        fillCrowsStomach();
    }

    private void fillCrowsStomach() {
        for (int i = 0; i < 10; i++)
            this.stomachContents.add(getRandomCrowFood());
    }

    private String getRandomCrowFood() {
        int randomness = new Random().nextInt(4);
        if (randomness == 0) return "carrion";
        else if (randomness == 1)return "snail";
        else if (randomness == 2)return "acorn";
        else if (randomness == 3)return "spider";
        else return "grub";
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getStomachContents() {
        return stomachContents;
    }
}
