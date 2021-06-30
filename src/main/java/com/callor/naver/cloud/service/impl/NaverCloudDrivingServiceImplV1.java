package com.callor.naver.cloud.service.impl;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.callor.naver.cloud.config.NaverSecret;
import com.callor.naver.cloud.model.driving.NcTopClass;
import com.callor.naver.cloud.service.NaverCloudDrivingService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NaverCloudDrivingServiceImplV1 implements NaverCloudDrivingService {

	public String queryURL(String start, String goal) {

		String queryURL = NaverSecret.URL.DRIVING
				+ "?start=%s&goal=%s&option=trafast";
		queryURL = String.format(queryURL , start,goal);
		return queryURL;
	
	}

	public NcTopClass getMapPath(String queryURL) {

		URI restURI = null;
		RestTemplate restTemp = new RestTemplate();

		try {
			restURI = new URI(queryURL);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		HttpHeaders headers = new HttpHeaders();
		headers.set("X-NCP-APIGW-API-KEY-ID", NaverSecret.MAP.X_NCP_APIGW_API_KEY_ID);
		headers.set("X-NCP-APIGW-API-KEY", NaverSecret.MAP.X_NCP_APIGW_API_KEY);
		
		HttpEntity<String> entity = new HttpEntity<String>("parameter", headers);
		ResponseEntity<String> mapString = restTemp.exchange(restURI, HttpMethod.GET, entity, String.class);
		log.debug("정보 >>> "+ mapString.getBody());// .toString());

		
		ResponseEntity<NcTopClass> mapList = null;
		mapList = restTemp.exchange(restURI, HttpMethod.GET, entity, NcTopClass.class);

		return mapList.getBody();// .toString(); // .route;
	}
	
	
}
