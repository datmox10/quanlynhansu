package com.quanlynhansu.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quanlynhansu.dto.BangLuongDTO;
import com.quanlynhansu.service.IBangLuongService;

@RestController
public class BangLuongAPI {
	
	@Autowired
	private IBangLuongService bangLuongService;
	
	@PostMapping("/api/bangluong")
	public BangLuongDTO createBangLuong(@RequestBody BangLuongDTO bangLuongDTO) {
		return bangLuongService.save(bangLuongDTO);
	} 
	
	@PutMapping("/api/bangluong")
	public BangLuongDTO updateBangLuong(@RequestBody BangLuongDTO bangLuongDTO) {
		
		return bangLuongService.save(bangLuongDTO);
	}
	
	@DeleteMapping(value ="/api/bangluong")
	public void deleteBangLuong(@RequestBody Long id) {
		bangLuongService.delete(id);
	}
	
}
