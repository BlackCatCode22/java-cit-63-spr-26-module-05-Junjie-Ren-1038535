package Module5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bear extends Animal{
    public static int bearCount = 0;
    Bear(int age, String sex, String specie, String color, double weight, String birthday, String name, String origin, String country){
        super(age, sex, specie, color, weight, birthday, name, origin, country);
        bearCount ++;
    }

    public String animalNoise(){
        List<String> noises = new ArrayList<>(3);
        noises.add("Wahhhhhh");
        noises.add("WAHHHHH");
        noises.add("WaHhHhHARRRRRR");
        Random rand = new Random();
        int randNumber = Math.abs(rand.nextInt());
        int determineNoise = randNumber%3;
        return noises.get(determineNoise);
    }
}
