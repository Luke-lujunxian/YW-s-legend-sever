
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
            case 0: return new ChangeCurrentHP(new ChangePower(new BasicSkill(0, target1), 50), -3);

            /*
            奇怪的祭坛 唤魔 神宗 （75/0/3/0） 在己方回合每牺牲一个友方随从，便获得50点能量（最多牺牲五个）
            */
            case 1: return new ChangePower(new BasicSkill(0, target1), 50);

            /*
            邪能收集台 唤魔 法宗 （25/0/5/0）每个中回合结束时，获得25点能量
            */
            case 2: return new ChangePower(new BasicSkill(0, target1), 25);

            /*
            淘气的小鬼 唤魔 械宗 （25/2/1/2） 战吼：指定一个友方所从，对其造成两点伤害
            */
            case 3: return new ChangeHP(new BasicSkill(0, target1), -2);

            /*
            嗜血者 唤魔 神宗 （200/5/5/2-3） 战吼：对所有角色造成一点伤害，每有一个角色死亡则获得攻击力加一血加一
            */
            case 4: return new ChangeHP(new ChangeATK(new BasicSkill(0, target1), 1), 1);

            /*
            被诅咒的封印 唤魔 神宗（500/0/25/0）在回合结束时若己方人物血量正好等于五点，则杀死友方人物，将其替代为造物者
            */
            //case 5: return new ;

            /*
            地狱之门 唤魔 法宗 （300/0/0/0）战吼：以自己为中心3x3的范围内，对所有角色造成三点伤害
            */
            case 6: return new CreateCreature(new BasicSkill(0, target1), target3);


            /*
           	替死冤魂 唤魔 法宗 （300/4/10/2-3）战吼：选择一个友方yw，若该yw在敌方回合死亡，则使替死幽魂死亡，友方yw复原原来血量的一半（四舍五入）
            */
            case 7: return new ChangeHP(new BasicSkill(0, target1), ((yw) target1).get("HP") / 2);

            /*
           	吞噬者的巢穴 唤魔 法宗（350/0/0/0） 战吼：在友方军团3x3的范围内，选择一个战场上的格子，将吞噬者的巢穴放在上面（用不可视），
           	若有地方军团走到上面，则会召唤系统人物吞噬者，20血，自带5点攻击，且军团里有两只（25/3/2/2）的yw，每个中回合放一只（25/3/2/2）的yw，
           	并选择攻击最近的人物
            */
            case 8: return new CreateCreature(new BasicSkill(0, target1), target3);

            /*
           	梦魇巨怪 唤魔 神宗（175/7/12/2-3）每个中回合结束时，对自己造成4点伤害
            */
            case 9: return new ChangeHP(new BasicSkill(0, target1), -4);


            /*
           	凋谢的恶魔之花 唤魔 械宗（125/5/5/2-3）亡语:使所有友方角色恢复六点血
            */
            case 10: return new ChangeHP(new BasicSkill(0, target1), 6);

            /*
           	被折磨的弃教者 唤魔 械宗（100/2/10/2-3）该随从每受到一次伤害，就随机对一个非友方角色造成两点伤害
            */
            case 11: return new ChangeHP(new BasicSkill(0, target1), -2);





//下方开始是潜行
            /*
           	被诅咒的封印 潜行 神宗（500/0/25/0）在回合开始时，己方军团格子上有两只需消耗500能量以上的一模一样的yw（能量/攻击/血/攻击距离），
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
            case 14: return new ChangeHP(new BasicSkill(0, target1), 5);

            /*
           	傀儡·恨 潜行 械宗（125/10/3/2-3）己方中回合结束时。若傀儡·爱在场上，则对其两边的yw分别造成三点伤害
            */
            case 15: return new ChangeHP(new BasicSkill(0, target1), -3);

            /*
           	傀儡·情 潜行 械宗（225/？/？/1-5）若傀儡·爱在场上，获得5攻击力，10血；若傀儡恨在场上则获得10攻，5血；若都没有，则获得6攻6血
            */
            //case 16: return new ;

            /*
           	迷雾释放者 潜行 法宗 （175/0/0/0）战吼：在以己为中心3x3的范围内，放置在战场上，成为一个角色，拥有十点血（不能移动），战场重新布回新的战争
           	迷雾，且迷雾只使所走过的最后三个格子可视。
            */
            case 17: return new CreateCreature(new BasicSkill(0, target1), target3);

            /*
           	暗影织布机 潜行 神宗 （175/0/0/0）战吼：在以己为中心3x3的范围内，放置成为一个角色，拥有十点血（不能移动），每个中回合结束时获得150点能量
            */
            case 18: return new CreateCreature(new BasicSkill(0, target1), target3);

            /*
           	尖锐的匕首 潜行 械宗（250/0/9/0）己方角色本中回合获得五点攻击，攻击距离为2-4
            */
            case 19: return new ChangeATK(new ChangeRange(new BasicSkill(0, target1), 2), 5);

            /*
           	小型青玉石 潜行 神宗 （25/0/4/0） 每个中回合开始时，获得50点能量
            */
            case 20: return new ChangePower(new BasicSkill(0, target1), 50);

            /*
           	飞刀陷阱 潜行 法宗（300/0/0/0）战吼：放置一个脚踏板拥有十五点血（不能移动），在同一排或同一列放置一个飞刀发射器拥有十五点血（不能移动），
           	若有人踩在脚踏板上，则发射器射中当在他路径上的第一个军团，整个军团的所有角色扣五滴血
            */
            case 21: return new CreateCreature(new BasicSkill(0, null), target3);

            /*
           	闪避术（停滞五回合） 潜行 法宗 （150/0/0/0）战吼： 在下个己方回合开始前，免疫三次对方的攻击（每攻击到一个yw或己方人物算一次）
           	被诅咒的封印 唤魔 神宗（500/0/25/0）在回合结束时若己方人物血量正好等于五点，则杀死友方人物，将其替代为造物者
            */
            //case 22: return new;

            /*
           	残影制造术（停滞五回合） 潜行 法宗 （150/0/0/0）战吼：在现在的格子上制造残影，若残影被视可视到，仍会显示释放时的所有信息，
           	在对方第一次攻击完时，则会消失
            */
            //case 23:;





//下方开始是undefined
            /*
           	FailTrial1 (25/0/3/0)每个中回合结束时，获得25点能量
            */
            case 24: return new ChangePower(new BasicSkill(0,target1),25);

            /*
            FailTrial2 (50/0/3/0)每个中回合开始时，获得50点能量
             */
            case 25: return new ChangePower(new BasicSkill(0,target1),50);

            /*
            FailTrial8 (100/2/3/2)每个中回合结束时，人物恢复3点血
            */
            case 26: return new ChangeHP(new BasicSkill(0,target1),3);

            /*
            1.FailTrial9 (100/5/6/2-3)每个中回合结束时，人物扣2点血
            */
            case 27: return new ChangeHP(new BasicSkill(0,target1),-2);

            /*
            FailTrial10 (500/0/0/0)消灭一个yw
            */
            case 28: return new BasicSkill(0,target1);

            /*
            种族别名：Undefined
            种族技能：人物攻击（耗费能量25）：人物获得2点攻击和2-3点攻击距离
            */
            case 29: return new ChangeATK(new ChangeRange(new BasicSkill(25,target1),2),2);

            /*
            种族别名：Undefined
            第二技能：人物回血（耗费能量25）：回两点血
            */
            case 30: return new ChangeHP(new BasicSkill(25,target1),2);


        }
        return null;
    }
}