package space.whm.demo.dal.provider;

import org.apache.ibatis.annotations.Mapper;

/**
 * WARN o.m.s.m.ClassPathMapperScanner -  No MyBatis mapper was found in '[space.whm.demo.dal.provider]' package. Please check your configuration.
 * https://www.cnblogs.com/yangshaoxiang/p/12974555.html
 *
 * 能百度到的最靠谱的方案了，添加如下接口到启动类同级目录后，警告即可消失,但不是最合适的!!!
 */
@Mapper
public interface NoWarnMapper {

}
