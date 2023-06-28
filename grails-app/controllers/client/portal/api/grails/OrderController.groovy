package client.portal.api.grails

import grails.plugin.springsecurity.annotation.Secured
import grails.rest.*
import grails.converters.*
import grails.plugin.springsecurity.SpringSecurityService

class OrderController  {
    static responseFormats = ['json']
    def springSecurityService

    @Secured("ROLE_ADMIN")
    def index() {
        def loggedInUser = springSecurityService.currentUser
        render loggedInUser;
    }
}
