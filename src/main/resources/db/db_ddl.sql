DROP DATABASE IF EXISTS db1;
CREATE DATABASE IF NOT EXISTS db1;
USE db1;

DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `roles`;
DROP TABLE IF EXISTS `user_roles`;


CREATE TABLE `users` (
                         `id` BIGINT NOT NULL AUTO_INCREMENT,
                         `username` VARCHAR(50) NOT NULL,
                         `password` VARCHAR(100) NOT NULL,
                         PRIMARY KEY (`id`),
                         UNIQUE KEY `username` (`username`)
);

CREATE TABLE `roles` (
                         `id` BIGINT NOT NULL AUTO_INCREMENT,
                         `name` VARCHAR(50) NOT NULL,
                         PRIMARY KEY (`id`)
);

CREATE TABLE `user_roles` (
                              `user_id` BIGINT NOT NULL,
                              `role_id` BIGINT NOT NULL,
                              PRIMARY KEY (`user_id`, `role_id`),
                              FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
                              FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
);

