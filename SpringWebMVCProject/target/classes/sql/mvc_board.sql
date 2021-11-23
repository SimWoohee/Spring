
create table mvc_board(
	board_no INT PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(50) NOT NULL,
	content VARCHAR(100) NOT NULL,
	writer VARCHAR(30) NOT NULL,
	reg_date TIMESTAMP DEFAULT NOW(),
	view_cnt INT DEFAULT 0
);