package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.NoticeDto;

@Mapper
public interface NoticeMapper {
	int registerNotice(NoticeDto noticeDto) throws SQLException;
	List<NoticeDto> listNotice(Map<String, Object> map) throws SQLException;
	NoticeDto getNotice(int noticeNo) throws SQLException;
	int updateNotice(NoticeDto noticeDto) throws SQLException;
	int deleteNotice(int noticeNo) throws SQLException;
}
