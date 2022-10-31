USE laptopshoponline;
-- insert admin
insert into admin(admin_id,display_name,account_name,password,gmail,phone,address) values ('ad1', 'Vũ Trung Tín', 'trungtin', '123','tin@gmail.com', '0919999', 'Đồng Nai');
insert into admin(admin_id,display_name,account_name,password,gmail,phone,address) values ('ad2', 'Bùi Lê Tấn Phi', 'phibui', '123','phi@gmail.com', '0919999', 'Đồng Nai');

-- insert news
insert into news(news_id,admin_id,title,content,image_link,created) values ('news1', 'ad1', 'MSI mạnh mẽ I7', 'Máy tính MSI hiện nay đang rất được nhiều bạn trẻ gaming ưa chuộng và ', 'linkanh','2022-10-10');
insert into news(news_id,admin_id,title,content,image_link,created) values ('news2', 'ad2', 'DELL mạnh mẽ I7', 'Máy tính DELL hiện nay đang rất được nhiều bạn trẻ gaming ưa chuộng và ', 'linkanh2','2022-08-10');


-- insert account
insert into account(account_id,username, password,firstname,lastname,gmail,phone,activation_code,passwordreset_code,active_account,provider,roles)
values ("u1","vy","1234", "kim","vy","vy@gmail.com","012121","","","","","");
insert into account(account_id,username, password,firstname,lastname,gmail,phone,activation_code,passwordreset_code,active_account,provider,roles)
values ("u2","doan","12345", "văn","đoàn","doan@gmail.com","0132322121","","","","","");

-- insert supplier
insert into supplier (supplier_id,supplier_name,supplier_image)
values ('supp1','HP','');
insert into supplier (supplier_id,supplier_name,supplier_image)
values ('supp2','DELL','');
insert into supplier (supplier_id,supplier_name,supplier_image)
values ('supp3','ASUS','');
insert into supplier (supplier_id,supplier_name,supplier_image)
values ('supp4','ACER','');
insert into supplier (supplier_id,supplier_name,supplier_image)
values ('supp5','MSI','');

