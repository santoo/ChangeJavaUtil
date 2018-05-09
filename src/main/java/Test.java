import java.util.List;

public class Test {

    public static final String SAMPLE_XLSX_FILE_PATH = "/home/santoo/Downloads/test/src/main/resources/sample.xlsx";
    public static final String SAMPLE_TEXT_FILE_PATH = "/home/santoo/Downloads/test/src/main/resources/Test.txt";
    public static final String SAMPLE_JAVA_FILE_PATH = "/home/santoo/Downloads/test/src/main/resources/Hello.java";
    public  static void main(String args[]){

        //Read Text;
        TextFileUtility readTextFile=new TextFileUtility(SAMPLE_TEXT_FILE_PATH);
        List<TextFile> parsedTextList=readTextFile.parseTextFile();

        //Read Excel
        ExcelFileUtility excelFileUtility=new ExcelFileUtility(SAMPLE_XLSX_FILE_PATH);
        JavaFIleUtility javaFIleUtility =new JavaFIleUtility(SAMPLE_JAVA_FILE_PATH);

        for(TextFile textFile:parsedTextList){
           System.out.println(excelFileUtility.getValueByKey(textFile.getMessage()));
            System.out.println(textFile.getMessage());

            javaFIleUtility.replaceLine(textFile.getLineNumber(),excelFileUtility.getValueByKey(textFile.getMessage()),textFile.getMessage());
        }

    }


}
