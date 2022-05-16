package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.NoticeDto;
import com.ssafy.happyhouse.model.mapper.NoticeMapper;

@Service
public class NoticeServiceImpl implements NoticeService{
	@Autowired
	private NoticeMapper noticeMapper;
	
	@Override
	public boolean registerNotice(NoticeDto noticeDto) throws SQLException {
		return noticeMapper.registerNotice(noticeDto) == 1;
	}

	@Override
	public List<NoticeDto> listNotice() throws SQLException {
		Map<String, Object> param = new HashMap<String, Object>();
		return noticeMapper.listNotice(param);
	}

	@Override
	public NoticeDto getNotice(int noticeNo) throws SQLException {
		return noticeMapper.getNotice(noticeNo);
	}

	@Override
	public boolean updateNotice(NoticeDto noticeDto) throws SQLException {
		return noticeMapper.updateNotice(noticeDto) == 1;
	}

	@Override
	public boolean deleteNotice(int noticeNo) throws SQLException {
		return noticeMapper.deleteNotice(noticeNo) == 1;
	}
}
