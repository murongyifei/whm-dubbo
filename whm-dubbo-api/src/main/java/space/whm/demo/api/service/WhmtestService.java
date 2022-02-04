/*
 * Powered By murongyifei
 */

package space.whm.demo.api.service;

import java.io.Serializable;

import space.whm.demo.api.entity.Whmtest;

public interface WhmtestService {
	/**
	 * 增
	 * @author whm
	 * @param entity
	 * @return
	 */
	Serializable insert(Whmtest entity);
	
	/**
	 * 删
	 * @author whm
	 * @param id
	 * @return
	 */
	boolean delete(Serializable id);
	
	/**
	 * 改
	 * @author whm
	 * @param entity
	 * @return
	 */
	boolean update(Whmtest entity);
	
	/**
	 * 查
	 * @author whm
	 * @param id
	 * @return
	 */
	Whmtest load(Serializable id);
	
	public void sysout52zyj();
}
