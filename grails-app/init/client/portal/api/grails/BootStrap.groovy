package client.portal.api.grails

import grails.gorm.transactions.Transactional

class BootStrap {

    def init = { servletContext ->
        addTestUsers();
    }

    @Transactional
    void addTestUsers() {
        Role role = new Role(authority: 'Admin').save()
        User user = new User(username: 'alvartabe', password: 'virusnet').save()
        UserRole.create user, role

        UserRole.withSession {
            it.flush()
            it.clear()
        }
    }

    def destroy = {
    }
}
