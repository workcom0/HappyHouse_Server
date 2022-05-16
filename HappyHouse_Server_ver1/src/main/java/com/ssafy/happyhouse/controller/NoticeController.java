package com.ssafy.happyhouse.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.happyhouse.model.MemberDto;
import com.ssafy.happyhouse.model.NoticeDto;
import com.ssafy.happyhouse.service.NoticeService;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/notice")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@GetMapping
	public ResponseEntity<List<NoticeDto>> list() throws Exception {
		return new ResponseEntity<>(noticeService.listNotice(), HttpStatus.OK);
	}
	
	@GetMapping("/{noticeNo}")
	public ResponseEntity<NoticeDto> getNotice(@PathVariable String noticeNo) throws NumberFormatException, SQLException {
		return new ResponseEntity<>(noticeService.getNotice(Integer.parseInt(noticeNo)), HttpStatus.OK);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<String> registerNotice(@RequestBody NoticeDto noticeDto) throws SQLException {
		if(noticeService.registerNotice(noticeDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/{noticeNo}")
	public ResponseEntity<String> delteNotice(@PathVariable int noticeNo) throws NumberFormatException, SQLException {
		if(noticeService.deleteNotice(noticeNo)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/{noticeNo}")
	public ResponseEntity<String> updateNotice(@PathVariable int noticeNo, @RequestBody NoticeDto noticeDto) throws SQLException {
		if(noticeService.updateNotice(noticeDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
}
