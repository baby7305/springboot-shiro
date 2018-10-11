INSERT INTO `
sys_user`
VALUES
    ('1', '1', 'admin', 'd3c59d25033dbf980d29554025c23a75', '8d78869f470951332959580424d4bf4f');

INSERT INTO `sys_resource` VALUES ('1', '1', '用户管理', 'userInfo:view', 'menu', 'userInfo/userList');
INSERT INTO `sys_resource` VALUES ('2', '1', '用户添加', 'userInfo:add', 'button', 'userInfo/userAdd');
INSERT INTO `sys_resource` VALUES ('3', '1', '用户删除', 'userInfo:del', 'button', 'userInfo/userDel');

INSERT INTO `sys_role` VALUES ('1', '管理员', 'admin', '1');
INSERT INTO `sys_role` VALUES ('2', 'VIP会员', 'vip', '1');

INSERT INTO `sys_role_sys_resource` VALUES ('1', '1');
INSERT INTO `sys_role_sys_resource` VALUES ('1', '2');

INSERT INTO `sys_user_sys_role` VALUES ('1', '1');