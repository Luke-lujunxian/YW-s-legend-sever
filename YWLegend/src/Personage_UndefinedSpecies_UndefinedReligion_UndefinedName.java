public class Personage_UndefinedSpecies_UndefinedReligion_UndefinedName extends Personage{
    private int power;
    private int HP;
    private int currentHP;
    private int ATK;
    private Skill firstSkill, secondSkill;
    private String IDname;
    private String name;
    private String skillInitializedTime1="";//StartRound, InRound, EndRound
    private String skillInitializedTime2="";//StartRound, InRound, EndRound

    Personage_UndefinedSpecies_UndefinedReligion_UndefinedName(String new_IDname){
        power=0;
        HP=60;
        currentHP=60;
        ATK=0;
        firstSkill = SkillFactory.createSkill(29,this,null,null);
        secondSkill = SkillFactory.createSkill(30,this,null,null);
        IDname=new_IDname;
        name="Undefined";
        skillInitializedTime1="InRound";
        skillInitializedTime2="StartRound";
    }

}
