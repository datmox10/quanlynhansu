package com.quanlynhansu.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quanlynhansu.dto.ChucVuTDTO;
import com.quanlynhansu.service.IChucVuService;

@RestController
public class ChucVuApi {
	
	@Autowired
	private IChucVuService chucVuService;
	
	@PostMapping("/api/chucvu")
	public ChucVuTDTO createChucVu(@RequestBody ChucVuTDTO chucVuDTO) {
		return chucVuService.save(chucVuDTO);
	}
	
	@PutMapping("/api/chucvu")
	public ChucVuTDTO updateChucVu(@RequestBody ChucVuTDTO chucVuDTO) {
		
		return chucVuService.save(chucVuDTO);
	}
	
	@DeleteMapping(value ="/api/chucvu")
	public void deleteChucVu(@RequestBody Long id) {
		chucVuService.delete(id);
	}
	
}
