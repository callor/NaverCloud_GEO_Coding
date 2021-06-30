package com.callor.naver.cloud.model.driving;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Map<String,String> 사용하기
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NcTrafastMap {
	private Map<String,Object> summary;
	private List<String[]> path;
	private List<Map<String,String>> section;
	private List<Map<String,String>> guide;
}