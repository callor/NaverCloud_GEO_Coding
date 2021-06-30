package com.callor.naver.cloud.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import org.json.simple.parser.ParseException;

import com.callor.naver.cloud.config.NaverSecret;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class NaverCloudMapService<VO> {
	
	public abstract String queryURL(String search) throws UnsupportedEncodingException;
	
	public  String jsonString(String queryURL) throws IOException {
		
		URL url = new URL(queryURL);
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();

		httpConn.setRequestMethod("GET");

		httpConn.setRequestProperty("X-NCP-APIGW-API-KEY-ID", NaverSecret.MAP.X_NCP_APIGW_API_KEY_ID);
		httpConn.setRequestProperty("X-NCP-APIGW-API-KEY", NaverSecret.MAP.X_NCP_APIGW_API_KEY);

		int resCode = httpConn.getResponseCode();
		BufferedReader buffer = null;
		InputStreamReader is = null;

		if (resCode == 200) {
			is = new InputStreamReader(httpConn.getInputStream());
		} else {
			is = new InputStreamReader(httpConn.getErrorStream());
		}

		// InputStreamReader와 BufferedReader를 파이프로 연결
		buffer = new BufferedReader(is);
		StringBuffer sBuffer = new StringBuffer();

		String reader = new String();
		while ((reader = buffer.readLine()) != null) {
			sBuffer.append(reader);
		}
		buffer.close();
		log.debug("jsonString : {}",sBuffer.toString());
		return sBuffer.toString();
	}
	
	public abstract List<VO> getList(String jsonString) throws IOException, ParseException;
	public abstract VO getData(String jsonString) throws IOException, ParseException;
	
}
