public class CommunicationStandard {
    String importData;
    public CommunicationStandard(){
        importData=null;
    }
    public CommunicationStandard(String[] new_importData){
        outputDataForm(new_importData);
        importData=outputDataLength(importData).concat(importData);
    }
    private void outputDataForm(String[] new_importData){
        for(int i=0;i<new_importData.length;i++){
            if(i<new_importData.length-1) importData+=new_importData[i]+"\u00A1";
            else importData+=new_importData;
        }
    }
    private String outputDataLength(String operated_importData){
        int lengthTemp=operated_importData.length();
        String dataLength="";
        for(int i=0;i<4;i++){
            if(lengthTemp!=0){
                dataLength+=(lengthTemp%10);
                lengthTemp/=10;
            }else{
                dataLength+=0;
            }
        }
        return dataLength;
    }
}
