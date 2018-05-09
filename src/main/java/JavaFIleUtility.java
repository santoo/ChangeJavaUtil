import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JavaFIleUtility {
    private String path;
    public JavaFIleUtility(String path){
        this.path=path;
    }
    public void replaceLine(long lineNumber,String key,String value){
       try{
           List<String> fileContent = new ArrayList<>(Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8));

           for (int i = 0; i < fileContent.size(); i++) {
               if(i==lineNumber){
                   System.out.println("==>"+fileContent.get(i));
                   String lineString=fileContent.get(i);
                   lineString=lineString.replaceAll(value,key);
                   fileContent.set(i, lineString);
                   break;
               }

           }
           Files.write(Paths.get(path), fileContent, StandardCharsets.UTF_8);
       }catch (Exception e){
           e.printStackTrace();
       }
    }


    public void updateTextByLineNumber(String text,long lineNumber){

    }
}
