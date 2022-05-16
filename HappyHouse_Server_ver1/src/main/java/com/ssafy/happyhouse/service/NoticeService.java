package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.NoticeDto;

public interface NoticeService {
	boolean registerNotice(NoticeDto noticeDto) throws SQLException;
	List<NoticeDto> listNotice() throws SQLException;
	NoticeDto getNotice(int noticeNo) throws SQLException;
	boolean updateNotice(NoticeDto noticeDto) throws SQLException;
	boolean deleteNotice(int noticeNo) throws SQLException;
}
