package web.Util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pc-1 on 2016/6/20.
 */
public class GetProductAndPrice {
    Map<String,String> map=new HashMap<String,String>();
    //获取商品集合
    public Map<String,String> getMap(){
        return this.map;
    }
    //设置商品名称，商品代码，单价，以及优惠方式
    public void setMap(String proName,String ProNo,String UnitPrice,String method){
        this.map.put(proName+"_"+ProNo+"_"+UnitPrice,method);
    }
    //
    public Map<String,List<String>> getOutPut(List<String> list, Map<String,String> map){
        Map<String,List<String>> map2=new HashMap<String,List<String>>();
        for(Map.Entry<String,String> entry:map.entrySet()){
            String[] keys=entry.getKey().split("_");
            for(String str:list){
                String[] strs=str.split("_");

                if(strs.length==2){

                    if(str.equals(keys[1])){
                        int count=Integer.parseInt(strs[1]);
                        for(int i=0;i<count;i++){
                            list.add(strs[0]);
                        }

                    }

                }else{
                    if(str.equals(keys[1])){
                            list.add(strs[0]);
                    }
                }
            }
            map2.put(keys[0]+"："+"单价："+keys[2]+"III"+entry.getValue(),list);

        }
        return map2;
    }

    public void test(){
        this.setMap("面包","p00001","5","");
        this.setMap("牛奶","p00002","8","买二送1");
        this.setMap("茄子","p00003","7","九折");
        Map<String,String> proMap=this.getMap();
        String[] strs={"p00001","p00002","p00001","p00001","p00003_4"};
        List<String> prolist = Arrays.asList(strs);
        Map<String,List<String>> map2=getOutPut(prolist, proMap);
        for(Map.Entry<String,List<String>> entry:map2.entrySet()){
            String[] pstrs=entry.getKey().split("III");
            String[] pstrs2=pstrs[0].split("_");
            int sizezz=Integer.parseInt(pstrs2[2]);
            if(pstrs.length==2){

                if("买二送1".equals(pstrs[1])){
                    //买二送一还没想出来
                    if(entry.getValue().size()%3==0){
                        int CC=entry.getValue().size()/3;
                        System.out.println(pstrs[0]+",数量:"+entry.getValue().size()+"小计："+sizezz*(entry.getValue().size()-CC));
                    }else{
                        int CC=(entry.getValue().size()-1)/3;
                        System.out.println(pstrs[0]+",数量:"+entry.getValue().size()+"小计："+sizezz*(entry.getValue().size()-CC));
                    }
                }else{
                    System.out.println(pstrs[0]+",数量:"+entry.getValue().size()+"小计："+sizezz*entry.getValue().size()*0.9);
                }
            }else{
                System.out.println(pstrs[0]+",数量:"+entry.getValue().size()+"小计："+sizezz*entry.getValue().size());
            }
        }
    }
}
