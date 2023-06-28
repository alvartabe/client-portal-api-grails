package client.portal.api.grails

import grails.plugin.springsecurity.annotation.Secured
import grails.rest.*
import grails.converters.*

class OrderController  {
    static responseFormats = ['json', 'xml']

    @Secured("permitAll")
    def index() {
        render 'hola'
    }
}
