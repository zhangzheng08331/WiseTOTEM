package wisetman

class WebsiteNavigation {
    Integer websiteid
    String websiteName
    String websiteURL
    String websiteAbstract
    Integer orderID

    static constraints = {

    }
    static mapping = {
        cache true
        table 'WebsiteNavigation'
        version false
        id generator: 'identity', name: 'websiteid'

        websiteid column: 'id'
        websiteName column: 'websiteName'
        websiteURL column: 'websiteURL'
        websiteAbstract column: 'websiteAbstract'
        orderID column: 'orderID'

    }
}
