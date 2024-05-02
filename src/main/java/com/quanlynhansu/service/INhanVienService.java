package com.quanlynhansu.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.quanlynhansu.dto.NhanVienDTO;

public interface INhanVienService {
	List<NhanVienDTO> findAll(Pageable pageable);
	int getTotalItem();
	NhanVienDTO findById(long id);
	NhanVienDTO save(NhanVienDTO nhanVienDTO);
	void delete(long id);
	Map<Long, String> findALLMap();
}
