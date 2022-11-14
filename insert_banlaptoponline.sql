USE laptopshoponline;

-- insert accounts
insert into accounts(username, passwords,firstname,lastname,address,gmail,phonenumber,activation_code,passwordreset_code,active_account,provider,roles) 
values ("vy","$2a$12$Kq19WMhEm3ZcABroPMiVZO2ERyhO0.wttcpHKYUF7JegGd5LV5kgS", "kim","vy","Quảng Ngãi","vy@gmail.com","012121","","",1,1,2);
-- mk 1234
insert into accounts(username, passwords,firstname,lastname,address,gmail,phonenumber,activation_code,passwordreset_code,active_account,provider,roles)
values ("doan","$2a$12$d0ffly5D.xsQSArJruAHsugNn6.0gIbXh/Nmy0EtDY4c9OAPuWoou", "văn","đoàn","Quảng Ngãi","doan@gmail.com","0132322121","","",1,1,2);
-- mk 12345
insert into accounts(username, passwords,firstname,lastname,address,gmail,phonenumber,activation_code,passwordreset_code,active_account,provider,roles)
values ("tu","$2a$12$69P4b7LD3p6QCe92VJcuxuymCzVhzwv/hAXtYd1i.1yUUsJZojnB2", "tu","nguyen","Quảng Nam","nguyenthanhtu@gmail.com","0326000692","","",1,1,1);
-- mk 123456

-- insert news
insert into news(account_id,title,content,image_link,created,isdeleted) values (3, 'MSI mạnh mẽ I7', 'Máy tính MSI hiện nay đang rất được nhiều bạn trẻ gaming ưa chuộng và ', 'linkanh','2022-10-10',0);
insert into news(account_id,title,content,image_link,created,isdeleted) values (3, 'DELL mạnh mẽ I7', 'Máy tính DELL hiện nay đang rất được nhiều bạn trẻ gaming ưa chuộng và ', 'linkanh2','2022-08-10',0);


-- insert supplier
insert into supplier (supplier_name,supplier_image,isdeleted)
values ('HP','',0);
insert into supplier (supplier_name,supplier_image,isdeleted)
values ('DELL','',0);
insert into supplier (supplier_name,supplier_image,isdeleted)
values ('ASUS','',0);
insert into supplier (supplier_name,supplier_image,isdeleted)
values ('ACER','',0);
insert into supplier (supplier_name,supplier_image,isdeleted)
values ('MSI','',0);

