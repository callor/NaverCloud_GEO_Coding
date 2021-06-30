package com.callor.naver.cloud.model.maps;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NcReverseGeoDTO {
	private String name;//: "광주광역시",
	private Map<String, String> center;//: {
	//      "center";//: {
	private String crs;//: "EPSG:4326",
	private String lat;//: 126.851338,
	private String lgt;//: 35.160032
	private String alias;// : "광주"
}
