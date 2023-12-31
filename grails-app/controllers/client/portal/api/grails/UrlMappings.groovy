package client.portal.api.grails

class UrlMappings {

    static mappings = {
        delete "/$controller/$id(.$format)?"(action:"delete")
        get "/$controller(.$format)?"(action:"index")
        get "/$controller/$id(.$format)?"(action:"show")
        post "/$controller(.$format)?"(action:"save")
        put "/$controller/$id(.$format)?"(action:"update")
        patch "/$controller/$id(.$format)?"(action:"patch")

        "/"(controller: 'application', action:'index')
        "/order"(controller: 'order', action:'index')
        "/api/user"(controller: 'user', action:'index')
        "/api/register"(controller: 'register', action:'save')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
