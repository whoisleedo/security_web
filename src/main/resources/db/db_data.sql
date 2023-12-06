INSERT INTO `users` (`username`, `password`) VALUES
                                                 ('user', 'password'),
                                                 ('admin', 'admin');

INSERT INTO `roles` (`name`) VALUES
                                 ('ROLE_USER'),
                                 ('ROLE_ADMIN');

-- 假定 'user' 的 ID 為 1, 'admin' 的 ID 為 2
-- 假定 'ROLE_USER' 的 ID 為 1, 'ROLE_ADMIN' 的 ID 為 2

INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES
                                                    (1, 1), -- user 有 USER 角色
                                                    (2, 1), -- admin 也有 USER 角色
                                                    (2, 2); -- admin 有 ADMIN 角色