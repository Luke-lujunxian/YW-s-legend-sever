public class CommunicationStandard {
    private static String importData="";
    public static String outputDataForm(String[] new_importData){
        for(int i=0;i<new_importData.length;i++){
            if(i<new_importData.length-1) importData+=new_importData[i]+"\u00A1";
            else importData+=new_importData[i];
        }
        return importData;
    }

}
