package org.spring.springboot.service.impl;

import org.spring.springboot.dao.CityDao;
import org.spring.springboot.domain.City;
import org.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 城市业务逻辑实现类
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;
    //  Expected one result (or null) to be returned by selectOne(), but found: 5
    // 麻痹 数据库中存入了5处了，哈哈！！！ 尴尬的很----
    //http://localhost:8080/api/cityName?cityName=%E6%B7%B1%E5%9C%B3
    public City findCityByName(String cityName) {
        if(cityDao.findByName(cityName)==null){
            City city = new City();
            city.setCityName("没有找到:"+cityName);
            return city;
        }
        return cityDao.findByName(cityName);
    }

}
