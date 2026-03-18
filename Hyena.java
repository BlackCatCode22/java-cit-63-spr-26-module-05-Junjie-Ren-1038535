package Module5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hyena extends Animal{
    public static int hyenaCount = 0;
    Hyena(int age, String sex, String specie, String color, double weight, String birthday, String name, String origin, String country){
        super(age, sex, specie, color, weight, birthday, name, origin, country);
        hyenaCount ++;
    }
    public String animalNoise(){
        List<String> noises = new ArrayList<>(3);
        noises.add("YEEEEEEE");
        noises.add("Yaaaaaaaa");
        noises.add("yeeeeaaaayeyeyeaaaaaaaaaa");
        Random rand = new Random();
        int randNumber = Math.abs(rand.nextInt());
        int determineNoise = randNumber%3;
        return noises.get(determineNoise);
    }
}
