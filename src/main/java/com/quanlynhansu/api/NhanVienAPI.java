package com.quanlynhansu.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quanlynhansu.dto.NhanVienDTO;
import com.quanlynhansu.service.INhanVienService;

@RestController
public class NhanVienAPI {
	@Autowired
	private INhanVienService nhanVienService;

	
	@PostMapping("/api/nhanvien")
	public NhanVienDTO createNhanVien(@RequestBody NhanVienDTO nhanVienDTO) {
		return nhanVienService.save(nhanVienDTO);
	}

	@PutMapping("/api/nhanvien")
	public NhanVienDTO updateNhanVien(@RequestBody NhanVienDTO nhanVienDTO) {
		return nhanVienService.save(nhanVienDTO);
	}

	@DeleteMapping(value = "/api/nhanvien")
	public void deleteNhanVien(@RequestBody long id) {
		nhanVienService.delete(id);
	}
	

}
