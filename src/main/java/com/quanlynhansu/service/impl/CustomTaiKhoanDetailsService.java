package com.quanlynhansu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.quanlynhansu.constant.SystemConstant;
import com.quanlynhansu.dto.TaiKhoan;
import com.quanlynhansu.entity.QuyenEntity;
import com.quanlynhansu.entity.TaiKhoanEntity;
import com.quanlynhansu.repository.TaiKhoanRepository;

@Service
public class CustomTaiKhoanDetailsService implements UserDetailsService{
	
	@Autowired
	TaiKhoanRepository taiKhoanRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		TaiKhoanEntity taiKhoanEntity = taiKhoanRepository.findOneByTaiKhoanAndTrangThai(username,SystemConstant.ACTIVE_STATUS );
	
		if(taiKhoanEntity == null) {
			throw new UsernameNotFoundException("USER NAME NOT FOUND");
		}
		List<GrantedAuthority> authorities = new ArrayList<>();
		for(QuyenEntity quyen: taiKhoanEntity.getQuyens()) {
			authorities.add(new SimpleGrantedAuthority(quyen.getTenQuyen()));
		}
		
		TaiKhoan taikhoan = new TaiKhoan(taiKhoanEntity.getTaiKhoan(), taiKhoanEntity.getMatKhau(), true, true, true, true, authorities);
		taikhoan.setFullName(taiKhoanEntity.getTaiKhoan());
		return taikhoan;
	}

}
