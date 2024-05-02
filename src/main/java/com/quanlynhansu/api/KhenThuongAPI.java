package com.quanlynhansu.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quanlynhansu.dto.KhenThuongDTO;
import com.quanlynhansu.service.IKhenThuongService;

@RestController
public class KhenThuongAPI {
	@Autowired
	private IKhenThuongService khenThuongService;

	
	@PostMapping("/api/khenthuong")
	public KhenThuongDTO createKhenThuong(@RequestBody KhenThuongDTO khenThuongDTO) {
		return khenThuongService.save(khenThuongDTO);
	}

	@PutMapping("/api/khenthuong")
	public KhenThuongDTO updateKhenThuong(@RequestBody KhenThuongDTO khenThuongDTO) {
		return khenThuongService.save(khenThuongDTO);
	}

	@DeleteMapping(value = "/api/khenthuong")
	public void deleteKhenThuong(@RequestBody long id) {
		khenThuongService.delete(id);
	}
}
