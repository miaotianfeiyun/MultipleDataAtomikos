CREATE TABLE
    vip_user
    (
        u_id INT NOT NULL AUTO_INCREMENT COMMENT '主键id',
        noid VARCHAR(50) COMMENT '会员编号',
        email VARCHAR(50) COMMENT '邮箱',
        address VARCHAR(200) COMMENT '住址',
        id_card VARCHAR(50) COMMENT '身份证',
        jobs VARCHAR(50) COMMENT '职业',
        education VARCHAR(20) COMMENT '教育程度',
        marriage VARCHAR(10) COMMENT '婚姻状况',
        phone VARCHAR(15) COMMENT '手机号',
        children INT(2) COMMENT '孩子数量',
        wxid VARCHAR(50) COMMENT '微信号',
        openid VARCHAR(32) COMMENT '微信唯一标识id',
        nick_name VARCHAR(150) COMMENT '微信昵称',
        real_name VARCHAR(50) COMMENT '真实姓名',
        sex VARCHAR(10) DEFAULT '1',
        ischek VARCHAR(2) DEFAULT '10' COMMENT '审核状态：10:未审核 20:已审核',
        credit INT(5) DEFAULT 100 COMMENT '信誉',
        password VARCHAR(20) COMMENT '密码',
        balance DOUBLE DEFAULT 0 COMMENT '余额',
        award DOUBLE DEFAULT 0 COMMENT '奖励',
        from_mark VARCHAR(50) COMMENT '客户来源标记',
        oocar_openid VARCHAR(32) COMMENT '圈圈汽车openid',
        createdate DATETIME COMMENT '创建时间',
        updatedate DATETIME COMMENT '更新时间',
        PRIMARY KEY (u_id),
        INDEX openid (openid)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8;
    
    CREATE TABLE
    tb_user
    (
        id INT NOT NULL AUTO_INCREMENT COMMENT '自增ID',
        name VARCHAR(50) NOT NULL COMMENT '姓名',
        mobile VARCHAR(11) NOT NULL COMMENT '手机号',
        inviter_uid INT NOT NULL COMMENT '邀请用户uid',
        user_type INT NOT NULL COMMENT '用户类型 0普通会员 1会长',
        reg_ip VARCHAR(50) COMMENT '注册ip',
        status TINYINT DEFAULT 0 NOT NULL COMMENT '用户状态 1.新注册 2.已绑定手机号 3.已加入会员 ',
        avatar VARCHAR(200) COMMENT '头像',
        union_id VARCHAR(50) COMMENT '微信unionId',
        open_id VARCHAR(50) COMMENT '微信openId',
        nickname VARCHAR(200) COLLATE utf8mb4_unicode_ci COMMENT '微信昵称',
        sex TINYINT COMMENT '性别',
        subscribe TINYINT DEFAULT 0 COMMENT '是否粉丝',
        language VARCHAR(50) DEFAULT '0' COMMENT '语言',
        city VARCHAR(50) DEFAULT '0' COMMENT '城市',
        province VARCHAR(50) DEFAULT '0' COMMENT '省份',
        country VARCHAR(50) DEFAULT '0' COMMENT '国家',
        subscribe_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '成为粉丝的时间',
        remark VARCHAR(50) DEFAULT '0' COMMENT 'remark',
        channel VARCHAR(20) COMMENT '渠道',
        group_id INT COMMENT 'group_id',
        tag_ids VARCHAR(100) DEFAULT '0' COMMENT 'tag_ids',
        access_token VARCHAR(200) COMMENT '微信accessToken',
        refresh_token VARCHAR(200) COMMENT '微信refreshToken',
        last_refresh_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '微信refreshToken最后刷新时间',
        create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
        update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
        PRIMARY KEY (id),
        CONSTRAINT open_id UNIQUE (open_id),
        INDEX idx_mobile (mobile),
        INDEX idx_open_id (open_id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户基础信息表';