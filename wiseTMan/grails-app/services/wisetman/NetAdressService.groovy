package wisetman

import groovy.sql.GroovyRowResult
import groovy.sql.Sql
import web.Util.*

//@Transactional
class NetAdressService{
    def dataSource

    /**
     * 整理网址
     */
    def serviceMethod() {
        def allweb=getALLNetAdress()
        def category=getCategory()

        Map<Integer,List<WebsiteNavigation>> map=new HashMap<Integer,List<WebsiteNavigation>>()
        List<WebsiteNavigation> list=null;
        category.each {cat->
            list=new ArrayList<WebsiteNavigation>()
            allweb.each {web->
                if(web.orderID==cat.orderid){
                    list.add(web)
                }
            }
            map.put(cat,list)
        }
        return map
    }

    /**
     * 获取所有网址
     */
    private List<WebsiteNavigation> getALLNetAdress(){
        List<WebsiteNavigation> list=WebsiteNavigation.findAll();
        return list
    }

    /**
     * 获取网址分类
     */
    private List<GroovyRowResult>  getCategory(){
        String hql="select orderid  from websitenavigation group by orderid"
        return  new Sql(dataSource).rows(hql)
    }
    /**
     * 更新所有网址
     */
    def updateNetAdress(){

    }

    /**
     * 批量插入网址
     */
    def insertNetAdress(){
        POIUtil pUtil=null;
        String filePath="D:\\wise\\websiteNavigate.xlsx"
        if(!filePath.endsWith(".xls")&&!filePath.endsWith(".xlsx"))
        {
            System.out.println("文件不是excel类型");
        }
        String afterFix=filePath.split("\\.")[1];
        if(afterFix.equals("xls")){
            pUtil=  new POI03Util(filePath)
        }else{
            pUtil=  new POI07Util(filePath)
        }
        List<Map<Integer,Object>>  list=pUtil.DataFromExcel()
        list.each { map->
            def websiteNavigation=new WebsiteNavigation()
            websiteNavigation.websiteAbstract=map.get(0)
            websiteNavigation.websiteName=map.get(1)
            websiteNavigation.websiteURL=map.get(2)
            websiteNavigation.orderID=(Integer)map.get(3)
            websiteNavigation.save()
        }

    }
    /**
     * 根据ID删除网址33333333
     */
    def deleteNetAdress(){

    }


}
