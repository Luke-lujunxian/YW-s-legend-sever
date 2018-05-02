//it can only be used at the end of the middle turn
public class Skill_yw_BloodPress extends Skill{
    String new_name;
    int new_power;
    String new_description;
    Personage new_owner;
    public Skill_yw_BloodPress(int power,Personage new_owner){
        super(new_owner);
        new_name = "BloodPress";
        new_power = this.power;
        new_description = "一个技能";
        new_owner = this.new_owner;
    }
    public void selfHurting() {
        ((Personage)owner).setBlood(((Personage) owner).getBlood()-3);
    }
}
