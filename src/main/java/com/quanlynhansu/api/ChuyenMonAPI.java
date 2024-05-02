package com.quanlynhansu.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quanlynhansu.dto.ChuyenMonDTO;
import com.quanlynhansu.service.IChuyenMonService;

@RestController
public class ChuyenMonAPI {
	@Autowired
	private IChuyenMonService chuyenMonService;
	
	@PostMapping("/api/chuyenmon")
	public ChuyenMonDTO createChuyenMon(@RequestBody ChuyenMonDTO chuyenMonDTO) {
		return chuyenMonService.save(chuyenMonDTO);
	}
	
	@PutMapping("/api/chuyenmon")
	public ChuyenMonDTO updateChuyenMon(@RequestBody ChuyenMonDTO chuyenMonDTO) {
		return chuyenMonService.save(chuyenMonDTO);
	}
	
	@DeleteMapping(value ="/api/chuyenmon")
	public void deleteChuyenMon(@RequestBody long id) {
		chuyenMonService.delete(id);
	}
}
