import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;

public class ExcelFileUtility {
    private String path;
    Workbook workbook;
    public ExcelFileUtility(String path){

        this.path=path;
        try{
             workbook = WorkbookFactory.create(new File(path));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public String getValueByKey(String key){

       try {

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

    public boolean storeInSheet(String key,String value,String prod,String subProd){
        Sheet sheet=workbook.getSheetAt(0);
        int rowNumber=sheet.getLastRowNum();
        sheet.shiftRows(0,rowNumber,1);
        Row row=sheet.createRow(1);
        row.createCell(0).setCellValue(key);
        row.createCell(1).setCellValue(value);
        row.createCell(2).setCellValue(prod);
        row.createCell(3).setCellValue(subProd);
        try{
            workbook.write(new FileOutputStream(path));
            workbook.close();
        }catch (Exception e){
            System.out.println("oooops");
            e.printStackTrace();
        }
        return false;
    }

    public HashMap<String, String> getAllValueByKey(String value){
        HashMap<String,String> resultMap=new HashMap<>();
        try {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row: sheet) {
                if(row.getCell(row.getFirstCellNum()+2).toString().equalsIgnoreCase(value)){
                    resultMap.put("product",row.getCell(row.getFirstCellNum()).toString());
                    resultMap.put("sub_product",row.getCell(row.getFirstCellNum()+1).toString());
                    resultMap.put("value",row.getCell(row.getFirstCellNum()+2).toString());
                    return  resultMap;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

}
