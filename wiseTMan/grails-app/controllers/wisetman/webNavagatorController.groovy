package wisetman

class WebNavagatorController {
    def NetAdressService
    def index() {
        Map<Integer,List<WebsiteNavigation>> map=NetAdressService.serviceMethod()
        render(view:"index",model: [websites: map])
    }

    //密
    def addWebsite(){
        NetAdressService.insertNetAdress()
    }

}
