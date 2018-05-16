public class SkillFactory {
    /*
        Planning:
     */
    public static Skill createSkill(int type, Character target) {
        switch (type) {
            case 0: return new ChangeCurrentHP(new ChangePower(new BasicSkill(0,target),50),-3);
            //case 1: return new ;
            case 2: return new ChangePower(new BasicSkill(0,target),25);
            case 3: return new ChangeHP(new BasicSkill(0,target),-2);
        }
        return null;
    }
}
