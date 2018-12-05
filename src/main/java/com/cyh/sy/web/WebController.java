package com.cyh.sy.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

	@RequestMapping("/")
	public String index(){ 
		return "login";
	}
	
	/**
	 * 返回东区安装统计页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/com/eastim")
	public String chart(HttpServletRequest request, Model model) {
		return "eastinstall";
	}
	
	/**
	 * 返回北区安装统计页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/com/northim")
	public String northChart(HttpServletRequest request, Model model) {
		return "northinstall";
	}
	
	/**
	 * 返回南区安装统计页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/com/southim")
	public String southChart(HttpServletRequest request, Model model) {
		return "southinstall";
	}
	
	/**
	 * 返回全国安装统计页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/com/nationim")
	public String nationChart(HttpServletRequest request, Model model) {
		return "nationinstall";
	}
	
	/**
	 * 返回东区PM统计页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/com/eastpm")
	public String pmEastChart(HttpServletRequest request, Model model) {
		return "eastpm";
	}
	
	/**
	 * 返回北区安装统计页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/com/northpm")
	public String pmNorthChart(HttpServletRequest request, Model model) {
		return "northpm";
	}
	
	/**
	 * 返回南区安装统计页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/com/southpm")
	public String pmSouthChart(HttpServletRequest request, Model model) {
		return "southpm";
	}
	
	/**
	 * 返回全国安装统计页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/com/nationpm")
	public String pmNationChart(HttpServletRequest request, Model model) {
		return "nationpm";
	}
	
}
