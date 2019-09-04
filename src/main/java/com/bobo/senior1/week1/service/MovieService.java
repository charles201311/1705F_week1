package com.bobo.senior1.week1.service;

import java.util.List;
import java.util.Map;

import com.bobo.senior1.week1.domain.Middle;
import com.bobo.senior1.week1.domain.Movie;
import com.bobo.senior1.week1.domain.Type;

public interface MovieService {
	
	/**
	 * 根据电影ID 查询中间表.找出其所属分类
	 * @Title: selectByMid 
	 * @Description: TODO
	 * @param mid
	 * @return
	 * @return: List<Type>
	 */
	List<Middle> selectByMid(Integer mid);
	/**
	 * 
	 * @Title: selectTypes 
	 * @Description: 查询所有电影类型
	 * @return
	 * @return: List<Type>
	 */
	List<Type> selectTypes();
	
	
	
	/**
	 * 
	 * @Title: select 
	 * @Description: 单查
	 * @param id
	 * @return
	 * @return: Movie
	 */
	Movie select(Integer id);
	
	
	/**
	 * 
	 * @Title: delete 
	 * @Description: 删除
	 * @param ids
	 * @return
	 * @return: int
	 */
	boolean delete(Integer[] ids);
	
	
	/**
	 * 
	 * @Title: update 
	 * @Description: TODO
	 * @param movie
	 * @return
	 * @return: int
	 */
	boolean update(Movie movie,Integer[] tids);
	
	
	/**
	 * 
	 * @Title: insert 
	 * @Description: 增加
	 * @param moive
	 * @return
	 * @return: int
	 */
	boolean   insert(Movie moive,Integer[] tids);
	
	

	/**
	 * 
	 * @Title: selects 
	 * @Description: 列表查询
	 * @param name
	 * @return
	 * @return: List<Map>
	 */
	List<Map> selects(String name);
}
