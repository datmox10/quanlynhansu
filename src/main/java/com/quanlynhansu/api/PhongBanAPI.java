package com.quanlynhansu.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quanlynhansu.dto.PhongBanDTO;
import com.quanlynhansu.service.IPhongBanService;

@RestController
public class PhongBanAPI {
	@Autowired
	private IPhongBanService phongBanService;
	
	@PostMapping("/api/phongban")
	public PhongBanDTO createPhongBan(@RequestBody PhongBanDTO phongBanDTO) {
		return phongBanService.save(phongBanDTO);
	}
	
	@PutMapping("/api/phongban")
	public PhongBanDTO updatePhongBan(@RequestBody PhongBanDTO phongBanDTO) {
		return phongBanService.save(phongBanDTO);
	}
	
	@DeleteMapping(value ="/api/phongban")
	public void deletePhongBan(@RequestBody long id) {
		phongBanService.delete(id);
	}
}
