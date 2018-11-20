-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- 생성 시간: 18-11-20 09:34
-- 서버 버전: 10.1.36-MariaDB
-- PHP 버전: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 데이터베이스: `srmdb`
--

-- --------------------------------------------------------

--
-- 테이블 구조 `pc_detail_tb`
--

CREATE TABLE `pc_detail_tb` (
  `PC_CD` char(11) NOT NULL COMMENT 'PC 코드',
  `DATACHK_FL` tinyint(1) DEFAULT '0' COMMENT '기존 데이터 저장 여부',
  `MAKER_NM` varchar(50) DEFAULT NULL COMMENT '제조사명',
  `MODEL_NM` varchar(50) DEFAULT NULL COMMENT '모델명',
  `OS_NM` varchar(50) DEFAULT NULL COMMENT '운영체제명',
  `BIOS_NM` varchar(50) DEFAULT NULL COMMENT '바이오스명',
  `SIZE_DISK` int(10) UNSIGNED DEFAULT NULL COMMENT '디스크 전체 용량',
  `SIZE_MEM` int(10) UNSIGNED DEFAULT NULL COMMENT '메모리 전체 용량',
  `SIZE_VERT` int(10) UNSIGNED DEFAULT NULL COMMENT '가상메모리 전체 용량',
  `INSTALL_DT` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '설치 일자'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='PC 상세 정보 테이블';

-- --------------------------------------------------------

--
-- 테이블 구조 `pc_info_tb`
--

CREATE TABLE `pc_info_tb` (
  `PC_CD` char(11) NOT NULL COMMENT 'PC 코드',
  `ADDR_MAC` char(17) NOT NULL COMMENT 'MAC 주소',
  `PC_NM` varchar(10) NOT NULL COMMENT 'PC 이름',
  `ADDR_IP` char(15) DEFAULT NULL COMMENT 'IP 주소',
  `ID` varchar(25) NOT NULL COMMENT '사용자 아이디'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='PC 정보 테이블';

-- --------------------------------------------------------

--
-- 테이블 구조 `pc_network_tb`
--

CREATE TABLE `pc_network_tb` (
  `PC_CD` char(11) NOT NULL COMMENT 'PC 코드',
  `AMT_RECEIVED` int(10) UNSIGNED DEFAULT NULL COMMENT '받은 양',
  `AMT_SENT` int(10) UNSIGNED DEFAULT NULL COMMENT '보낸 양',
  `AMT_TOTAL` int(10) UNSIGNED DEFAULT NULL COMMENT '트래픽 양 합계',
  `DATAREG_DT` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '데이터 등록 일자'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='PC 네트워크 정보 테이블';

-- --------------------------------------------------------

--
-- 테이블 구조 `pc_process_tb`
--

CREATE TABLE `pc_process_tb` (
  `PC_CD` char(11) NOT NULL COMMENT 'PC 코드',
  `PROC_NM` varchar(50) DEFAULT NULL COMMENT '프로세스 이름',
  `CREATE_DT` datetime DEFAULT NULL COMMENT '프로세스 생성 일자',
  `USAGE_MEM` int(10) UNSIGNED DEFAULT NULL COMMENT '메모리 사용량',
  `DATAREG_DT` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '데이터 등록 일자'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='PC 프로세스 정보 테이블';

-- --------------------------------------------------------

--
-- 테이블 구조 `pc_realtime_tb`
--

CREATE TABLE `pc_realtime_tb` (
  `PC_CD` char(11) NOT NULL COMMENT 'PC 코드',
  `USAGE_CPU` int(10) UNSIGNED DEFAULT NULL COMMENT 'CPU 사용량',
  `TEMP1_CPU` int(10) UNSIGNED DEFAULT NULL COMMENT 'CPU 온도1',
  `TEMP2_CPU` int(10) UNSIGNED DEFAULT NULL COMMENT 'CPU 온도2',
  `USAGE_DISK` int(10) UNSIGNED DEFAULT NULL COMMENT '디스크 사용량',
  `USAGE_MEM` int(10) UNSIGNED DEFAULT NULL COMMENT '메모리 사용량',
  `USAGE_VERT` int(10) UNSIGNED DEFAULT NULL COMMENT '가상메모리 사용량',
  `DATAREG_DT` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '데이터 등록 일자'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='PC 실시간 정보 테이블';

-- --------------------------------------------------------

--
-- 테이블 구조 `user_info_tb`
--

CREATE TABLE `user_info_tb` (
  `ID` varchar(25) NOT NULL COMMENT '아이디',
  `PASSWORD` char(64) NOT NULL COMMENT '비밀번호',
  `NAME` varchar(10) NOT NULL COMMENT '이름',
  `REGDATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록 일자'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='사용자 정보 테이블';

--
-- 덤프된 테이블의 인덱스
--

--
-- 테이블의 인덱스 `pc_detail_tb`
--
ALTER TABLE `pc_detail_tb`
  ADD KEY `PC_CD` (`PC_CD`);

--
-- 테이블의 인덱스 `pc_info_tb`
--
ALTER TABLE `pc_info_tb`
  ADD PRIMARY KEY (`PC_CD`),
  ADD UNIQUE KEY `ADDR_MAC` (`ADDR_MAC`),
  ADD KEY `ID` (`ID`);

--
-- 테이블의 인덱스 `pc_network_tb`
--
ALTER TABLE `pc_network_tb`
  ADD KEY `PC_CD` (`PC_CD`);

--
-- 테이블의 인덱스 `pc_process_tb`
--
ALTER TABLE `pc_process_tb`
  ADD KEY `PC_CD` (`PC_CD`);

--
-- 테이블의 인덱스 `pc_realtime_tb`
--
ALTER TABLE `pc_realtime_tb`
  ADD KEY `PC_CD` (`PC_CD`);

--
-- 테이블의 인덱스 `user_info_tb`
--
ALTER TABLE `user_info_tb`
  ADD PRIMARY KEY (`ID`);

--
-- 덤프된 테이블의 제약사항
--

--
-- 테이블의 제약사항 `pc_detail_tb`
--
ALTER TABLE `pc_detail_tb`
  ADD CONSTRAINT `pc_detail_tb_ibfk_1` FOREIGN KEY (`PC_CD`) REFERENCES `pc_info_tb` (`PC_CD`);

--
-- 테이블의 제약사항 `pc_info_tb`
--
ALTER TABLE `pc_info_tb`
  ADD CONSTRAINT `pc_info_tb_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `user_info_tb` (`ID`);

--
-- 테이블의 제약사항 `pc_network_tb`
--
ALTER TABLE `pc_network_tb`
  ADD CONSTRAINT `pc_network_tb_ibfk_1` FOREIGN KEY (`PC_CD`) REFERENCES `pc_info_tb` (`PC_CD`);

--
-- 테이블의 제약사항 `pc_process_tb`
--
ALTER TABLE `pc_process_tb`
  ADD CONSTRAINT `pc_process_tb_ibfk_1` FOREIGN KEY (`PC_CD`) REFERENCES `pc_info_tb` (`PC_CD`);

--
-- 테이블의 제약사항 `pc_realtime_tb`
--
ALTER TABLE `pc_realtime_tb`
  ADD CONSTRAINT `pc_realtime_tb_ibfk_1` FOREIGN KEY (`PC_CD`) REFERENCES `pc_info_tb` (`PC_CD`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
