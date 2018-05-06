//it can only be used at the end of the middle turn
public class Skill_yw_BloodPress extends Skill{
    public Skill_yw_BloodPress(int power,Personage new_owner){
        super("BloodPress",power,new_owner);
    }
    public void selfHurting() {
        ((Personage)owner).setBlood(((Personage) owner).getBlood()-3);
    }
}
