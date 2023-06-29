package client.portal.api.grails

import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured
import grails.rest.*
import grails.converters.*

@Transactional
class RegisterController {

    static allowedMethods = [save: "POST"]

    @Secured("permitAll")
    def save(User user) {
        if(user.validate()) {
            user.save(flush: true, failOnError: true)
            render user as JSON
        } else {
            render 'error'
        }
    }
}
