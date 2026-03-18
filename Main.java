package Module5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import  java.util.*;
import  java.time.*;
public class Main{
    public static List<String> separateString(String s){
         return Arrays.asList(s.split(","));
    }
    public static int findAge(String s){
        // find the age of the animal.
        int firstSpace = s.indexOf(" ");
        String intPart = s.substring(0, firstSpace);
        return Integer.parseInt(intPart);
    } // helper function: find age
    public static String findSex(String s){
        if(s.contains("female")){
            return "female";
        } else if (s.contains("male")) {
            return "male";
        } else {
            return "Error During Finding the gender of the animal";
        }
    }// helper function: find sex
    public static String findSpecie(String s){
        String specie;
        // finding the specie of the animal
        if(s.contains("hyena")){
            specie = "hyena";
        } else if (s.contains("lion")) {
            specie = "lion";
        } else if (s.contains("bear")) {
            specie = "bear";
        } else if(s.contains("tiger")){
            specie = "tiger";
        } else{
            specie = "undefined";
        }
        return specie;
    }// helper function: find specie
    public static String findColor(String s){
        if(s.contains("color")) {
            return s.substring(1);
        }else {
            return "Error During Finding the color of the animal";
        }
    }// helper function: find color
    public static double findWeight(String s){
        int secondSpace = s.indexOf('p')-1;
        String doublePart = s.substring(1, secondSpace);
        return Double.parseDouble(doublePart);
    }// helper function: find weight
    public static String genBirthDay(String season, int age){
        //Spring is 1-3, Summer is 4-6, fall is 7-9, winter is 10-12
        Random rand = new Random();
        int random = Math.abs(rand.nextInt());
        int month = 1;
        int date = 1;
        if(season.contains("spring")){
            month = random % 3 + 1;
            if(month % 2 == 0) {//month is even and is feb
                date = random % 28 + 1;
            } else {
                date = random % 31 + 1;
            }
        }
        if(season.contains("summer")){
            month = random % 3 + 4;
            if(month % 2 == 0) {//month is even
                date = random % 30 + 1;
            } else {
                date = random % 31 + 1;
            }
        }
        if(season.contains("fall")){
            month = random % 3 + 7;
            if(month != 9) {//month is even
                date = random % 31 + 1;
            } else {
                date = random % 30 + 1;
            }
        }
        if(season.contains("winter")){
            month = random % 3 + 10;
            if(month % 2 == 0) {//month is even
                date = random % 31 + 1;
            } else {
                date = random % 30 + 1;
            }
        }
        LocalDate specificDate = LocalDate.of(2026-age, month, date);
        return specificDate.toString();
    }// helper function: get a bithday
    public static Animal create(String newAnimal, String name){
        List<String> lstring = separateString(newAnimal);
        String ageSpecieAndSex = lstring.get(0);
        String bornSeason = lstring.get(1);
        String colorInfo = lstring.get(2);
        String weightInfo = lstring.get(3);
        String origin = lstring.get(4);
        String originCountry = lstring.get(5).substring(1);
        // find the information of the animal
        int age = findAge(ageSpecieAndSex);
        String sex = findSex(ageSpecieAndSex);
        String specie = findSpecie(ageSpecieAndSex);
        String color = findColor(colorInfo);
        double weight = findWeight(weightInfo);
        String birthdate = genBirthDay(bornSeason, age);
        String animalOrigin = origin.substring(1);
        Animal e = new Animal(age, sex, specie, color, weight, birthdate, "n/a", animalOrigin, originCountry);
        return e;
    }// helper function: create animal object from string.
    public static void printInfo(ArrayList<Animal> animalList){
        try(PrintWriter report = new PrintWriter(new File("zooPopulation.txt"))){
            LocalDate today = LocalDate.of(2026, 3, 14);
            report.println(" ******* Zoo Population and Habitat Assignment Report ********");
            //specific type of animals list so we get to put animal object into it later
            ArrayList<Hyena> hlist = new ArrayList<>();
            ArrayList<Bear> blist = new ArrayList<>();
            ArrayList<Tiger> tlist = new ArrayList<>();
            ArrayList<Lion> llist = new ArrayList<>();
            //get the unique ids and put them to the corresponding arraylist
            ArrayList<ArrayList<String>> ids= genUniqueId(animalList);
            ArrayList<String> hyenaIds = ids.getFirst();
            ArrayList<String> lionIds = ids.get(1);
            ArrayList<String> tigerIds = ids.get(2);
            ArrayList<String> bearIds = ids.getLast();
            //Now we get the animals from animal arraylist and put them into their specific type of arraylist
            for(Animal e : animalList){
                if(e.getSpecie() == "hyena"){
                    Hyena newHyena = new Hyena(e.getAge(),e.getSex(),e.getSpecie(),e.getColor(),e.getWeight(),e.getBirthday(),e.getName(),e.getOrigin(),e.getCountry());
                    hlist.add(newHyena);
                }
                if(e.getSpecie() == "bear"){
                    Bear newBear = new Bear(e.getAge(),e.getSex(),e.getSpecie(),e.getColor(),e.getWeight(),e.getBirthday(),e.getName(),e.getOrigin(),e.getCountry());
                    blist.add(newBear);
                }
                if(e.getSpecie() == "tiger"){
                    Tiger newTiger = new Tiger(e.getAge(),e.getSex(),e.getSpecie(),e.getColor(),e.getWeight(),e.getBirthday(),e.getName(),e.getOrigin(),e.getCountry());
                    tlist.add(newTiger);
                }
                if(e.getSpecie() == "lion"){
                    Lion newLion = new Lion(e.getAge(),e.getSex(),e.getSpecie(),e.getColor(),e.getWeight(),e.getBirthday(),e.getName(),e.getOrigin(),e.getCountry());
                    llist.add(newLion);
                }

            }
            //prints out hyena section
            report.println("\nHyena Habitat: \n");
            for(Hyena e : hlist){
                String HyenaID = hyenaIds.getFirst();
                hyenaIds.removeFirst();
                report.printf("%s; %s years old; %s; birth Date: %s; %s; %s; %04.1f pounds; Noise: %s; %s, %s; arrived: %s%n",
                        HyenaID,
                        e.getAge(),
                        e.getName(),
                        e.getBirthday(),
                        e.getColor(),
                        e.getSex(),
                        e.getWeight(),
                        e.animalNoise(),
                        e.getOrigin(),
                        e.getCountry(),
                        today.toString()
                );
            }
            //lion section
            report.println("\nLion Habitat: \n");
            for(Lion e : llist){
                String LionID = lionIds.getFirst();
                lionIds.removeFirst();
                report.printf("%s; %s years old; %s; birth Date: %s; %s; %s; %04.1f pounds; Noise: %s; %s, %s; arrived: %s%n",
                        LionID,
                        e.getAge(),
                        e.getName(),
                        e.getBirthday(),
                        e.getColor(),
                        e.getSex(),
                        e.getWeight(),
                        e.animalNoise(),
                        e.getOrigin(),
                        e.getCountry(),
                        today.toString()
                );
            }
            //tiger section
            report.println("\nTiger Habitat: \n");
            for(Tiger e : tlist){
                String TigerID = tigerIds.getFirst();
                tigerIds.removeFirst();
                report.printf("%s; %s years old; %s; birth Date: %s; %s; %s; %04.1f pounds; Noise: %s; %s, %s; arrived: %s%n",
                        TigerID,
                        e.getAge(),
                        e.getName(),
                        e.getBirthday(),
                        e.getColor(),
                        e.getSex(),
                        e.getWeight(),
                        e.animalNoise(),
                        e.getOrigin(),
                        e.getCountry(),
                        today.toString()
                );
            }
            // bear section
            report.println("\nBear Habitat: \n");
            for(Bear e : blist){
                String BearID = bearIds.getFirst();
                bearIds.removeFirst();
                report.printf("%s; %s years old; %s; birth Date: %s; %s; %s; %04.1f pounds; Noise: %s; %s, %s; arrived: %s%n",
                        BearID,
                        e.getAge(),
                        e.getName(),
                        e.getBirthday(),
                        e.getColor(),
                        e.getSex(),
                        e.getWeight(),
                        e.animalNoise(),
                        e.getOrigin(),
                        e.getCountry(),
                        today.toString()
                );
            }
        }
        catch (IOException e){
            System.out.println("Failed to edit the file: newAnimals.txt");
        }
    }
    public static ArrayList<ArrayList<String>> genUniqueId(ArrayList<Animal> a) {
        ArrayList<ArrayList<String>> uniqueIds = new ArrayList<>();
        ArrayList<String> hyenaIds = new ArrayList<>();
        ArrayList<String> lionIds = new ArrayList<>();
        ArrayList<String> tigerIds = new ArrayList<>();
        ArrayList<String> bearIds = new ArrayList<>();

        int hyenaCount = 1;
        int LionCount = 1;
        int tigerCount = 1;
        int bearCount = 1;
        for(Animal e : a){
            if(e.getSpecie() == "hyena"){
                String HyenaIDPre = "Hy";
                String HyenaIDNum = String.format("%02d",hyenaCount);
                String HyenaID = HyenaIDPre + HyenaIDNum;
                hyenaIds.add(HyenaID);
                hyenaCount ++;
            }
            if(e.getSpecie() == "lion"){
                String LionIDPre = "Li";
                String LionIDNum = String.format("%02d",LionCount);
                String LionID = LionIDPre + LionIDNum;
                lionIds.add(LionID);
                LionCount ++;
            }
            if(e.getSpecie() == "tiger"){
                String TigerIDPre = "Ti";
                String TigerIDNum = String.format("%02d",tigerCount);
                String TigerID = TigerIDPre + TigerIDNum;
                tigerIds.add(TigerID);
                tigerCount++;
            }
            if (e.getSpecie() == "bear"){
                String BearIDPre = "Be";
                String BearIDNum = String.format("%02d",bearCount);
                String BearID = BearIDPre + BearIDNum;
                bearIds.add(BearID);
                bearCount++;
            }
        }
        uniqueIds.add(hyenaIds);
        uniqueIds.add(lionIds);
        uniqueIds.add(tigerIds);
        uniqueIds.add(bearIds);
        return uniqueIds;
    }
    // helper function: get an arraylist of arraylist of string unique id where each specie is given a list of unique id.


