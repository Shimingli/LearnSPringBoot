package org.spring.springboot.controller;

import org.spring.springboot.domain.City;
import org.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by bysocket on 07/02/2017.
 */
@RestController
public class CityRestController {

    @Autowired
    private CityService cityService;

    // http://localhost:8080/api/city/9
    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.GET)
    public City findOneCity(@PathVariable("id") Long id) {
        System.out.println("查询的id="+id);
        return cityService.findCityById(id);
    }
    //http://localhost:8080/api/city   使用 post的请求即可，
    // {"id":88,"provinceId":1000,"cityName":"深圳","description":"仕明"}
    // 如果存在了，就不要去创建一样的id  要不然会出错的哦
    // todo  com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Duplicate entry '100001' for key 'PRIMARY'
    @RequestMapping(value = "/api/city", method = RequestMethod.POST)
    public void createCity(@RequestBody City city) {
        System.out.println("新的城市的"+city.toString());
        cityService.saveCity(city);
    }
    //  {"id":100000,"provinceId":100,"cityName":"深圳","description":"仕明4414"}
    //http://localhost:8080/api/city
    @RequestMapping(value = "/api/city", method = RequestMethod.PUT)
    public void modifyCity(@RequestBody City city) {
        System.out.println("更新的城市===="+city.toString());
        cityService.updateCity(city);
    }
   //http://localhost:8080/api/city/101
    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.DELETE)
    public void modifyCity(@PathVariable("id") Long id) {
        System.out.println("删除城市的id="+id);
        cityService.deleteCity(id);
    }
}
