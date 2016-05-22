package wisetman

class NetAdressController {
    def NetAdressService
    def index() {
        NetAdressService.insertNetAdress()
        render(view:"index")
    }
}
