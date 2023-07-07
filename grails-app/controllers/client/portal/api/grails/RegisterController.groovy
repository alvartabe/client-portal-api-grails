package client.portal.api.grails
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured
import grails.converters.*

@Transactional
class RegisterController {

    static allowedMethods = [save: "POST"]

    @Secured("permitAll")
    def save(User user) {

        Role role = Role.findByAuthority('ROLE_ADMIN');
        if(!role) {
            render status: 400, 'Invalid Role', contentType: 'application/json'
            return
        }

        if(!user.validate() || user.hasErrors()) {
            render status: 400, user.errors as JSON, contentType: 'application/json'
            return
        }

        user.save(failOnError: true)
        UserRole.create user, role
        UserRole.withSession {
            it.flush()
            it.clear()
        }
        render user as JSON
    }
}
