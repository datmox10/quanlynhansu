package com.quanlynhansu.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quanlynhansu.dto.CongTacDTO;
import com.quanlynhansu.service.ICongTacService;
@RestController
public class CongTacAPI {
	@Autowired
	private ICongTacService congTacService;
	
	@PostMapping("/api/congtac")
	public CongTacDTO createCongTac(@RequestBody CongTacDTO congTacDTO) {
		return congTacService.save(congTacDTO);
	}
	
	@PutMapping("/api/congtac")
	public CongTacDTO updateCongTac(@RequestBody CongTacDTO congTacDTO) {
		return congTacService.save(congTacDTO);
	}
	
	@DeleteMapping(value ="/api/congtac")
	public void deleteCongTac(@RequestBody long id) {
		congTacService.delete(id);
	}
}
