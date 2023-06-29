package client.portal.api.grails

import grails.gorm.transactions.Transactional

class BootStrap {

    def init = { servletContext ->
        addTestUsers();
    }

    @Transactional
    void addTestUsers() {
        Role role = new Role(authority: 'ROLE_ADMIN').save()
        User user = new User(username: 'alvartabe', password: 'virusnet', email: 'alvartabe30@gmail.com', firstName: 'Alvaro', lastName: 'Artavia').save()
        UserRole.create user, role

        UserRole.withSession {
            it.flush()
            it.clear()
        }
    }

    def destroy = {
    }
}
