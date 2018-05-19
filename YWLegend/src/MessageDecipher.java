public class MessageDecipher extends SubThread{
    public MessageDecipher(){

    }
    public static void decipher(String[] code, Player_1 A,Player_2 B ){
        if(code[0].equals("ywPlacement")){
            if(code[1].equals(A.myLegion.getLeader().getIDname())){
                for(int i=0;i<A.myLegion.getCharacters().length;i++){
                    if(code[2].equals(A.myLegion.getCharacters()[i])){
                        int yw_pos=Integer.valueOf(code[3]);
                        A.myLegion.changeYwPosition(yw_pos);
                    }
                }
            }
            else{
                for(int i=0;i<B.myLegion.getCharacters().length;i++){
                    if(code[2].equals(B.myLegion.getCharacters()[i])){
                        int yw_pos=Integer.valueOf(code[3]);
                        B.myLegion.changeYwPosition(yw_pos);
                    }
                }
            }
        }else if(code[0].equals("Attack")){
            if(code[1].equals(A.myLegion.getLeader().getIDname())){
                if(code[2].equals("999")) ;
                else {
                    int yw_pos=Integer.valueOf(code[2]);
                    A.myLegion.getCharacters()[yw_pos].
                }
            }
            else{
                if(code[2].equals("999")) B.myLegion.getLeader();
                else{
                    int yw_pos=Integer.valueOf(code[2]);
                    B.myLegion.getCharacters()[yw_pos]
                }
            }
        }else if(code[0].equals("Moving")){

        }

    }
}
