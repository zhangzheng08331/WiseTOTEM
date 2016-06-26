package wisetman
import grails.converters.*
class SchoolController {

    def index() {

    }

    def show() {
        if (params.id && School.exists(params.id)) {

            def p = School.findById(params.id)
            render p as XML
        }
        else {
            def all = School.list()
            render all as XML
        }
    }
}
