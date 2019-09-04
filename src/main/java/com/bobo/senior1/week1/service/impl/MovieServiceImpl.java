package com.bobo.senior1.week1.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bobo.senior1.week1.dao.MovieMapper;
import com.bobo.senior1.week1.domain.Middle;
import com.bobo.senior1.week1.domain.Movie;
import com.bobo.senior1.week1.domain.Type;
import com.bobo.senior1.week1.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
	@Resource
	private MovieMapper movieMapper;

	@Override
	public List<Type> selectTypes() {
		return movieMapper.selectTypes();
	}

	@Override
	public boolean delete(Integer[] mids) {

		try {
			// 1.删除电影表
			movieMapper.delete(mids);

			// 2删除中间表
			for (Integer mid : mids) {
				movieMapper.deleteMiddle(mid);
			}

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			// 抛出异常.事务回滚
			throw new RuntimeException("删除失败:" + e.getMessage());

		}

	}

	@Override
	public Movie select(Integer id) {

		return movieMapper.select(id);
	}

	@Override
	public boolean update(Movie movie, Integer[] tids) {

		try {

			// 1.先删除中间表
			movieMapper.deleteMiddle(movie.getId());
			// 2/更新电影表
			movieMapper.update(movie);
			// 3插入中间表
			for (Integer tid : tids) {
				movieMapper.insertMiddle(movie.getId(), tid);
			}
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			// 抛出异常.事务回滚
			throw new RuntimeException("更新失败:" + e.getMessage());

		}

	}

	@Override
	public boolean insert(Movie moive, Integer[] tids) {

		try {

			// 插入电影表
			movieMapper.insert(moive);
			// 插入中间表
			for (Integer tid : tids) {
				movieMapper.insertMiddle(moive.getId(), tid);
			}

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			// 抛出异常.事务回滚
			throw new RuntimeException("增加失败:" + e.getMessage());

		}
	}

	@Override
	public List<Map> selects(String name) {
		return movieMapper.selects(name);
	}

	@Override
	public List<Middle> selectByMid(Integer mid) {
		// TODO Auto-generated method stub
		return movieMapper.selectByMid(mid);
	}

}
