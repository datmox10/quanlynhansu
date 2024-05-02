package com.quanlynhansu.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.quanlynhansu.dto.TrinhDoDTO;

public interface ITrinhDoService {
	List<TrinhDoDTO> findAll(Pageable pageable);
	int getTotalItem();
	TrinhDoDTO findById(long id);
	TrinhDoDTO save(TrinhDoDTO trinhDoDTO);
	void delete(long id);
	Map<Long, String> findALLMap();
}
