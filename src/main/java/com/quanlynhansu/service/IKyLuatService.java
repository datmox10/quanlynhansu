package com.quanlynhansu.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.quanlynhansu.dto.KyLuatDTO;

public interface IKyLuatService {
	List<KyLuatDTO> findAll(Pageable pageable);
	int getTotalItem();
	KyLuatDTO findById(long id);
	KyLuatDTO save(KyLuatDTO kyLuatDTO);
	void delete(long id);
	Map<Long, String> findALLMap();
}
