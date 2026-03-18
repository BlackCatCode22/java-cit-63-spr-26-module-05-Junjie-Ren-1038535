package Module5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tiger extends Animal{
    public static int tigerCount = 0;
    Tiger(int age, String sex, String specie, String color, double weight, String birthday, String name, String origin, String country){
        super(age, sex, specie, color, weight, birthday, name, origin, country);
        tigerCount ++;
    }
    public String animalNoise(){
        List<String> noises = new ArrayList<>(3);
        noises.add("MEOWWWW");
        noises.add("Meow");
        noises.add("Meowmeowmeow");
        Random rand = new Random();
        int randNumber = Math.abs(rand.nextInt());
        int determineNoise = randNumber%3;
        return noises.get(determineNoise);
    }
}
