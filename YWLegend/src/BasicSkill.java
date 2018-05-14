public class BasicSkill implements Skill{
    private int power;
    private Personage owner;
    private Character target;

    public BasicSkill(int new_power, Character target){
        this.power=new_power;
        this.target=target;
    }
    //getter and setter
    public Personage getOwner() { return owner; }
    public void setOwner(Personage owner) { this.owner = owner; }
    public Character getTarget() { return target; }
    public void setTarget(Character target) { this.target = target; }
    public int getPower() {
        return power;
    }
    public void setPower(int power) {
        this.power = power;
    }
    //implement of Skill
    public void startSkill() {
        owner.set("power",owner.get("power")-power);
    }
}
