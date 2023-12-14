package com.project.mingle.vo.mypage;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class MyboardDto {
	List<MyActInfo> actInfos;
	Map<String, Integer> lastmap;
}
