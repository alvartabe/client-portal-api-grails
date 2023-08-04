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
        // get the loggedInUser
        def loggedInUser = springSecurityService.currentUser

        // find all the users except loggedInUser
        def users = User.findAll {
            ne('id', loggedInUser.id)
        }

        // Get the field to sort on from the params
        String sortBy = params.sortBy ?: 'id'

        // Dynamic sorting based on the provided sortBy
        users.sort { it[sortBy] }

        // Optionally reverse the list if sortOrder is 'desc'
        users = params.sortOrder == 'desc' ? users.reverse() : users

        render users as JSON;
    }

// TODO: return logged user
//    @Secured("ROLE_ADMIN")
//    def index() {
//        def loggedInUser = springSecurityService.currentUser
//        render loggedInUser;
//    }
}
