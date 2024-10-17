create table user_location_history
(
    seq           bigint auto_increment comment '사용자 위치 이력 시퀀스' primary key,
    user_id       varchar(64) not null comment '사용자 ID',
    latitude      DOUBLE not null comment '위도',
    longitude     DOUBLE not null comment '경도',
    reg_date_time datetime(6) null comment '등록일자'
) comment '사용자 위치 이력 테이블';
