CREATE DATABASE IF NOT EXISTS near_connect;
CREATE USER IF NOT EXISTS 'near_connect_user'@'%' IDENTIFIED BY 'near_connect_user';
GRANT ALL PRIVILEGES ON near_connect.* TO 'near_connect_user'@'%';
FLUSH PRIVILEGES;
