public class yw_BloodPress extends yw
{
        private Character character;
        public String name;
        private String phyle;
        public Skill skill;
        public Religions religion;
        private String saying;
        private int energy;
        private int blood;
        private int attack;
        private int attackRange;
        private int aRm;
        public yw_BloodPress(){
            name = "鲜血榨汁机";
            phyle = "唤魔";
            religion = new Reli_Machinism();
            energy = 25;
            attack = 0;
            blood = 3;
            attackRange = 0;
            aRm = attackRange;
            //ability 待实现
            saying = "我的乌玛，曙光已现";
            character = new Personage();
            skill = new Skill_yw_BloodPress(energy,(Personage) character);
        }
    }


