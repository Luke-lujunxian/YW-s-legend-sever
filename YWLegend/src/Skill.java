public class Skill implements Character {
    private String name;
    private int power;
    private String description;
    private Character owner;

    Skill(String new_name, int new_power, String new_description, Character new_owner){
        this.name=new_name;
        this.power=new_power;
        this.description=new_description;
        this.owner=new_owner;
    }


    public int getPower() {
        return power;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
