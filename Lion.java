package Module5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lion extends Animal{
    public static int lionCount = 0;
    Lion(int age, String sex, String specie, String color, double weight, String birthday, String name, String origin, String country){
        super(age, sex, specie, color, weight, birthday, name, origin, country);
        lionCount ++;
    }
    public String animalNoise(){
        List<String> noises = new ArrayList<>(3);
        noises.add("Roarrrrrrrrr");
        noises.add("RRRRRrrrrRRRRoaaaaaaarrrrrrr");
        noises.add("Roar");
        Random rand = new Random();
        int randNumber = Math.abs(rand.nextInt());
        int determineNoise = randNumber%3;
        return noises.get(determineNoise);
    }
}
