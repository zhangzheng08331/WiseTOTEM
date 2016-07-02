package wisetman
import grails.rest.*
/**
 * Created by zhangzheng on 2016/6/26.
 */
@Resource(uri='/books', formats=['json', 'xml'])
class School {
    Integer id
    String name
    String place
    String type
    String properties
    static constraints = {

    }
    static mapping = {
        cache true
        table 'school'
        version false
        id generator: 'assigned', name: 'id'

        id column: 'id'
        name column: 'name'
        place column: 'place'
        type column: 'type'
        properties column: 'properties'

    }

}
