package com.quanlynhansu.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.quanlynhansu.dto.BangCapDTO;

public interface IBangCapService {
	List<BangCapDTO> findAll(Pageable pageable);
	int getTotalItem();
	BangCapDTO findById(long id);
	BangCapDTO save(BangCapDTO bangCapDTO);
	void delete(long id);
	Map<Long, String> findALLMap();
}
