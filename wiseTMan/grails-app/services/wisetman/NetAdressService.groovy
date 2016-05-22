package wisetman

import web.Util.*

//@Transactional
class NetAdressService {

    def serviceMethod() {

    }
    /**
     * 获取所有网址
     */
    def getALLNetAdress(){
        List<WebsiteNavigation> list=WebsiteNavigation.getAll()
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
        POIUtil pUtil=new POIUtil()
        List<Map<Integer,Object>>  list=pUtil.getDataFromExcel("D:\\wise\\websiteNavigate.xlsx")
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
     * 根据ID删除网址
     */
    def deleteNetAdress(){

    }


}
