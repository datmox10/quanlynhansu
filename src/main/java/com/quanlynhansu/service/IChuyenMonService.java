package com.quanlynhansu.service;


import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.quanlynhansu.dto.ChuyenMonDTO;

public interface IChuyenMonService {
	List<ChuyenMonDTO> findAll(Pageable pageable);
	int getTotalItem();
	ChuyenMonDTO findById(long id);
	ChuyenMonDTO save(ChuyenMonDTO chuyenMonDTO);
	void delete(long id);
	Map<Long, String> findALLMap();
}
