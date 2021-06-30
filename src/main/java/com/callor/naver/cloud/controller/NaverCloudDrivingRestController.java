package com.callor.naver.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.callor.naver.cloud.model.driving.NcTopClass;
import com.callor.naver.cloud.service.NaverCloudDrivingService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin("*")
@Slf4j
@RestController
@RequestMapping(value="/api")
public class NaverCloudDrivingRestController {

	
	@Autowired
	private NaverCloudDrivingService ncService;
	
	@RequestMapping(value="/direction5/{start}/{goal}",method=RequestMethod.GET)
	public List<String[]> getDirection5(@PathVariable("start") String start, @PathVariable("goal") String goal) {
		
		// String start = "126.89295036769383,35.179317393625674"; // longitude, Latitude  
		// String arrive = "126.90023749731562,35.18134265249205"; // longitude, Latitude
		log.debug("출발 좌표 경도(longitude),위도(Latittude) : {}",start);
		log.debug("도착 좌표 경도(longitude),위도(Latittude) : {}",goal);
		
		String queryURL= ncService.queryURL(start, goal);
		NcTopClass ncTopClass = ncService.getMapPath(queryURL);
		
		return ncTopClass.route.getTrafast()[0].getPath();

	}
	
	
}
