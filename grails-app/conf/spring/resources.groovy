import client.portal.api.grails.UserPasswordEncoderListener
// Place your Spring DSL code here
import grails.rest.render.json.JsonRenderer
import client.portal.api.grails.User

beans = {
    userPasswordEncoderListener(UserPasswordEncoderListener)
    userRenderer(JsonRenderer, User) {
        excludes = ['password']
    }
}
