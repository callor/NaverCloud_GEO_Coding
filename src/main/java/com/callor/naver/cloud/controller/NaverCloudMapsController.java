package com.callor.naver.cloud.controller;

import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.naver.cloud.model.maps.NcReverseGeoDTO;
import com.callor.naver.cloud.service.NaverCloudMapService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
// /maps/geocoding
@RequestMapping(value = "/maps")
public class NaverCloudMapsController {

	@Qualifier("naverGeoServiceV1")
	protected final NaverCloudMapService<?> nGeoService;

	@Qualifier("naverReverseGeoServiceV1")
	protected final NaverCloudMapService<?> nReGeoService;

	@RequestMapping(value = "/geocoding", method = RequestMethod.POST, produces = "application/json;char=UTF8")
	public String geoCoding(@RequestParam(name = "address", required = false, defaultValue = "") String address,
			Model model) throws IOException, ParseException {

		if (address != null && !address.equals("")) {

			String queryURL = nGeoService.queryURL(address);
			String jsonString = nGeoService.jsonString(queryURL);
			model.addAttribute("GEOS", nGeoService.getList(jsonString));
		}
		return "home";
		//		return jsonString;
	}

	@ResponseBody
	@RequestMapping(value = "/regeocoding", method = RequestMethod.POST, produces = "application/json;char=UTF8")
	public List<NcReverseGeoDTO> reverseGeoCoding(
			@RequestParam(name = "coords", required = false, defaultValue = "") String coords)
			throws IOException, ParseException {

		if (coords == null || coords.equals("")) {
			return null;//"좌표를 입력해주세요";
		}

		String queryURL = nReGeoService.queryURL(coords);
		String jsonString = nReGeoService.jsonString(queryURL);
		//		return jsonString
		return (List<NcReverseGeoDTO>) nReGeoService.getList(jsonString);
	}

}
