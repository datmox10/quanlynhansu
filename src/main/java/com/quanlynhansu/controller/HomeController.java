package com.quanlynhansu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.quanlynhansu.dto.CongTacDTO;
import com.quanlynhansu.dto.PhongBanDTO;
import com.quanlynhansu.repository.CongTacRepository;
import com.quanlynhansu.repository.NhanVienRepository;
import com.quanlynhansu.repository.PhongBanRepository;
import com.quanlynhansu.repository.TaiKhoanRepository;
import com.quanlynhansu.service.ICongTacService;
import com.quanlynhansu.service.INhanVienService;
import com.quanlynhansu.service.IPhongBanService;
import com.quanlynhansu.service.impl.PhongBanService;

@Controller
public class HomeController {
	
	@Autowired
	private NhanVienRepository nhanVienRepository;
	@Autowired
	private PhongBanRepository phongBanRepository;
	@Autowired
	private CongTacRepository congTacRepository;
	@Autowired
	private TaiKhoanRepository taiKhoanRepository;
	
	@Autowired
	private IPhongBanService phongBanService;
	
	@Autowired
	private ICongTacService congTacService;
	
	@Autowired
	private INhanVienService nhanVienService;
	
	@RequestMapping(value ="/home", method = RequestMethod.GET)
	public ModelAndView show() {
		ModelAndView model = new ModelAndView("admin/home");
		PhongBanDTO phongBanDTO = new PhongBanDTO();
		Pageable pageable = new PageRequest(0,5);
		
		CongTacDTO congTacDTO = new  CongTacDTO();
		Pageable pageable2 = new PageRequest(0, 3);
			congTacDTO.setListResult(congTacService.findAll(pageable2));
		phongBanDTO.setListResult(phongBanService.findAll(pageable));
		model.addObject("nhanvien",nhanVienRepository.count());
		model.addObject("phongban",phongBanRepository.count());
		model.addObject("congtac",congTacRepository.count());
		model.addObject("taikhoan",taiKhoanRepository.count());
		model.addObject("viewphongban",phongBanDTO);
		model.addObject("viewcongtac",congTacDTO);
		model.addObject("nhanvienlist",nhanVienService.findALLMap());
		return model;
	}
	
	@RequestMapping(value ="/dang-nhap", method = RequestMethod.GET)
	public ModelAndView loginPage() {
		ModelAndView model = new ModelAndView("login");
		return model;
	}
	
	@RequestMapping(value ="/thoat", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest req, HttpServletResponse res ) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication!=null) {
			new SecurityContextLogoutHandler().logout(req, res, authentication);
		}
		
		return new ModelAndView("redirect:/home");
	}
}
