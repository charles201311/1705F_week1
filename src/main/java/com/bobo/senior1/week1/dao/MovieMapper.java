package com.bobo.senior1.week1.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.bobo.senior1.week1.domain.Middle;
import com.bobo.senior1.week1.domain.Movie;
import com.bobo.senior1.week1.domain.Type;

public interface MovieMapper {
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
	 * @Title: deleteMiddle 
	 * @Description: 根据电影ID 删除中间表
	 * @param mid
	 * @return
	 * @return: int
	 */
	int deleteMiddle(Integer mid);
	
	/**
	 * 
	 * @Title: insertMiddle 
	 * @Description: 插入中间表
	 * @param mid
	 * @param tid
	 * @return
	 * @return: int
	 */
	int insertMiddle(@Param("mid")Integer mid,@Param("tid")Integer tid);
	
	
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
	 * @Description: 批量删除
	 * @param ids
	 * @return
	 * @return: int
	 */
	int delete(Integer[] ids);
	
	
	/**
	 * 
	 * @Title: update 
	 * @Description: TODO
	 * @param movie
	 * @return
	 * @return: int
	 */
	int update(Movie movie);
	
	
	/**
	 * 
	 * @Title: insert 
	 * @Description: 增加
	 * @param moive
	 * @return
	 * @return: int
	 */
	int  insert(Movie moive);
	
	

	/**
	 * 
	 * @Title: selects 
	 * @Description: 列表查询
	 * @param name
	 * @return
	 * @return: List<Map>
	 */
	List<Map> selects(@Param("name")String name);
}
