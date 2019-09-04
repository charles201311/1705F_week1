package com.bobo.senior1.week1.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bobo.senior1.week1.domain.Middle;
import com.bobo.senior1.week1.domain.Movie;
import com.bobo.senior1.week1.domain.Type;
import com.bobo.senior1.week1.service.MovieService;
import com.bobo.senior1.week1.util.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class MovieController {
	//本机改变
	@Resource
	private MovieService movieService;
	
	
	
	/**
	 * 根据电影ID 查询中间表.找出其所属分类
	 * @Title: selectByMid 
	 * @Description: TODO
	 * @param mid
	 * @return
	 * @return: List<Middle>
	 */
	@ResponseBody
	@GetMapping("selectById")
	public List<Middle> selectByMid(Integer mid){
		return movieService.selectByMid(mid);
	}
	
	/**
	 * 执行修改
	 * @Title: update 
	 * @Description: TODO
	 * @param movie
	 * @param tids
	 * @return
	 * @return: boolean
	 */
	
	@ResponseBody
	@PostMapping("update")
	public  boolean update(Movie movie ,Integer[] tids) {
		
		return movieService.update(movie, tids);
		
	}
	/**
	 * 去修改
	 * @Title: update 
	 * @Description: TODO
	 * @param id
	 * @param model
	 * @return
	 * @return: String
	 */
	@GetMapping("update")
	public String update(Integer id,Model model) {
		//查询单个对象
		Movie movie = movieService.select(id);
		
		//查询所有类型
		List<Type> types = movieService.selectTypes();
		
		model.addAttribute("movie",movie);
		model.addAttribute("types",types);
		
		
		
		
		return "update";
		
	}

	/**
	 * 执行增加
	 * @Title: add 
	 * @Description: TODO
	 * @param movie
	 * @param tids
	 * @return
	 * @return: boolean
	 */
	@ResponseBody
	@PostMapping("add")
	public  boolean add(Movie movie ,Integer[] tids) {
		return movieService.insert(movie, tids);
	}
	
	
	
	/**
	 * 去增加
	 * @Title: add 
	 * @Description: TODO
	 * @param model
	 * @return
	 * @return: String
	 */
	@GetMapping("add")
	public String add(Model model) {
		
		List<Type> types = movieService.selectTypes();
		model.addAttribute("types", types);
		return "add";
		
	}
	
	
	
	
	//@RequestMapping(value = "selects",method = RequestMethod.GET)
	
	@GetMapping("selects")
	public String selects(HttpServletRequest request   ,@RequestParam(defaultValue = "1")Integer page,
			@RequestParam(defaultValue = "3")Integer pageSize ,@RequestParam(defaultValue = "")String name) {
	   	PageHelper.startPage(page, pageSize);
		List<Map> list = movieService.selects(name);
		
		
		PageInfo<Map> info =new PageInfo<Map>(list);
		
		//使用分页工具类封装上下页信息
		PageUtil.page(request, "/selects?name="+name, pageSize, list, info.getTotal(), page);
		
		//封装查询结果集
		request.setAttribute("movies", info.getList());
		//封装查询条件
		request.setAttribute("name", name);
		
		return "movies";
		
	}
	
	
}