    public static void main(){
        try {
            Scanner cin = new Scanner(new File("arrivingAnimals.txt"));
            Scanner newName = new Scanner(new File("animalNames.txt"));
            ArrayList<String> Names = new ArrayList<String>();
            // adds all the names to the Names ArrayList.
            while (newName.hasNextLine()){
                Names.add(newName.next());
            }
            //separate them based on the specie.
            ArrayList<String> HyenaNames = new ArrayList<String>();
            ArrayList<String> LionNames = new ArrayList<String>();
            ArrayList<String> BearNames = new ArrayList<String>();
            ArrayList<String> TigerNames = new ArrayList<String>();
            // find where does each of the section of specie is in the main list and
            // we will extract the element value, then clean it by replacing the "," in the String
            // to a char. Then, we will trim the excess whitespace.
            for (int i = Names.indexOf("Hyena"); i < Names.indexOf("Lion"); i++){
                String mewName = Names.get(i);
                String CleanmewName = mewName.replace(",","").trim();
                HyenaNames.add(CleanmewName);
            }
            for (int i = Names.indexOf("Lion"); i < Names.indexOf("Bear"); i++){
                String mewName = Names.get(i);
                String CleanmewName = mewName.replace(",","").trim();
                LionNames.add(CleanmewName);
            }
            for (int i = Names.indexOf("Bear"); i < Names.indexOf("Tiger"); i++){
                String mewName = Names.get(i);
                String CleanmewName = mewName.replace(",","").trim();
                BearNames.add(CleanmewName);
            }
            for (int i = Names.indexOf("Tiger"); i < Names.size(); i++){
                String mewName = Names.get(i);
                String CleanmewName = mewName.replace(",","").trim();
                TigerNames.add(CleanmewName);
            }
            // removes the first 2 elements of each list, which are the specie name and "Name:"
            for(int i = 0; i < 2; i++) {
                HyenaNames.removeFirst();
                LionNames.removeFirst();
                BearNames.removeFirst();
                TigerNames.removeFirst();
            }
            // above it the end of the part where we place names into their respected specie's ArrayList

            //This is where we start placing animal stuff into Zoo.
            ArrayList<Animal> Zoo = new ArrayList<>();
            while (cin.hasNextLine()){
                //calls the data from the file and store it
                String newAnimal = cin.nextLine();
                //calls create, which takes in the data in the string above, and create the animal object
                Animal wowNewAnimal = create(newAnimal, "TempName");
                //place newly minted Animal object into zoo.
                Zoo.add(wowNewAnimal);
            }
            // checks what specie is in each animal object within the zoo
            // then we assign a unique name within the list of the respected specie to each individual object.
            for(Animal e : Zoo){
                if (e.getSpecie() == "hyena"){
                    e.setName(HyenaNames.getFirst());
                    HyenaNames.removeFirst();
                } else if (e.getSpecie() == "lion") {
                    e.setName(LionNames.getFirst());
                    LionNames.removeFirst();
                } else if (e.getSpecie() == "bear") {
                    e.setName(BearNames.getFirst());
                    BearNames.removeFirst();
                } else if (e.getSpecie() == "tiger") {
                    e.setName(TigerNames.getFirst());
                    TigerNames.removeFirst();
                }
            }
            //actual code that prints out to the file.
             printInfo(Zoo);
        }
        catch (FileNotFoundException e){
            System.out.println("File Not found!");
        }
    }
}