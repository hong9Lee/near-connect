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
    follower_id varchar(64) NOT NULL,
    followed_id varchar(64) NOT NULL,
    event_at    datetime(6) NOT NULL comment '팔로우 이벤트 시각',
    is_active   char(1)     NOT NULL default 'N' comment '활성 상태',
    PRIMARY KEY (follower_id, followed_id),
    FOREIGN KEY (follower_id) REFERENCES users (user_id),
    FOREIGN KEY (followed_id) REFERENCES users (user_id)
)  comment '팔로우 / 팔로잉 테이블';


CREATE TABLE users
(
    seq           bigint auto_increment comment '유저 시퀀스' primary key,
    user_id       varchar(64) NOT NULL,
    user_name     varchar(64) NOT NULL,
    reg_date_time datetime(6) null comment '등록일자'
)  comment '유저 테이블';
