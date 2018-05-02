//it can only be used at the end of the middle turn
public class Skill_yw_BloodPress extends Skill{
    public Skill_yw_BloodPress(String new_name, int new_power, String new_description, Personage new_owner){
        super(new_name,new_power,new_description,new_owner);
    }
    public void selfHurting() {
        ((Personage)owner).setBlood(((Personage) owner).getBlood()-3);
    }
}
