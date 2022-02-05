package space.whm.demo.provider.test;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import space.whm.demo.api.entity.City;
import space.whm.demo.api.service.WhmtestService;
import space.whm.demo.dal.provider.dao.CityMapper;
import tk.mybatis.spring.annotation.MapperScan;

import javax.annotation.Resource;

/**
 * @author whm
 * @since 2017/9/2.
 */
@SpringBootTest
@SpringBootApplication
@MapperScan(basePackages = "space.whm.demo.dal.provider.dao")
@DubboComponentScan("space.whm.demo.dal.provider.service.impl")
public class MapperTest {

	@Resource
	private CityMapper cityMapper;
	
	@Resource
	private WhmtestService whmtestService;
	
    @Test
    public void test() {
    	City city = cityMapper.selectByPrimaryKey(1);
    	System.out.println(city.getName());
    	
    	whmtestService.sysout52zyj();
    }
}
