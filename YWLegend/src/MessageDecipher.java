import java.util.List;

public class MessageDecipher extends SubThread{
    public MessageDecipher(){

    }
    private static boolean Attack(Character attacter,Character endurer){
        endurer.set("currentHP",endurer.get("currentHP")-attacter.get("currentATK"));
    //    if(endurer.get("currentHP")<=0) return false;
     //   else return true;
        return endurer.get("currentHP")>0;
    }
    private static void ywPlacement(String new_ywName,SubThread A,int new_pos,List<yw> startRoundSkill,List<yw> endRoundSkill,SubThread target,int target_pos,SubThread B){
        yw ywla=null;
        if(new_ywName.equals("FailTrial1")){
            ywla=new yw_FailTrial1(A.myLegion.getLeader());
        }
        if(new_ywName.equals("FailTrial2")){
            ywla=new yw_FailTrial2(A.myLegion.getLeader());
        }
        if(new_ywName.equals("FailTrial3")){
            ywla=new yw_FailTrial3();
        }
        if(new_ywName.equals("FailTrial4")){
            ywla=new yw_FailTrial4();
        }
        if(new_ywName.equals("FailTrial5")){
            ywla=new yw_FailTrial5();
        }
        if(new_ywName.equals("FailTrial6")){
            ywla=new yw_FailTrial6();
        }
        if(new_ywName.equals("FailTrial7")){
            ywla=new yw_FailTrial7();
        }
        if(new_ywName.equals("FailTrial8")){
            ywla= new yw_FailTrial8(A.myLegion.getLeader());
        }
        if(new_ywName.equals("FailTrial9")){
            ywla= new yw_FailTrial9(A.myLegion.getLeader());
        }
        if(new_ywName.equals("FailTrial10")){
            ywla= new yw_FailTrial10();
            A.myLegion.setCharacters(ywla,new_pos);
            if(ywla.getSkillInitializedTime().equals("StartRound")) startRoundSkill.add(ywla);
            else if(ywla.getSkillInitializedTime().equals("InRound")){
                ywla.skill(target.myLegion.getCharacters()[target_pos]);
                try {
                    Player_1.writeMsgToClient(A.getConnection().getOutputStream(),"SkillActivate"+"\u00A1"+target.myLegion.getLeader().getIDname()+"\u00A1"+target_pos);
                    Player_2.writeMsgToClient(B.getConnection().getOutputStream(),"SkillActivate"+"\u00A1"+target.myLegion.getLeader().getIDname()+"\u00A1"+target_pos);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            else if(ywla.getSkillInitializedTime().equals("EndRound")) endRoundSkill.add(ywla);
        }
        if(new_ywName.equals("FailTrial11")){
            ywla= new yw_FailTrial11();
        }
        if(new_ywName.equals("FailTrial12")){
            ywla= new yw_FailTrial12();
        }
        A.myLegion.setCharacters(ywla,new_pos);
        if(ywla.getSkillInitializedTime().equals("StartRound")) startRoundSkill.add(ywla);
        else if(ywla.getSkillInitializedTime().equals("InRound"))ywla.skill();
        else if(ywla.getSkillInitializedTime().equals("EndRound")) endRoundSkill.add(ywla);
    }
    /*
    * 可能以后要传ywList
    * */
    public static void decipher(String[] code,SubThread A,SubThread B,List<yw> startRoundSkill,List<yw> endRoundSkill){

            if(!code[0].equals("ActivatePersonageSkill")) {
                String[] returnArray=new String[code.length];
                if(code[0].equals("ywPlacement")){
            returnArray[0]="displayYwPlacement";
            if(code[1].equals(A.myLegion.getLeader().getIDname())){
                int yw_pos=Integer.valueOf(code[3]);
                if(code.length==4)ywPlacement(code[2],A,yw_pos,startRoundSkill,endRoundSkill,null,0,null);
                if(code.length==6){
                    if(code[4].equals(A.myLegion.getLeader().getIDname())){
                        int yw_pos2=Integer.valueOf(code[5]);
                        ywPlacement(code[2],A,yw_pos,startRoundSkill,endRoundSkill,A,yw_pos2,B);
                    }else{
                        int yw_pos2=Integer.valueOf(code[5]);
                        ywPlacement(code[2],A,yw_pos,startRoundSkill,endRoundSkill,B,yw_pos2,A);
                    }
                }
                returnArray[1]=A.myLegion.getLeader().getIDname();
                returnArray[2]=yw_pos+"";
            }
        }
        else if(code[0].equals("Attack")){
            returnArray[0]="displayAttack";
            if(code[1].equals(A.myLegion.getLeader().getIDname())){
                if(code[2].equals("999")){
                    if(code[3].equals(A.myLegion.getLeader().getIDname())){
                        if(code[4].equals("999")){
                            Character a=A.myLegion.getLeader();
                            Character b=A.myLegion.getLeader();
                            Attack(a,b);
                            returnArray[5]=b.get("currentHP")+"";
                            returnArray[6]=1+"";
                        }else{
                            int yw_pos_1=Integer.valueOf(code[4]);
                            Character a=A.myLegion.getLeader();
                            Character b=A.myLegion.getCharacters()[yw_pos_1];
                            if(!Attack(a,b)) A.myLegion.getCharacters()[yw_pos_1]=new yw();
                            returnArray[5]=b.get("currentHP")+"";
                            returnArray[6]=1+"";
                            if(!Attack(a,b)) returnArray[6]=0+"";

                        }

                    }else{
                        if(code[4].equals("999")){
                            Character a=A.myLegion.getLeader();
                            Character b=B.myLegion.getLeader();
                            Attack(a,b);
                            returnArray[5]=b.get("currentHP")+"";
                            returnArray[6]=1+"";
                        }else{
                            int yw_pos_1=Integer.valueOf(code[4]);
                            Character a=A.myLegion.getLeader();
                            Character b=B.myLegion.getCharacters()[yw_pos_1];
                            if(!Attack(a,b))B.myLegion.getCharacters()[yw_pos_1]=new yw();
                            returnArray[5]=b.get("currentHP")+"";
                            returnArray[6]=1+"";
                            if(!Attack(a,b)) returnArray[6]=0+"";
                        }

                    }
                }
                else {
                    int yw_pos=Integer.valueOf(code[2]);
                    if(code[3].equals(A.myLegion.getLeader().getIDname())){
                        if(code[4].equals("999")){
                            Character a=A.myLegion.getCharacters()[yw_pos];
                            Character b=A.myLegion.getLeader();
                            Attack(a,b);
                            returnArray[5]=b.get("currentHP")+"";
                            returnArray[6]=1+"";
                        }else{
                            int yw_pos_1=Integer.valueOf(code[4]);
                            Character a=A.myLegion.getCharacters()[yw_pos];//lalala
                            Character b=A.myLegion.getCharacters()[yw_pos_1];
                            if(!Attack(a,b)) A.myLegion.getCharacters()[yw_pos_1]=new yw();
                            returnArray[5]=b.get("currentHP")+"";
                            returnArray[6]=1+"";
                            if(!Attack(a,b)) returnArray[6]=0+"";
                        }
                    }else{
                        if(code[4].equals("999")){
                            Character a=A.myLegion.getCharacters()[yw_pos];
                            Character b=B.myLegion.getLeader();
                            Attack(a,b);
                            returnArray[5]=b.get("currentHP")+"";
                            returnArray[6]=1+"";
                        }
                        int yw_pos_1=Integer.valueOf(code[4]);
                        Character a=A.myLegion.getCharacters()[yw_pos];
                        Character b=B.myLegion.getCharacters()[yw_pos_1];
                        if(!Attack(a,b)) B.myLegion.getCharacters()[yw_pos_1]=new yw();
                        returnArray[5]=b.get("currentHP")+"";
                        returnArray[6]=1+"";
                        if(!Attack(a,b)) returnArray[6]=0+"";
                    }
                }
            }
            returnArray[1]=A.myLegion.getLeader().getIDname();
            returnArray[2]=code[2];
            returnArray[3]=B.myLegion.getLeader().getIDname();
            returnArray[4]=code[4];
            /*else{
                if(code[2].equals("999")){
                    if(code[3].equals(A.myLegion.getLeader().getIDname())){
                        Character a=B.myLegion.getLeader();
                        Character b=A.myLegion.getLeader();
                        Attack(a,b);
                    }else{
                        Character a=B.myLegion.getLeader();
                        Character b=B.myLegion.getLeader();
                        Attack(a,b);
                    }
                }
                else{
                    int yw_pos=Integer.valueOf(code[2]);
                    if(code[3].equals(A.myLegion.getLeader().getIDname())){
                        Character a=B.myLegion.getCharacters()[yw_pos];
                        Character b=A.myLegion.getCharacters()[yw_pos];
                        if(!Attack(a,b)) A.myLegion.getCharacters()[yw_pos]=new yw();
                    }else{
                        Character a=B.myLegion.getCharacters()[yw_pos];
                        Character b=B.myLegion.getCharacters()[yw_pos];
                        if(!Attack(a,b)) B.myLegion.getCharacters()[yw_pos]=new yw();
                    }
                }
            }*/
        }
        else if(code[0].equals("Moving")){
            returnArray[0]="displayMoving";
            returnArray[1]=A.myLegion.getLeader().getIDname();
            int pos_x=Integer.valueOf(code[1].substring(0,1));
            int pos_y=Integer.valueOf(code[1].substring(1,2));
            A.myLegion.changePosition(pos_x,pos_y);
            returnArray[2]=code[1];
        }
                try{
                    synchronized (B){
                        Player_1.writeMsgToClient(A.getConnection().getOutputStream(),outputDataForm(returnArray));
                        Player_2.writeMsgToClient(B.getConnection().getOutputStream(),outputDataForm(returnArray));
                        Player_1.writeMsgToClient(A.getConnection().getOutputStream(),"End");
                        Player_2.writeMsgToClient(B.getConnection().getOutputStream(),"End");
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
        }
        else {
            if(code[1].equals("1")){
                A.myLegion.getLeader().getFirstSkill().startSkill();
            }else if(code[1].equals("2")){
                A.myLegion.getLeader().getSecondSkill().startSkill();
            }
            try {
                Player_1.writeMsgToClient(A.getConnection().getOutputStream(),"SkillActivate"+"\u00A1"+A.myLegion.getLeader().getName()+"\u00A1"+"999");
                Player_2.writeMsgToClient(B.getConnection().getOutputStream(),"SkillActivate"+"\u00A1"+A.myLegion.getLeader().getName()+"\u00A1"+"999");
                Player_1.writeMsgToClient(A.getConnection().getOutputStream(),"End");
                Player_2.writeMsgToClient(B.getConnection().getOutputStream(),"End");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
