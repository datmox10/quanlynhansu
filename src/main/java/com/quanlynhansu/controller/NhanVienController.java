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

import com.quanlynhansu.dto.NhanVienDTO;
import com.quanlynhansu.service.IChucVuService;
import com.quanlynhansu.service.IChuyenMonService;
import com.quanlynhansu.service.INhanVienService;
import com.quanlynhansu.service.IPhongBanService;
import com.quanlynhansu.service.ITrinhDoService;
import com.quanlynhansu.util.MessageUtil;

@Controller
public class NhanVienController {
	@Autowired
	private INhanVienService nhanVienService;
	
	@Autowired
	private MessageUtil messageUtil;
	
	@Autowired
	private IChucVuService chucVuService;
	
	@Autowired
	private IChuyenMonService chuyenMonService;
	
	@Autowired
	private IPhongBanService phongBanService;
	
	@Autowired
	private ITrinhDoService trinhDoService;
	
	@RequestMapping(value ="/nhanvien", method = RequestMethod.GET)
	public ModelAndView show(@RequestParam("page") int page, 
								@RequestParam("limit") int limit, HttpServletRequest request) {
		NhanVienDTO dto = new NhanVienDTO();
		dto.setPage(page);
		dto.setMaxPageItem(limit);
		ModelAndView model = new ModelAndView("admin/nhanvien/nhanvien");
		Pageable pageable = new PageRequest(page-1, limit);
		dto.setListResult(nhanVienService.findAll(pageable));
		dto.setTotalItem(nhanVienService.getTotalItem());
		dto.setTotalPage((int) Math.ceil((double) dto.getTotalItem() / dto.getMaxPageItem()));
		model.addObject("model",dto);
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			model.addObject("message", message.get("message"));
			model.addObject("alert", message.get("alert"));
		}
		model.addObject("chucvu",chucVuService.findALLMap());
		model.addObject("trinhdo",trinhDoService.findALLMap());
		model.addObject("chuyenmon",chuyenMonService.findALLMap());
		model.addObject("phongban",phongBanService.findALLMap());
		return model;
	}
	
	@RequestMapping(value ="/nhanvien-chinhsua", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam(value ="id", required = false) Long id,HttpServletRequest request) {
		ModelAndView model = new ModelAndView("admin/nhanvien/editnhanvien");
		NhanVienDTO dto = new NhanVienDTO();
		if(id!=null) {
			dto = nhanVienService.findById(id);
		}
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			model.addObject("message", message.get("message"));
			model.addObject("alert", message.get("alert"));
		}
		model.addObject("chucvu", chucVuService.findALLMap());
		model.addObject("chuyenmon", chuyenMonService.findALLMap());
		model.addObject("trinhdo", trinhDoService.findALLMap());
		model.addObject("phongban", phongBanService.findALLMap());
		model.addObject("model",dto);
		return model;
	}
}
