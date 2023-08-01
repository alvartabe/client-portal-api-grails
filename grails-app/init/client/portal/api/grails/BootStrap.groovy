package client.portal.api.grails

import grails.gorm.transactions.Transactional

class BootStrap {

    def init = { servletContext ->
        //addTestUsers();
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

//    def generateRandomUsers() {
//        int numberOfUsers = 20
//
//        for (int i = 1; i <= numberOfUsers; i++) {
//            String username = "user${i}"
//            String password = RandomStringUtils.randomAlphanumeric(8)
//            String email = "user${i}@example.com"
//            String firstName = RandomStringUtils.randomAlphabetic(6)
//            String lastName = RandomStringUtils.randomAlphabetic(8)
//
//            User user = new User(
//                    username: username,
//                    password: password,
//                    email: email,
//                    firstName: firstName,
//                    lastName: lastName
//            )
//
//            user.save(flush: true)
//        }
//    }
}


