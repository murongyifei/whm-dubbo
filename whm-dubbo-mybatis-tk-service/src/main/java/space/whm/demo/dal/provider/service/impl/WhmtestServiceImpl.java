/*
 * Powered By murongyifei
 */

package space.whm.demo.dal.provider.service.impl;

import java.io.Serializable;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import space.whm.demo.api.entity.Whmtest;
import space.whm.demo.api.entity.Zyjtest;
import space.whm.demo.api.service.WhmtestService;
import space.whm.demo.dal.provider.dao.WhmMapper;
import space.whm.demo.dal.provider.dao.ZyjMapper;

@Slf4j
@DubboService
public class WhmtestServiceImpl implements WhmtestService {
	
	@Autowired
	private WhmMapper whmMapper;
	@Autowired
	private ZyjMapper zyjMapper;
	
	@Override
	public void sysout52zyj() {
		Zyjtest zyjtest = zyjMapper.selectByPrimaryKey(1L);
		System.out.println("===========52 "+zyjtest.getName());
	}

	@Override
	public Serializable insert(Whmtest entity) {
		return whmMapper.insert(entity);
	}

	@Override
	public boolean delete(Serializable id) {
		return (1 ==whmMapper.deleteByPrimaryKey(id)) ? true : false;
	}

	@Override
	public boolean update(Whmtest entity) {
		return (1 == whmMapper.updateByPrimaryKey(entity)) ? true : false;
	}

	@Override
	public Whmtest load(Serializable id) {
		return whmMapper.selectByPrimaryKey(id);
	}

}
