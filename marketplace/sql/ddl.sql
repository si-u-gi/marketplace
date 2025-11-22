CREATE TABLE users (
    id INT PRIMARY KEY, -- 고유 식별자
    username VARCHAR(50) UNIQUE NOT NULL, -- 아이디
    password VARCHAR(100) NOT NULL, -- 비밀번호
    role VARCHAR(20) NOT NULL, -- 구매자(buyer), 판매자(seller), admin 역할 구분
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP -- 자동으로 생성 날짜 추가
);