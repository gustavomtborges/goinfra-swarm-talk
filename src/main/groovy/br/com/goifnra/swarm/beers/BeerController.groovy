package br.com.goifnra.swarm.beers

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/beers")
class BeerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BeerController)

    private final BeerRepository beerRepository

    BeerController(BeerRepository beerRepository) {
        this.beerRepository = beerRepository
    }

    @GetMapping
    ResponseEntity getAll() {
        try {
            List<BeerEntity> beerList = beerRepository.findAll()

            LOGGER.info('got all beers successfully')

            return new ResponseEntity(beerList, HttpStatus.OK)
        } catch (Exception e) {
            LOGGER.info('error on get all beers {}', e.getMessage())
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
}
