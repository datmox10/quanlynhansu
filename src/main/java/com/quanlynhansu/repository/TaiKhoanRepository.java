package com.quanlynhansu.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.quanlynhansu.entity.TaiKhoanEntity;

public interface TaiKhoanRepository extends JpaRepository<TaiKhoanEntity, Long>{
	TaiKhoanEntity findOneByTaiKhoanAndTrangThai(String taiKhoan, int trangThai);
}
