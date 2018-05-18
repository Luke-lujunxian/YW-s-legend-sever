public class Personage_UndefinedSpecies_UndefinedReligion_UndefinedName extends Personage{
    private int power;
    private int HP;
    private int currentHP;
    private int ATK;
    private Skill firstSkill, secondSkill;
    private String name;

    Personage_UndefinedSpecies_UndefinedReligion_UndefinedName(){
        power=0;
        HP=60;
        currentHP=60;
        ATK=0;
        firstSkill = SkillFactory.createSkill(29,this,null,null);
        secondSkill = SkillFactory.createSkill(30,this,null,null);
        name="Undefinedname";
    }

}
