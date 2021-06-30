package com.callor.naver.cloud.model.driving;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class NcTopClass {
	
	public String code;				// ": 0,
	public String message; 			// ": "길찾기를 성공하였습니다.",
	public String currentDateTime;	//": "2020-11-05T14:28:41",
	public NcRoute route;

	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	public class NcRoute {
		private NcTrafastMap[] trafast;
	}
}

// VO 클래스 사용하기
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class NcTrafastVO {
	private NcSummary summary;
	private List<String[]> path;
	private NcSection section;
	private NcGuide guide;
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class NcSummary {
	// SumLocation
	private Map<String,String[]> start;		// ": { "location": [126.8929495, 35.1793168] },
	
	// private SumGoal 
	private Map<String,Object> goal;			// ": { "location": [126.9002368, 35.1813423], "dir": 2 },
	private String distance;		// ": 977,
	private String duration;		// ": 217107,
	private String departureTime;	// ": "2020-11-05T11:06:19",
	private String[][] bbox;		// ": [[126.892923, 35.1782911],[126.9002368, 35.1813423]],
	private String tollFare;		// ": 0,
	private String taxiFare;		// ": 3300,
	private String fuelPrice;		// ": 92
}


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class SumLocation {
	private String[][] location;
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class SumGoal {
	private String[][] location;
	private String dir;
}


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class NcSection  {
	
	private String pointIndex; 	// ": 3, ";
	private String pointCount; 	// ": 14, ";
	private String distance; 	// ": 422,;"

	private String name; 		// : "용봉택지로", "
	private String congestion; 	// : 3, "
	private String speed; 		// ": 14 },
}


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class NcGuide {
	private String pointIndex; 		// ": 3,
	private String type; 			// ": 2,
	private String instructions; 	// ": "'용봉택지로' 방면으로 좌회전",
	private String distance; 		// ": 87,
	private String duration; 		// ": 31317 },
}







