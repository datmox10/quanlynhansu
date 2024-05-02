package com.quanlynhansu.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.quanlynhansu.dto.CongTacDTO;

public interface ICongTacService {
	List<CongTacDTO> findAll(Pageable pageable);
	int getTotalItem();
	CongTacDTO findById(long id);
	CongTacDTO save(CongTacDTO congTacDTO);
	void delete(long id);
	Map<Long, String> findALLMap();
}
