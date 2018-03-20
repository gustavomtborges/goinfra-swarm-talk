package br.com.goifnra.swarm

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ApiController {

    @GetMapping('/')
    ResponseEntity get() {
        return new ResponseEntity([name: 'Beers API', status: 'OK'], HttpStatus.OK)
    }
}