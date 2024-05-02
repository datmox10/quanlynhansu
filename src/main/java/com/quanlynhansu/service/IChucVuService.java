package com.quanlynhansu.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.quanlynhansu.dto.ChucVuTDTO;

public interface IChucVuService{
	List<ChucVuTDTO> findAll(Pageable pageable);
	int getTotalItem();
	ChucVuTDTO findById(long id);
	ChucVuTDTO save(ChucVuTDTO chucVuTDTO);
	void delete(long id);
	Map<Long, String> findALLMap();
	
}
