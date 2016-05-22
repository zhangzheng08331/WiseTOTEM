package web.Util;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by pc-1 on 2016/5/21.
 */
public class POIUtil {
    /**
     * 读取出filePath中的所有数据信息
     * @param filePath excel文件的绝对路径
     *
     */

    public static void getDataFromExcel(String filePath)
    {
        //String filePath = "E:\\123.xlsx";

        //判断是否为excel类型文件
        if(!filePath.endsWith(".xls")&&!filePath.endsWith(".xlsx"))
        {
            System.out.println("文件不是excel类型");
        }

        FileInputStream fis =null;
        // def wookbook = null;
        Workbook wookbook =null;
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
            //2003版本的excel，用.xls结尾
            wookbook = new HSSFWorkbook(fis);//得到工作簿

        }
        catch (Exception ex)
        {
            //ex.printStackTrace();
            try
            {
                //2007版本的excel，用.xlsx结尾

                wookbook = new XSSFWorkbook(fis);//得到工作簿
            } catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        //得到一个工作表
        Sheet sheet = wookbook.getSheetAt(0);

        //获得表头
        Row rowHead = sheet.getRow(0);

        //判断表头是否正确
        if(rowHead.getPhysicalNumberOfCells() != 5)
        {
            System.out.println("表头的数量不对!");
        }

        //获得数据的总行数
        int totalRowNum = sheet.getLastRowNum();

        //要获得属性
        String name = "";
        int latitude = 0;

        //获得所有数据
        for(int i = 1 ; i <= totalRowNum ; i++)
        {
            //获得第i行对象
            Row row = sheet.getRow(i);

            //获得获得第i行第0列的 String类型对象
            Cell cell = row.getCell((short)0);
            name = cell.getStringCellValue().toString();

            //获得一个数字类型的数据
            cell = row.getCell((short)1);
            latitude = (int) cell.getNumericCellValue();

            System.out.println("名字："+name+",经纬度："+latitude);

        }
    }
}