-- insert product
-- la[top HP
insert into product (product_id,product_name,supplier_id,quantity,image,unitprice,discount,description,cpu,ram,weight,hard_disk_capacity,hard_disk_type,screen_size,screen_resolution,graphic_card_name,graphic_card_memory,battery_capacity,os_supplied)
values ( 'hp1', 'Laptop HP 14-DQ2055WM 39K15UA', 'supp1', 10, '', 20000000, '', 'Phủ nhôm bền bỉ, không gian trải nghiệm đủ đầy</br>Hiệu năng lấp đầy nhu cầu người dùng', '', '', '', '', '', '', '', '', '', '', '');
insert into product (product_id,product_name,supplier_id,quantity,image,unitprice,discount,description,cpu,ram,weight,hard_disk_capacity,hard_disk_type,screen_size,screen_resolution,graphic_card_name,graphic_card_memory,battery_capacity,os_supplied)
values ( 'hp2', 'Laptop HP 15S-FQ2602TU 4B6D3PA', 'supp1', 5, '', 22000000, '', 'Cấu hình ổn định với chip intel thế hệ 11</br>Kích thước màn hình 15,6 inches và độ phân giải Full HD', '', '', '', '', '', '', '', '', '', '', '');


-- laptop DELL
insert into product (product_id,product_name,supplier_id,quantity,image,unitprice,discount,description,cpu,ram,weight,hard_disk_capacity,hard_disk_type,screen_size,screen_resolution,graphic_card_name,graphic_card_memory,battery_capacity,os_supplied)
values ( 'dell1', 'Laptop Dell Inspiron 3501 5580BLK', 'supp2', 15, '', 15000000, '', 'Thiết kế gọn nhẹ, màn hình kích thước lớn</br>Hiệu năng mượt cùng viên pin đủ dùng', '', '', '', '', '', '', '', '', '', '', '');
insert into product (product_id,product_name,supplier_id,quantity,image,unitprice,discount,description,cpu,ram,weight,hard_disk_capacity,hard_disk_type,screen_size,screen_resolution,graphic_card_name,graphic_card_memory,battery_capacity,os_supplied)
values ( 'dell2', 'LAPTOP DELL INSPIRON 3505 i3505-A542BLK', 'supp2', 5, '', 18000000, '', 'Thiết kế mỏng nhẹ, màn hình kích thước lớn với viền siêu mỏng</br>Hiệu năng ổn định trong tầm giá với con chip AMD Ryzen 5 và SSD PCIE', '', '', '', '', '', '', '', '', '', '', '');

-- laptop ASUS
insert into product (product_id,product_name,supplier_id,quantity,image,unitprice,discount,description,cpu,ram,weight,hard_disk_capacity,hard_disk_type,screen_size,screen_resolution,graphic_card_name,graphic_card_memory,battery_capacity,os_supplied)
values ( 'asus1', 'Laptop ASUS VivoBook 15 A515EA', 'supp3', 15, '', 20000000, '', 'Thiết kế gọn nhẹ, màn hình kích thước lớn</br>Hiệu năng mượt cùng viên pin đủ dùng', '', '', '', '', '', '', '', '', '', '', '');
insert into product (product_id,product_name,supplier_id,quantity,image,unitprice,discount,description,cpu,ram,weight,hard_disk_capacity,hard_disk_type,screen_size,screen_resolution,graphic_card_name,graphic_card_memory,battery_capacity,os_supplied)
values ( 'asus2', 'Laptop ASUS VivoBook Flip TM420IA-EC031T', 'supp3', 25, '', 18000000, '', 'Thiết kế mỏng nhẹ, bản lề quay 360 ấn tượng', '', '', '', '', '', '', '', '', '', '', '');

-- laptop ACER
insert into product (product_id,product_name,supplier_id,quantity,image,unitprice,discount,description,cpu,ram,weight,hard_disk_capacity,hard_disk_type,screen_size,screen_resolution,graphic_card_name,graphic_card_memory,battery_capacity,os_supplied)
values ( 'acer1', 'Laptop Acer Aspire 3 A315-56-37DV', 'supp4', 25, '', 18000000, '', 'Thiết kế mỏng nhẹ, cứng cáp</br>Cấu hình ổn định với chip Intel Core i3-1005G1', '', '', '', '', '', '', '', '', '', '', '');
insert into product (product_id,product_name,supplier_id,quantity,image,unitprice,discount,description,cpu,ram,weight,hard_disk_capacity,hard_disk_type,screen_size,screen_resolution,graphic_card_name,graphic_card_memory,battery_capacity,os_supplied)
values ( 'acer2', 'Laptop Acer Aspire 5 A514-54-540F', 'supp4', 5, '', 23000000, '', 'Thiết kế mỏng nhẹ, cứng cáp</br>Cấu hình ổn định', '', '', '', '', '', '', '', '', '', '', '');

-- laptpo MSI
insert into product (product_id,product_name,supplier_id,quantity,image,unitprice,discount,description,cpu,ram,weight,hard_disk_capacity,hard_disk_type,screen_size,screen_resolution,graphic_card_name,graphic_card_memory,battery_capacity,os_supplied)
values ( 'msi1', 'Laptop MSI Gaming BRAVO 15 A4DCR-270VN', 'supp5', 5, '', 23000000, '', 'Màn hình 15.6" hỗ trợ công nghệ Freesynce, tần số quét màn hình 144Hz</br>Viền màn hình siêu mỏng, thiết kế vỏ nhôm cao cấp', '', '', '', '', '', '', '', '', '', '', '');
insert into product (product_id,product_name,supplier_id,quantity,image,unitprice,discount,description,cpu,ram,weight,hard_disk_capacity,hard_disk_type,screen_size,screen_resolution,graphic_card_name,graphic_card_memory,battery_capacity,os_supplied)
values ( 'msi2', 'Laptop MSI Gaming GL75 Leopard 10SCSK 056VN', 'supp5', 5, '', 23000000, '', 'Thiết kế nhỏ gọn, màn hình đến 17.3 inches</br>Cấu hình mạnh mẽ với Core i5-10200H, 8GB RAM, 512GB SSD, VGA GTX 1650 Ti', '', '', '', '', '', '', '', '', '', '', '');


-- insert orders-orderdetail
insert into orders(order_id,account_id,order_date, receipt_date,totalAmount,shipping,address,customer_note,status)
values ('orders1','u1','2021-10-5','2021-10-10','38000000','','Đồng Nai','Đúng hàng giúp mình^_^','Đã Giao');
insert into orderdetail(order_id,product_id,quantity)
values ('orders1','asus1',1);
insert into orderdetail(order_id,product_id,quantity)
values ('orders1','asus2',1);

insert into orders(order_id,account_id,order_date, receipt_date,totalAmount,shipping,address,customer_note,status)
values ('orders2','u2','2021-11-15','2021-11-18','41000000','','Quảng Ngãi','Lấy màu đen nha shop','Đã Giao');
insert into orderdetail(order_id,product_id,quantity)
values ('orders2','acer1',1);
insert into orderdetail(order_id,product_id,quantity)
values ('orders2','msi1',1);
