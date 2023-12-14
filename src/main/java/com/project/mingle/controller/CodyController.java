package com.project.mingle.controller;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.mingle.vo.CodyTestVO;
import com.project.mingle.vo.ResellVO;


@Controller
@RequestMapping("/cody")
public class CodyController {
	int[] item_number = {
			100,101,102,103,104,105,106,107,108,109,199,
			200,201,202,203,204,205,206,207,208,209,210,211,299,
			300,301,302,303,304,305,306,399,
			400,401,402,403,404,405,406,499,
			500,501,502,503,504,505,599
	};
	String[] item_detail = {
			"전체", "맨투맨/스웨트 셔츠", "니트/스웨터", "긴소매 티셔츠", "카라 티셔츠", "반소매 티셔츠", "민소매 티셔츠", "후드 티셔츠", "스포츠 상의", "셔츠/블라우스", "기타 상의",
			"전체", "후드 집업", "블루종", "라이더 재킷", "트러커 재킷", "슈트/블레이저 재킷", "무스탕/퍼", "카디건", "아노락", "코트", "패딩", "나일론/코치 재킷", "기타 아우터",
			"전체", "데님팬츠", "코튼 팬트", "슈트 팬츠/슬랙스", "트레이닝/조거 팬츠", "숏 팬츠", "스포츠 하의", "기타 바지",
			"전체", "구두", "부츠", "힐/펌프스", "운동화", "슬리퍼", "샌들", "기타 신발",
			"전체", "백팩", "크로스백/매신저백", "슬링백", "핸드백", "지갑", "기타 가방"
	};
	
	
	
	@GetMapping("")
	public String cody(){
		return "cody/cody";
	}
	
	@GetMapping("/cody_board")
	public ModelAndView cody_board(
			@RequestParam(name="city", defaultValue="") String city,
			@RequestParam(name="situation", defaultValue="daily") String situation) {
		ModelAndView mav= new ModelAndView();
		try {
			int[] array = new int[4];
			int gender = 0;
			String urlstr = "https://api.openweathermap.org/data/2.5/weather?q=" + city + ",kr&appid=43e709e6a39f22a1a3734e13c7720b45";
			URL url = new URL(urlstr);
			BufferedReader bf;
			String line;
            String result="";
            
            //날씨 정보를 받아온다.
            bf = new BufferedReader(new InputStreamReader(url.openStream()));
            
            while((line=bf.readLine())!=null){
                result=result.concat(line);
                //System.out.println(line);
            }
            
            JSONObject jObject = new JSONObject(result);
	        
	        JSONObject mainArray = (JSONObject) jObject.get("main");
	        double ktemp = Double.parseDouble(mainArray.get("temp").toString());
	        double temp = ktemp-273.15;
	        
	        System.out.println(temp);
	        
	        if(gender==0) {
	        	if(temp>28) {
		        	array[0]=105;array[1]=305;array[2]=406;array[3]=405;
		        }else if(temp>23) {
		        	array[0]=109;array[1]=303;array[2]=406;array[3]=404;
		        }else if(temp>16) {
		        	array[0]=107;array[1]=304;array[2]=502;array[3]=404;
		        }else if(temp>12) {
		        	array[0]=202;array[1]=103;array[2]=303;array[3]=404;
		        }else if(temp>4) {
		        	array[0]=209;array[1]=102;array[2]=302;array[3]=404;
		        }else{
		        	array[0]=210;array[1]=209;array[2]=102;array[3]=301;
		        }
	        }else {
	        	if(temp>28) {
		        	array[0]=105;array[1]=305;array[2]=406;array[3]=502;
		        }else if(temp>23) {
		        	array[0]=109;array[1]=302;array[2]=406;array[3]=502;
		        }else if(temp>16) {
		        	array[0]=101;array[1]=302;array[2]=504;array[3]=404;
		        }else if(temp>12) {
		        	array[0]=209;array[1]=103;array[2]=301;array[3]=404;
		        }else if(temp>4) {
		        	array[0]=201;array[1]=103;array[2]=304;array[3]=402;
		        }else{
		        	array[0]=210;array[1]=102;array[2]=301;array[3]=402;
		        }
	        }
	        
	        String[] detail = new String[4];
	        for(int i=0;i<4;i++) {
	        	for(int j=0;j<47;j++) {
	        		if(array[i]==item_number[j]) {
	        			detail[i]=item_detail[j];
	        		}
	        	}
	        }
	        mav.addObject("detail",detail);
            
	        
	        
	        
	        
	        
	        
            
            
            
            bf.close();
		}catch(Exception e){
            System.out.println(e.getMessage());
        }
		
		
		mav.setViewName("cody/cody_board");
		return mav;
	}
	
	
	
	
	
	
	
}
