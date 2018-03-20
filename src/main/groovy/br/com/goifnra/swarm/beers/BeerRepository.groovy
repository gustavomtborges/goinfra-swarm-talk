package br.com.goifnra.swarm.beers

import org.springframework.data.jpa.repository.JpaRepository

interface BeerRepository extends JpaRepository<BeerEntity, Long> {
}
