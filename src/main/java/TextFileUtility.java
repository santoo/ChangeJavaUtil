
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextFileUtility {
    private String path=null;
    public TextFileUtility(String path){
        this.path=path;
    }
    public List<TextFile> parseTextFile(){
        List<TextFile> parsedTextList=null;
       try{
           parsedTextList=new ArrayList<>();
           File file=new File(path);
           Scanner scanner = new Scanner(file).useDelimiter(System.lineSeparator());
           TextFile textFile=null;

           while (scanner.hasNextLine()){
               textFile = new TextFile();
               String[] line=scanner.nextLine().split("##");
                textFile.setJavaFileName(line[0].trim());
                textFile.setModuleName(line[1].trim());
                textFile.setSubModuleName(line[2].trim());
                textFile.setLineNumber(Long.valueOf(line[3].trim()));
                textFile.setMessage(line[4].trim());
                parsedTextList.add(textFile);
           }


       }catch (Exception e){
            e.printStackTrace();
       }
        return parsedTextList;
    }
}
