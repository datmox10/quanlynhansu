package com.quanlynhansu.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quanlynhansu.dto.KyLuatDTO;
import com.quanlynhansu.service.IKyLuatService;
@RestController
public class KyLuatAPI {
	@Autowired
	private IKyLuatService kyLuatService;

	
	@PostMapping("/api/kyluat")
	public KyLuatDTO createKyLuat(@RequestBody KyLuatDTO kyLuatDTO) {
		return kyLuatService.save(kyLuatDTO);
	}

	@PutMapping("/api/kyluat")
	public KyLuatDTO updateKyLuat(@RequestBody KyLuatDTO kyLuatDTO) {
		return kyLuatService.save(kyLuatDTO);
	}

	@DeleteMapping(value = "/api/kyluat")
	public void deleteKyLuat(@RequestBody long id) {
		kyLuatService.delete(id);
	}
}
