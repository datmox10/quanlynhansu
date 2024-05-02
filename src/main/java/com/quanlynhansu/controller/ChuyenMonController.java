package com.quanlynhansu.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.quanlynhansu.dto.ChuyenMonDTO;
import com.quanlynhansu.service.IChuyenMonService;
import com.quanlynhansu.util.MessageUtil;

@Controller
public class ChuyenMonController {
	
	@Autowired
	private IChuyenMonService chuyenMonService;
	
	@Autowired
	private MessageUtil messageUtil;
	
	@RequestMapping(value ="/chuyenmon", method = RequestMethod.GET)
	public ModelAndView show(@RequestParam("page") int page, 
								@RequestParam("limit") int limit, HttpServletRequest request) {
		ChuyenMonDTO dto = new ChuyenMonDTO();
		dto.setPage(page);
		dto.setMaxPageItem(limit);
		ModelAndView model = new ModelAndView("admin/chuyenmon/chuyenmon");
		Pageable pageable = new PageRequest(page-1, limit);
		dto.setListResult(chuyenMonService.findAll(pageable));
		dto.setTotalItem(chuyenMonService.getTotalItem());
		dto.setTotalPage((int) Math.ceil((double) dto.getTotalItem() / dto.getMaxPageItem()));
		model.addObject("model",dto);
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			model.addObject("message", message.get("message"));
			model.addObject("alert", message.get("alert"));
		}
		return model;
	}
	
	@RequestMapping(value ="/chuyenmon-chinhsua", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam(value ="id", required = false) Long id,HttpServletRequest request) {
		ModelAndView model = new ModelAndView("admin/chuyenmon/edit");
		ChuyenMonDTO dto = new ChuyenMonDTO();
		if(id!=null) {
			dto = chuyenMonService.findById(id);
		}
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			model.addObject("message", message.get("message"));
			model.addObject("alert", message.get("alert"));
		}
		model.addObject("model",dto);
		return model;
	}
}
