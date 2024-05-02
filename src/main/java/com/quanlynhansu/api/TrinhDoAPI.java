package com.quanlynhansu.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quanlynhansu.dto.TrinhDoDTO;
import com.quanlynhansu.service.ITrinhDoService;

@RestController
public class TrinhDoAPI {
	
	@Autowired
	private ITrinhDoService trinhDoService;
	
	@PostMapping("/api/trinhdo")
	public TrinhDoDTO createTrinhDo(@RequestBody TrinhDoDTO trinhDoDTO) {
		return trinhDoService.save(trinhDoDTO);
	}
	
	@PutMapping("/api/trinhdo")
	public TrinhDoDTO updateTrinhDo(@RequestBody TrinhDoDTO trinhDoDTO) {
		return trinhDoService.save(trinhDoDTO);
	}
	
	@DeleteMapping(value ="/api/trinhdo")
	public void deleteChucVu(@RequestBody Long id) {
		trinhDoService.delete(id);
	}
}
