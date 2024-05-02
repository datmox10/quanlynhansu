package com.quanlynhansu.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.quanlynhansu.dto.BangCapDTO;
import com.quanlynhansu.dto.KhenThuongDTO;

public interface IKhenThuongService {
	List<KhenThuongDTO> findAll(Pageable pageable);
	int getTotalItem();
	KhenThuongDTO findById(long id);
	KhenThuongDTO save(KhenThuongDTO khenThuongDTO);
	void delete(long id);
	Map<Long, String> findALLMap();
}
