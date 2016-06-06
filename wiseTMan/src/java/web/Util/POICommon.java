package web.Util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pc-1 on 2016/6/6.
 */
public class POICommon {

    public static List<Map<Integer,Object>> getDataFromExcel(Workbook woobook){
        //String filePath = "";

        //判断是否为excel类型文件



        //得到一个工作表
        Sheet sheet = woobook.getSheetAt(0);

        //获得表头
        Row rowHead = sheet.getRow(0);

        //判断表头是否正确
        if(rowHead.getPhysicalNumberOfCells() != 4)
        {
            System.out.println("表头的数量不对!");
        }

        //获得数据的总行数
        int totalRowNum = sheet.getLastRowNum();

        //要获得属性
        String name = "";
        int latitude = 0;

        List<Map<Integer,Object>> list= new ArrayList<Map<Integer,Object>>();
        //获得所有数据
        for(int i = 1 ; i <= totalRowNum ; i++)
        {
            //获得第i行对象
            Map<Integer,Object> map=new HashMap<Integer,Object>();
            Row row = sheet.getRow(i);
            for(int j=0;j<4;j++){
                //获得获得第i行第0列的 String类型对象
                Cell cell = row.getCell((short)j);
                int cellType= cell.getCellType();
                Object vlue=null;
                switch (cellType){
                    case 0:vlue=cell.getNumericCellValue();break;
                    case 1:vlue=cell.getStringCellValue();break;
                    case 2:vlue=cell.getArrayFormulaRange();break;
                    case 3:vlue="";break;
                    case 4:vlue=cell.getBooleanCellValue();break;
                    default:vlue="" ;//如果所填写的内容非指定格式此处为空
                }
                map.put(j,vlue);

            }
            list.add(map);
        }
        return list;
    }
}
