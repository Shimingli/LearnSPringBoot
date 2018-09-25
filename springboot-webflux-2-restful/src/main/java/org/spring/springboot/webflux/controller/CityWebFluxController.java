package org.spring.springboot.webflux.controller;

import org.spring.springboot.domain.City;
import org.spring.springboot.handler.CityHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/city")
public class CityWebFluxController {

    @Autowired
    private CityHandler cityHandler;

     //http://localhost:8080/city/10
    @GetMapping(value = "/{id}")
    public Mono<City> findCityById(@PathVariable("id") Long id) {
        System.out.println("id=="+id);
        return cityHandler.findCityById(id);
    }

    @GetMapping()
    public Flux<City> findAllCity() {
        System.out.println("findAllCity===="  +cityHandler.findAllCity());
        return cityHandler.findAllCity();
    }
    /*
    {
    "cityName": "shiming",
     "id":2
    }
 http://localhost:8080/city

User-Agent: Fiddler
Content-Type: application/json; charset=utf-8
Host: localhost:8080
Content-Length: 45

     */
    @PostMapping()
    public Mono<Long> saveCity(@RequestBody City city) {
        System.out.println("findAllCity==="+city.toString());
        return cityHandler.save(city);
    }

    @PutMapping()
    public Mono<Long> modifyCity(@RequestBody City city) {
        System.out.println("modifyCity"+city.toString());
        return cityHandler.modifyCity(city);
    }

    @DeleteMapping(value = "/{id}")
    public Mono<Long> deleteCity(@PathVariable("id") Long id) {
        System.out.println("deleteCity ="+id);
        return cityHandler.deleteCity(id);
    }
}
