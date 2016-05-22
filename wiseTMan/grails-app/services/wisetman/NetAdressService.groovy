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
        pUtil.getDataFromExcel("D:\\wise\\websiteNavigate.xlsx")
    }
    /**
     * 根据ID删除网址
     */
    def deleteNetAdress(){

    }


}