-- insert product
-- la[top HP
insert into product (product_name,supplier_id,quantity,image,unitprice,discount,description,cpu,ram,weight,hard_disk_capacity,hard_disk_type,screen_size,screen_resolution,graphic_card_name,graphic_card_memory,battery_capacity,os_supplied,isdeleted)
values ('Laptop HP 14-DQ2055WM 39K15UA', 1, 10, '', 20000000, '', 'Phủ nhôm bền bỉ, không gian trải nghiệm đủ đầy</br>Hiệu năng lấp đầy nhu cầu người dùng','', '', '', '', '', '', '', '', '', '','',0);
insert into product (product_name,supplier_id,quantity,image,unitprice,discount,description,cpu,ram,weight,hard_disk_capacity,hard_disk_type,screen_size,screen_resolution,graphic_card_name,graphic_card_memory,battery_capacity,os_supplied,isdeleted)
values ('Laptop HP 15S-FQ2602TU 4B6D3PA', 1, 5, '', 22000000, '', 'Cấu hình ổn định với chip intel thế hệ 11</br>Kích thước màn hình 15,6 inches và độ phân giải Full HD', '', '', '', '', '', '', '', '', '', '', '',0);


-- laptop DELL
insert into product (product_name,supplier_id,quantity,image,unitprice,discount,description,cpu,ram,weight,hard_disk_capacity,hard_disk_type,screen_size,screen_resolution,graphic_card_name,graphic_card_memory,battery_capacity,os_supplied,isdeleted)
values ('Laptop Dell Inspiron 3501 5580BLK', 2, 15, '', 15000000, '', 'Thiết kế gọn nhẹ, màn hình kích thước lớn</br>Hiệu năng mượt cùng viên pin đủ dùng', '', '', '', '', '', '', '', '', '', '', '',0);
insert into product (product_name,supplier_id,quantity,image,unitprice,discount,description,cpu,ram,weight,hard_disk_capacity,hard_disk_type,screen_size,screen_resolution,graphic_card_name,graphic_card_memory,battery_capacity,os_supplied,isdeleted)
values ('LAPTOP DELL INSPIRON 3505 i3505-A542BLK', 2, 5, '', 18000000, '', 'Thiết kế mỏng nhẹ, màn hình kích thước lớn với viền siêu mỏng</br>Hiệu năng ổn định trong tầm giá với con chip AMD Ryzen 5 và SSD PCIE', '', '', '', '', '', '', '', '', '', '', '',0);

-- laptop ASUS
insert into product (product_name,supplier_id,quantity,image,unitprice,discount,description,cpu,ram,weight,hard_disk_capacity,hard_disk_type,screen_size,screen_resolution,graphic_card_name,graphic_card_memory,battery_capacity,os_supplied,isdeleted)
values ('Laptop ASUS VivoBook 15 A515EA', 3, 15, '', 20000000, '', 'Thiết kế gọn nhẹ, màn hình kích thước lớn</br>Hiệu năng mượt cùng viên pin đủ dùng', '', '', '', '', '', '', '', '', '', '', '',0);
insert into product (product_name,supplier_id,quantity,image,unitprice,discount,description,cpu,ram,weight,hard_disk_capacity,hard_disk_type,screen_size,screen_resolution,graphic_card_name,graphic_card_memory,battery_capacity,os_supplied,isdeleted)
values ('Laptop ASUS VivoBook Flip TM420IA-EC031T', 3, 25, '', 18000000, '', 'Thiết kế mỏng nhẹ, bản lề quay 360 ấn tượng', '', '', '', '', '', '', '', '', '', '', '',0);

-- laptop ACER
insert into product (product_name,supplier_id,quantity,image,unitprice,discount,description,cpu,ram,weight,hard_disk_capacity,hard_disk_type,screen_size,screen_resolution,graphic_card_name,graphic_card_memory,battery_capacity,os_supplied,isdeleted)
values ('Laptop Acer Aspire 3 A315-56-37DV', 4, 25, '', 18000000, '', 'Thiết kế mỏng nhẹ, cứng cáp</br>Cấu hình ổn định với chip Intel Core i3-1005G1', '', '', '', '', '', '', '', '', '', '', '',0);
insert into product (product_name,supplier_id,quantity,image,unitprice,discount,description,cpu,ram,weight,hard_disk_capacity,hard_disk_type,screen_size,screen_resolution,graphic_card_name,graphic_card_memory,battery_capacity,os_supplied,isdeleted)
values ('Laptop Acer Aspire 5 A514-54-540F', 4, 5, '', 23000000, '', 'Thiết kế mỏng nhẹ, cứng cáp</br>Cấu hình ổn định', '', '', '', '', '', '', '', '', '', '', '',0);

-- laptpo MSI
insert into product (product_name,supplier_id,quantity,image,unitprice,discount,description,cpu,ram,weight,hard_disk_capacity,hard_disk_type,screen_size,screen_resolution,graphic_card_name,graphic_card_memory,battery_capacity,os_supplied,isdeleted)
values ('Laptop MSI Gaming BRAVO 15 A4DCR-270VN', 5, 5, '', 23000000, '', 'Màn hình 15.6" hỗ trợ công nghệ Freesynce, tần số quét màn hình 144Hz</br>Viền màn hình siêu mỏng, thiết kế vỏ nhôm cao cấp', '', '', '', '', '', '', '', '', '', '', '',0);
insert into product (product_name,supplier_id,quantity,image,unitprice,discount,description,cpu,ram,weight,hard_disk_capacity,hard_disk_type,screen_size,screen_resolution,graphic_card_name,graphic_card_memory,battery_capacity,os_supplied,isdeleted)
values ('Laptop MSI Gaming GL75 Leopard 10SCSK 056VN', 5, 5, '', 23000000, '', 'Thiết kế nhỏ gọn, màn hình đến 17.3 inches</br>Cấu hình mạnh mẽ với Core i5-10200H, 8GB RAM, 512GB SSD, VGA GTX 1650 Ti', '', '', '', '', '', '', '', '', '', '', '',0);

-- insert orders-orderdetail
insert into orders(account_id,order_date, receipt_date,totalAmount,shipping,address,customer_note,status)
values (1,'2021-10-5','2021-10-10','38000000','','Đồng Nai','Đúng hàng giúp mình^_^',4);
insert into orderdetail(order_id,product_id,quantity)
values (1,5,1);
insert into orderdetail(order_id,product_id,quantity)
values (1,6,1);

insert into orders(account_id,order_date, receipt_date,totalAmount,shipping,address,customer_note,status)
values (2,'2021-11-15','2021-11-18','41000000','','Quảng Ngãi','Lấy màu đen nha shop',4);
insert into orderdetail(order_id,product_id,quantity)
values (2,7,1);
insert into orderdetail(order_id,product_id,quantity)
values (2,9,1);
