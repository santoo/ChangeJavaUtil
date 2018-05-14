import java.util.HashMap;
import java.util.List;

public class Test {

    public static final String SAMPLE_XLSX_FILE_PATH = "/home/santoo/ChangeJavaUtil-master/src/main/resources/final.xlsx";
    public static final String SAMPLE_XLSX_FILE_PATH2 = "/home/santoo/ChangeJavaUtil-master/src/main/resources/codes.xlsx";
    public static final String SAMPLE_TEXT_FILE_PATH = "/home/santoo/ChangeJavaUtil-master/src/main/resources/Test.txt";
    public static final String SAMPLE_JAVA_FILE_PATH = "/home/santoo/ChangeJavaUtil-master/src/main/resources/Hello.java";
    public  static void main(String args[]){

        //Read Text;
        TextFileUtility readTextFile=new TextFileUtility(SAMPLE_TEXT_FILE_PATH);
        List<TextFile> parsedTextList=readTextFile.parseTextFile();

        //Read Excel
        ExcelFileUtility excelFileUtility=new ExcelFileUtility(SAMPLE_XLSX_FILE_PATH);
        ExcelFileUtility excelFileUtility2=new ExcelFileUtility(SAMPLE_XLSX_FILE_PATH2);
        JavaFIleUtility javaFIleUtility =new JavaFIleUtility(SAMPLE_JAVA_FILE_PATH);

        for(TextFile textFile:parsedTextList){
           System.out.println("KEY==>"+excelFileUtility.getValueByKey(textFile.getMessage()));
            System.out.println(textFile.getMessage());
            if (excelFileUtility.getValueByKey(textFile.getMessage()).equalsIgnoreCase("")){
                String randomKey="TTS";//textFile.getModuleName().substring(0,3)+"_"+textFile.getSubModuleName().substring(0,3)+"_"+System.currentTimeMillis() % 1000;
                HashMap<String,String> productInfo=excelFileUtility2.getAllValueByKey(textFile.getMessage());
               System.out.println("produc==>"+productInfo);
                excelFileUtility.storeInSheet(randomKey,textFile.getMessage(),productInfo.get("product"),productInfo.get("sub_product"));
                System.out.println("generated key:"+randomKey);
                javaFIleUtility.replaceLine(textFile.getLineNumber(),excelFileUtility.getValueByKey(textFile.getMessage()),textFile.getMessage());
            }else {
                javaFIleUtility.replaceLine(textFile.getLineNumber(),excelFileUtility.getValueByKey(textFile.getMessage()),textFile.getMessage());
            }

        }

    }


}
