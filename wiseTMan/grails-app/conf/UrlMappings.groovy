class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')

        "/school/$id?"(controller: "school"){
            action = [GET: "show", PUT: "update", DELETE: "delete", POST: "save"]
        }
	}
}
