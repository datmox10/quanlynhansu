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

import com.quanlynhansu.dto.BangLuongDTO;
import com.quanlynhansu.entity.NhanVienEntity;
import com.quanlynhansu.repository.NhanVienRepository;
import com.quanlynhansu.service.IBangLuongService;
import com.quanlynhansu.service.INhanVienService;
import com.quanlynhansu.util.MessageUtil;

@Controller
public class BangLuongController {
	@Autowired
	private IBangLuongService bangLuongService;
	
	@Autowired
	private INhanVienService nhanVienService;
	
	@Autowired
	private NhanVienRepository nhanVienRepository;
	
	@Autowired
	private MessageUtil messageUtil;
	
	@RequestMapping(value ="/bangluong", method = RequestMethod.GET)
	public ModelAndView show(@RequestParam("page") int page, 
									@RequestParam("limit") int limit, HttpServletRequest request) {
		BangLuongDTO dto = new BangLuongDTO();
		dto.setPage(page);
		dto.setMaxPageItem(limit);
		ModelAndView model = new ModelAndView("admin/bangluong/bangluong");
		Pageable pageable = new PageRequest(page-1, limit);
		dto.setListResult(bangLuongService.findAll(pageable));
		dto.setTotalItem(bangLuongService.getTotalItem());
		dto.setTotalPage( (int) Math.ceil((double) dto.getTotalItem() / dto.getMaxPageItem()));
		model.addObject("model",dto);
		model.addObject("nhanvien",nhanVienService.findALLMap());
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			model.addObject("message", message.get("message"));
			model.addObject("alert", message.get("alert"));
		}
		return model;
	}
	
	@RequestMapping(value ="/bangluong-chinhsua", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam(value ="id", required = false) Long id,HttpServletRequest request) {
		ModelAndView model = new ModelAndView("admin/bangluong/editbangluong");
		BangLuongDTO dto = new BangLuongDTO();
		if(id!=null) {
			dto = bangLuongService.findById(id);
		}
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			model.addObject("message", message.get("message"));
			model.addObject("alert", message.get("alert"));
		}
		model.addObject("nhanvien",nhanVienService.findALLMap());
		model.addObject("model",dto);
		return model;
	}
	
	@RequestMapping(value ="/bangluong-chitiet", method = RequestMethod.GET)
	public ModelAndView chiTietBangLuong(@RequestParam(value ="id", required = false) Long id,
			HttpServletRequest request) {
		BangLuongDTO dto = new BangLuongDTO();
		ModelAndView model = new ModelAndView("admin/bangluong/chitietbangluong");
		NhanVienEntity entity = nhanVienRepository.findOne(id);
		dto.setListResult(bangLuongService.findAllByNhanVien(entity));
		model.addObject("model",dto);
		model.addObject("nhanvien",nhanVienService.findById(id));
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			model.addObject("message", message.get("message"));
			model.addObject("alert", message.get("alert"));
		}
		return model;
	}
}
