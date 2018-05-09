import org.apache.poi.ss.usermodel.*;

import java.io.File;

public class ExcelFileUtility {
    private String path;
    public ExcelFileUtility(String path){
        this.path=path;
    }
    public String getValueByKey(String key){

       try {
           Workbook workbook = WorkbookFactory.create(new File(path));
           Sheet sheet = workbook.getSheetAt(0);
           for (Row row: sheet) {
               if(row.getCell(row.getFirstCellNum()+1).toString().equalsIgnoreCase(key)){
                    return row.getCell(row.getFirstCellNum()).toString();
               }
           }
       }catch (Exception e){
           e.printStackTrace();
       }

        return "";
    }

}
