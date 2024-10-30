create table user_location_history
(
    seq           bigint auto_increment comment '사용자 위치 이력 시퀀스' primary key,
    user_id       varchar(64) not null comment '사용자 ID',
    latitude DOUBLE not null comment '위도',
    longitude DOUBLE not null comment '경도',
    reg_date_time datetime(6) null comment '등록일자'
) comment '사용자 위치 이력 테이블';

CREATE TABLE follow_relationship
(
    seq         bigint auto_increment comment '친구 관계 시퀀스' primary key,
    follower_id varchar(64) NOT NULL,
    followed_id varchar(64) NOT NULL,
    active_yn   char(1)     NOT NULL comment '활성 상태',
    event_at    datetime(6) NOT NULL comment '팔로우 이벤트 시각',
    UNIQUE KEY unique_follower_followed (follower_id, followed_id)
) comment '친구 관계 테이블';

CREATE TABLE users
(
    seq           bigint auto_increment comment '유저 시퀀스' primary key,
    user_id       varchar(64) NOT NULL,
    user_name     varchar(64) NOT NULL,
    reg_date_time datetime(6) null comment '등록일자'
) comment '유저 테이블';
