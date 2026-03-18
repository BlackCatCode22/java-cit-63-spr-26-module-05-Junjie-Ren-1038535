package Module5;

public class Animal {
    private int age;
    private String sex;
    private String specie;
    private String color;
    private double weight;
    private String birthday;
    private String name;
    private String origin;
    private String country;
    Animal(int age, String sex, String specie, String color, double weight, String birthday, String name, String origin, String country){
        this.age = age;
        this.sex = sex;
        this.specie = specie;
        this.color = color;
        this.weight = weight;
        this.birthday = birthday;
        this.name = name;
        this.origin = origin;
        this.country = country;
    }
    Animal(){
        this(5, "Male", "Hyena", "Blue", 2000.25, "2021-01-01", "NotHyena", "Wilderness", "Alaska");
    }
    public void setOrigin(String origin){
        this.origin = origin;
    }
    public String getOrigin(){
        return origin;
    }
    public void setCountry(String country){
        this.country = country;
    }
    public String getCountry(){
        return country;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getSex(){
        return sex;
    }
    public void setBirthday(String birthday){
        this.birthday = birthday;
    }
    public String getBirthday(){
        return birthday;
    }
    public void setColor(String color){
        this.color = color;
    }
    public String getColor(){
        return color;
    }
    public void setWeight(double weight){
        this.weight = weight;
    }
    public double getWeight(){
        return weight;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
    public void setSpecie(String specie){
        this.specie = specie;
    }
    public String getSpecie(){
        return specie;
    }
}
