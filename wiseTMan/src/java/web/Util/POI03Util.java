package web.Util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by pc-1 on 2016/6/6.
 */
public class POI03Util extends POIUtil {
    private Workbook wookbook;

    public POI03Util(String filePath){
        FileInputStream fis =null;
        try
        {
            //获取一个绝对地址的流
            fis = new FileInputStream(filePath);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        String afterFix=filePath.split("\\.")[1];
        try
        {
            //2003版本的excel，用.xls结尾
            this.wookbook = new HSSFWorkbook(fis);//得到工作簿

        }
        catch (Exception ex)
        {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
    };
    public  List<Map<Integer,Object>> DataFromExcel(){
         return POICommon.getDataFromExcel(this.wookbook);
    }

}
