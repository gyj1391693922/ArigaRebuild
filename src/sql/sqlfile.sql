--  电影详情表
CREATE TABLE `basics` (
                          `tconst` VARCHAR(200) NOT NULL COMMENT '唯一识别符',
                          `titleType` varchar(50) NOT NULL COMMENT '视频类型(电影 or 视频)',
                          `primaryTitle` varchar(255) NOT NULL COMMENT '当前标题',
                          `oldTitle` varchar(255) NOT NULL COMMENT '原始标题',
                          `isAdult` tinyint NOT NULL COMMENT '是否面向成人(0否 1是)',
                          `startYear` datetime NOT NULL COMMENT '连载开始时间',
                          `endYear` datetime DEFAULT NULL COMMENT '连载结束时间，未结束为 ''\\n''',
                          `runtimeMinutes` bigint NOT NULL COMMENT '总分钟数',
                          `genres` varchar(255) NOT NULL COMMENT '作品类型(爱情、动作等)',
                          PRIMARY KEY (`tconst`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--  电影总览表（电影详情表外层）
CREATE TABLE `akas` (
                        `tconst` VARCHAR(200) NOT NULL COMMENT '唯一标识符',
                        `title` varchar(255) NOT NULL COMMENT '当前标题',
                        `region` varchar(255) NOT NULL COMMENT '语言地区(缩写，例如CN)',
                        `language` varchar(255) NOT NULL COMMENT '使用的语言',
                        `types` varchar(255) DEFAULT NULL COMMENT '播放形式（剧场上映、电视播放），可为空',
                        `attributes` varchar(255) DEFAULT NULL COMMENT '其他特征，如修订版、加长版，可为空',
                        `isOrlginalTitle` tinyint NOT NULL COMMENT '是否为原始标题，是则1 否则0',
                        `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--  季度剧集信息表
CREATE TABLE `episode` (
                           `tconst` varchar(255) NOT NULL COMMENT '唯一标识符',
                           `parentTconst` varchar(255) NOT NULL COMMENT '父标识符',
                           `seasonNumber` int NOT NULL COMMENT '季度编号，表示某系列第几季',
                           `episodeNumber` int NOT NULL COMMENT '剧集编号，表示当前季度的第几集',
                           PRIMARY KEY (`tconst`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 上架电影
CREATE TABLE `mov` (
                       `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
                       `movName` varchar(255) NOT NULL COMMENT '电影名',
                       `types` varchar(255) NOT NULL COMMENT '类型',
                       `stu` varchar(255) NOT NULL COMMENT '当前状态',
                       `region` varchar(255) NOT NULL COMMENT '地区',
                       `times` varchar(255) NOT NULL COMMENT '电影时长',
                       `img` varchar(255) NOT NULL COMMENT '电影图片地址',
                       `mvs` varchar(255) NOT NULL COMMENT '电影视频地址',
                       `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上架时间',
                       PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 文件
CREATE TABLE `fileinfo` (
                            `fileId` varchar(255) NOT NULL COMMENT 'id',
                            `userId` varchar(255) NOT NULL COMMENT '用户id',
                            `fileMd5` varchar(255) DEFAULT NULL COMMENT '文件md5值',
                            `filePid` varchar(255) DEFAULT NULL COMMENT '父级id',
                            `fileSize` bigint DEFAULT NULL COMMENT '文件大小',
                            `fileName` varchar(255) DEFAULT NULL COMMENT '文件名',
                            `fileCover` varchar(100) DEFAULT NULL COMMENT '文件封面',
                            `filePath` varchar(255) DEFAULT NULL COMMENT '文件地址',
                            `createTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                            `lastUpdateTime` datetime DEFAULT NULL COMMENT '最后更新时间',
                            PRIMARY KEY (`fileId`,`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;