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

import com.quanlynhansu.converter.NhanVienConverter;
import com.quanlynhansu.dto.BangCapDTO;
import com.quanlynhansu.service.IBangCapService;
import com.quanlynhansu.service.INhanVienService;
import com.quanlynhansu.util.MessageUtil;

@Controller
public class BangCapController {
	@Autowired
	private IBangCapService bangCapService;
	
	@Autowired
	private MessageUtil messageUtil;
	
	@Autowired
	private INhanVienService nhanVienService;
	
	@Autowired NhanVienConverter nhanVienConverter;
	
	
	@RequestMapping(value ="/bangcap", method = RequestMethod.GET)
	public ModelAndView show(@RequestParam("page") int page, 
								@RequestParam("limit") int limit, HttpServletRequest request) {
		BangCapDTO dto = new BangCapDTO();
		dto.setPage(page);
		dto.setMaxPageItem(limit);
		ModelAndView model = new ModelAndView("admin/bangcap/bangcap");
		Pageable pageable = new PageRequest(page-1, limit);
		dto.setListResult(bangCapService.findAll(pageable));
		dto.setTotalItem(bangCapService.getTotalItem());
		dto.setTotalPage((int) Math.ceil((double) dto.getTotalItem() / dto.getMaxPageItem()));
		model.addObject("model",dto);
		model.addObject("nhanvien",nhanVienService.findALLMap());
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			model.addObject("message", message.get("message"));
			model.addObject("alert", message.get("alert"));
		}
		return model;
	}
	
	@RequestMapping(value ="/bangcap-chinhsua", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam(value ="id", required = false) Long id,HttpServletRequest request) {
		ModelAndView model = new ModelAndView("admin/bangcap/editbangcap");
		BangCapDTO dto = new BangCapDTO();
		if(id!=null) {
			dto = bangCapService.findById(id);
		}
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			model.addObject("message", message.get("message"));
			model.addObject("alert", message.get("alert"));
		}
		model.addObject("nhanvien", nhanVienService.findALLMap());
		model.addObject("model",dto);
		return model;
	}
	
}
