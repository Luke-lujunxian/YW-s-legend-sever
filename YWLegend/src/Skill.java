public class Skill{
    protected String name;
    protected int power;
    protected Character owner;

    public Skill(String new_name, int new_power, Character new_owner){
        this.name=new_name;
        this.power=new_power;
        this.owner=new_owner;
    }

    public int getPower() {
        return power;
    }

    public String getName() {
        return name;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setName(String name) {
        this.name = name;
    }
}
