package client.portal.api.grails

import grails.plugin.springsecurity.annotation.Secured
import grails.rest.*
import grails.converters.*
import grails.plugin.springsecurity.SpringSecurityService

class UserController  {
    static responseFormats = ['json']
    def springSecurityService

    @Secured("ROLE_ADMIN")
    def index() {
        def loggedInUser = springSecurityService.currentUser
        def users = User.findAll {
            ne('id', loggedInUser.id)
        }
        render users as JSON;
    }
}
