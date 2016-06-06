package web.Util;


import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;


/**
 * Created by pc-1 on 2016/6/6.
 */
public class POI07Util extends POIUtil {
    private Workbook wookbook;
    public POI07Util(String filePath){
        FileInputStream fis =null;
        // def wookbook = null;
        try
        {
            //获取一个绝对地址的流
            fis = new FileInputStream(filePath);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        try
        {
            //2007版本的excel，用.xlsx结尾

            this.wookbook = new XSSFWorkbook(fis);//得到工作簿
        } catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    };

    public  List<Map<Integer,Object>> DataFromExcel(){

       return  POICommon.getDataFromExcel(this.wookbook);
    }

}
