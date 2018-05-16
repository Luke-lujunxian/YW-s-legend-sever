public class SkillFactory {


    public static Skill createSkill(int type, Character target1, Character target2, Creature target3) {
        /*
        target1 target2 target3 三个目标来供修改
        若不需要则传入null
         */


        switch (type) {


//下方开始是唤魔
            /*
            鲜血榨汁机 唤魔 械宗 （25/0/3/0） 每个中回合结束时对自己的人物造成三点伤害，并获得50点能量
            */
            case 0: return new ChangeCurrentHP(new ChangePower(new BasicSkill(0,target1),50),-3);

            /*
           	奇怪的祭坛 唤魔 神宗 （75/0/3/0） 在己方回合每牺牲一个友方随从，便获得50点能量（最多牺牲五个）
            */
            case 1: return new ChangePower(new BasicSkill(0,target1),50);

            /*
           	邪能收集台 唤魔 法宗 （25/0/5/0）每个中回合结束时，获得25点能量
            */
            case 2: return new ChangePower(new BasicSkill(0,target1),25);

            /*
           	淘气的小鬼 唤魔 械宗 （25/2/1/2） 战吼：指定一个友方所从，对其造成两点伤害
            */
            case 3: return new ChangeHP(new BasicSkill(0,target1),-2);

            /*
           	嗜血者 唤魔 神宗 （200/5/5/2-3） 战吼：对所有角色造成一点伤害，每有一个角色死亡则获得攻击力加一血加一
            */
            case 4: return new ChangeHP(new ChangeATK(new BasicSkill(0,target1),1),1);

            /*
           	被诅咒的封印 唤魔 神宗（500/0/25/0）在回合结束时若己方人物血量正好等于五点，则杀死友方人物，将其替代为造物者
            */
            //case 5: return new ;

            /*
           	地狱之门 唤魔 法宗 （300/0/0/0）战吼：以自己为中心3x3的范围内，对所有角色造成三点伤害
            */
            case 6: return new CreateCreature(new BasicSkill(0,target1),target3);

            /*
           	替死冤魂 唤魔 法宗 （300/4/10/2-3）战吼：选择一个友方yw，若该yw在敌方回合死亡，则使替死幽魂死亡，友方yw复原原来血量的一半（四舍五入）
            */
            case 7: return new ChangeHP(new BasicSkill(0,target1),((yw)target1).get("HP")/2);

            /*
           	吞噬者的巢穴 唤魔 法宗（350/0/0/0） 战吼：在友方军团3x3的范围内，选择一个战场上的格子，将吞噬者的巢穴放在上面（用不可视），
           	若有地方军团走到上面，则会召唤系统人物吞噬者，20血，自带5点攻击，且军团里有两只（25/3/2/2）的yw，每个中回合放一只（25/3/2/2）的yw，
           	并选择攻击最近的人物
            */
            case 8: return new CreateCreature(new BasicSkill(0,target1),target3);

            /*
           	梦魇巨怪 唤魔 神宗（175/7/12/2-3）每个中回合结束时，对自己造成4点伤害
            */
            case 9: return new ChangeHP(new BasicSkill(0,target1),-4);

            /*
           	凋谢的恶魔之花 唤魔 械宗（125/5/5/2-3）亡语:使所有友方角色恢复六点血
            */
            case 10: return new ChangeHP(new BasicSkill(0,target1),6);

            /*
           	被折磨的弃教者 唤魔 械宗（100/2/10/2-3）该随从每受到一次伤害，就随机对一个非友方角色造成两点伤害
            */
            case 11: return new ChangeHP(new BasicSkill(0,target1),-2);








//下方开始是潜行
            /*
           	被诅咒的封印 潜行 神宗（500/0/25/0）在回合开始时，己方军团格子上有两只需消耗500能量以上的一模一样的yw（能量/攻击/血/攻击距离），
           	则杀死友方人物，将其替代为模仿者
            */
            //case 12: return new ;

            /*
           	禁忌的瞳术 潜行 神宗 （200/0/25/0）将你的第二技能换为消耗25点的一段瞳术，以自己为起点选择一排或是一列在这个中回合中可视所有这些格子上的内容。
           	若在己方回合杀死两个己方随从，则升级为消耗25点的二段瞳术，可视所有以自己为中心3x3范围内所有格子。若在己方回合再杀死两个己方随从，则升级为消耗
           	25点的三段瞳术，可视所有格子
            */
            //case 13: return new ;

            /*
           	傀儡·爱 潜行 械宗（125/3/10/2-5）战吼：若傀儡恨在场上，则使一个有方角色恢复5点血
            */
            case 14: return new CreateCreature(new BasicSkill(0,target1),target3);

            /*
           	被诅咒的封印 唤魔 神宗（500/0/25/0）在回合结束时若己方人物血量正好等于五点，则杀死友方人物，将其替代为造物者
            */
            //case 5: return new ;

            /*
           	被诅咒的封印 唤魔 神宗（500/0/25/0）在回合结束时若己方人物血量正好等于五点，则杀死友方人物，将其替代为造物者
            */
            //case 5: return new ;

            /*
           	被诅咒的封印 唤魔 神宗（500/0/25/0）在回合结束时若己方人物血量正好等于五点，则杀死友方人物，将其替代为造物者
            */
            //case 5: return new ;

            /*
           	被诅咒的封印 唤魔 神宗（500/0/25/0）在回合结束时若己方人物血量正好等于五点，则杀死友方人物，将其替代为造物者
            */
            //case 5: return new ;

            /*
           	被诅咒的封印 唤魔 神宗（500/0/25/0）在回合结束时若己方人物血量正好等于五点，则杀死友方人物，将其替代为造物者
            */
            //case 5: return new ;

            /*
           	被诅咒的封印 唤魔 神宗（500/0/25/0）在回合结束时若己方人物血量正好等于五点，则杀死友方人物，将其替代为造物者
            */
            //case 5: return new ;

            /*
           	被诅咒的封印 唤魔 神宗（500/0/25/0）在回合结束时若己方人物血量正好等于五点，则杀死友方人物，将其替代为造物者
            */
            //case 5: return new ;

            /*
           	被诅咒的封印 唤魔 神宗（500/0/25/0）在回合结束时若己方人物血量正好等于五点，则杀死友方人物，将其替代为造物者
            */
            //case 5: return new ;

            /*
           	被诅咒的封印 唤魔 神宗（500/0/25/0）在回合结束时若己方人物血量正好等于五点，则杀死友方人物，将其替代为造物者
            */
            //case 5: return new ;

            /*
           	被诅咒的封印 唤魔 神宗（500/0/25/0）在回合结束时若己方人物血量正好等于五点，则杀死友方人物，将其替代为造物者
            */
            //case 5: return new ;

            /*
           	被诅咒的封印 唤魔 神宗（500/0/25/0）在回合结束时若己方人物血量正好等于五点，则杀死友方人物，将其替代为造物者
            */
            //case 5: return new ;
        }
        return null;
    }
}
