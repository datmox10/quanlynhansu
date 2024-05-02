package com.quanlynhansu.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quanlynhansu.dto.BangCapDTO;
import com.quanlynhansu.service.IBangCapService;
@RestController
public class BangCapAPI {
	@Autowired
	private IBangCapService bangCapService;

	
	@PostMapping("/api/bangcap")
	public BangCapDTO createBangCap(@RequestBody BangCapDTO bangCapDTO) {
		return bangCapService.save(bangCapDTO);
	}

	@PutMapping("/api/bangcap")
	public BangCapDTO updateBangCap(@RequestBody BangCapDTO bangCapDTO) {
		return bangCapService.save(bangCapDTO);
	}

	@DeleteMapping(value = "/api/bangcap")
	public void deleteBangCap(@RequestBody long id) {
		bangCapService.delete(id);
	}
}
