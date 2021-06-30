package com.callor.naver.cloud.service;

import com.callor.naver.cloud.model.driving.NcTopClass;

public interface NaverCloudDrivingService {
	
	public String queryURL(String start, String goal);
	public NcTopClass getMapPath(String queryURL);
	

}
