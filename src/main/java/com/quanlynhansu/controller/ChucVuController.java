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

import com.quanlynhansu.dto.ChucVuTDTO;
import com.quanlynhansu.service.IChucVuService;
import com.quanlynhansu.util.MessageUtil;

@Controller(value = "chucVuControllerOfAdmin")
public class ChucVuController {
	
	@Autowired
	private IChucVuService chucVuService;
	
	@Autowired
	private MessageUtil messageUtil;
	
	@RequestMapping(value ="/chucvu", method = RequestMethod.GET)
	public ModelAndView show(@RequestParam("page") int page, 
									@RequestParam("limit") int limit, HttpServletRequest request) {
		ChucVuTDTO dto = new ChucVuTDTO();
		dto.setPage(page);
		dto.setMaxPageItem(limit);
		ModelAndView model = new ModelAndView("admin/chucvu/chucvu");
		Pageable pageable = new PageRequest(page-1, limit);
		dto.setListResult(chucVuService.findAll(pageable));
		dto.setTotalItem(chucVuService.getTotalItem());
		dto.setTotalPage( (int) Math.ceil((double) dto.getTotalItem() / dto.getMaxPageItem()));
		model.addObject("model",dto);
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			model.addObject("message", message.get("message"));
			model.addObject("alert", message.get("alert"));
		}
		return model;
	}
	
	@RequestMapping(value ="/chucvu-chinhsua", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam(value ="id", required = false) Long id,HttpServletRequest request) {
		ModelAndView model = new ModelAndView("admin/chucvu/edit");
		ChucVuTDTO dto = new ChucVuTDTO();
		if(id!=null) {
			dto = chucVuService.findById(id);
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
