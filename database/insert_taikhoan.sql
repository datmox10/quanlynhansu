USE qlns;

INSERT INTO quyen(ten_quyen) Values("ADMIN");
INSERT INTO quyen(ten_quyen) Values("USER");

INSERT INTO taikhoan(tai_khoan,mat_khau,trang_thai) 
VALUES ("admin","$2a$12$r4GVky4gvwM8gR.LgLWrrOP/soNRKNlzDdz2N4W1YesxCEbx0NISq",1);
INSERT INTO taikhoan(tai_khoan,mat_khau,trang_thai) 
VALUES ("manhdat1","$2a$12$r4GVky4gvwM8gR.LgLWrrOP/soNRKNlzDdz2N4W1YesxCEbx0NISq",1);
INSERT INTO taikhoan(tai_khoan,mat_khau,trang_thai) 
VALUES ("manhdat2","$2a$12$r4GVky4gvwM8gR.LgLWrrOP/soNRKNlzDdz2N4W1YesxCEbx0NISq",1)
;
INSERT INTO quyen_tk(ma_tai_khoan,ma_quyen) 
VALUES (1,1);
INSERT INTO quyen_tk(ma_tai_khoan,ma_quyen) 
VALUES (2,1);
INSERT INTO quyen_tk(ma_tai_khoan,ma_quyen) 
VALUES (3,1);