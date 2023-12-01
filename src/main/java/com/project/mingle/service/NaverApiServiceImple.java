package com.project.mingle.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.mingle.vo.naver.NaverCapKeyVO;
import com.project.mingle.vo.naver.NaverCaptchaVO;

@Service
public class NaverApiServiceImple implements NaverApiService {

	@Value("${N_CAP_IMG_CLIENT_ID}")
	private String CLIENT_ID;

	@Value("${N_CAP_IMG_CLIENT_SEC}")
	private String CLIENT_SEC;
	
	NaverCaptchaVO naverCaptchaVO;

	@Override
	public File getCaptcha() {
		// TODO Auto-generated method stub APIExamCaptchaImage
		String captchaKeyJson =	getCaptchaKey("getCaptcha","https://naveropenapi.apigw.ntruss.com/captcha/v1/nkey?code=");
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			// 맵핑중간에 오류가 날수 있으므로 이렇게 예외처리 한다.
			naverCaptchaVO = objectMapper.readValue(captchaKeyJson, NaverCaptchaVO.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("naverCaptchaVO iamge : "+naverCaptchaVO.getKey());
		
		File imgFile= getCaptchaImg(naverCaptchaVO.getKey());
		return imgFile;
	}
	
	@Override
	public File getCaptchaAudio() {
		// TODO Auto-generated method stub
		String captchaKeyJson =	getCaptchaKey("getCaptchaAudio","https://naveropenapi.apigw.ntruss.com/scaptcha/v1/skey?code=");
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			// 맵핑중간에 오류가 날수 있으므로 이렇게 예외처리 한다.
			naverCaptchaVO = objectMapper.readValue(captchaKeyJson, NaverCaptchaVO.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("naverCaptchaVO audio : "+naverCaptchaVO.getKey());
		File audiofile= getCaptchaAudio(naverCaptchaVO.getKey());
		
		return audiofile;
	}	
	
	public String getCaptchaKey(String from, String naverCapkeyURL) {
		String clientId = CLIENT_ID; // 애플리케이션 클라이언트 아이디값";
		String clientSecret = CLIENT_SEC; // 애플리케이션 클라이언트 시크릿값";
		StringBuffer response = null;
		System.out.println("\n from : "+ from);
		System.out.println("naverCapkeyURL : "+ naverCapkeyURL);
		
		try {
			String code = "0"; // 키 발급시 0, 캡차 이미지 비교시 1로 세팅
//			String apiURL = "https://naveropenapi.apigw.ntruss.com/captcha/v1/nkey?code=" + code;
//			String apiURL = "https://naveropenapi.apigw.ntruss.com/scaptcha/v1/skey?code=" + code;
			String apiURL = naverCapkeyURL + code;
			
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
			con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 오류 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
			System.out.println(response.toString());
		} catch (Exception e) {
			System.out.println(e);
		}
		return response.toString();
		
	}
	

	public File getCaptchaImg(String CAPTCHA_KEY) {
		String clientId = CLIENT_ID;// 애플리케이션 클라이언트 아이디값";
		System.out.println("getCaptchaImg() 호출 CAPTCHA_KEY : "+CAPTCHA_KEY);
		File imgFile=null;
		try {
			String key = CAPTCHA_KEY; // https://naveropenapi.apigw.ntruss.com/captcha/v1/nkey 호출로 받은 키값
			String apiURL = "https://naveropenapi.apigw.ntruss.com/captcha-bin/v1/ncaptcha?key=" + key
					+ "&X-NCP-APIGW-API-KEY-ID" + clientId;
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // 정상 호출
				InputStream is = con.getInputStream();
				int read = 0;
				byte[] bytes = new byte[1024];
				// 랜덤한 이름으로 파일 생성
				String tempname = Long.valueOf(new Date().getTime()).toString();
				imgFile = new File(tempname + ".jpg");
				imgFile.createNewFile();
				OutputStream outputStream = new FileOutputStream(imgFile);
				while ((read = is.read(bytes)) != -1) {
					outputStream.write(bytes, 0, read);
				}
				is.close();
				outputStream.close();
			} else { // 오류 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				while ((inputLine = br.readLine()) != null) {
					response.append(inputLine);
				}
				br.close();
				System.out.println(response.toString());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return imgFile;
	}
	
	
	public File getCaptchaAudio(String CAPTCHA_KEY) {
		System.out.println("getCaptchaAudio() 호출 CAPTCHA_KEY : "+CAPTCHA_KEY);
		String clientId = CLIENT_ID;//애플리케이션 클라이언트 아이디값";
		
		File audioFile= null;
		try {
            String key = CAPTCHA_KEY; // https://naveropenapi.apigw.ntruss.com/scaptcha/v1/skey 호출로 받은 키값
            String apiURL = "https://naveropenapi.apigw.ntruss.com/scaptcha-bin/v1/scaptcha?key=" + key 
            		+ "&X-NCP-APIGW-API-KEY-ID=" + clientId;
            System.out.println("getCaptchaAudio() 호출 apiURL 확인 \n "+apiURL); 
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                InputStream is = con.getInputStream();
                int read = 0;
                byte[] bytes = new byte[1024];
                // 랜덤한 이름으로 파일 생성
                String tempname = Long.valueOf(new Date().getTime()).toString();
                audioFile = new File(tempname + ".wav");
                audioFile.createNewFile();
                OutputStream outputStream = new FileOutputStream(audioFile);
                while ((read =is.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }
                is.close();
                outputStream.close();
            } else {  // 오류 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                System.out.println(response.toString());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
		
		return audioFile;
	}

	@Override
	public boolean capkeycheck(NaverCapKeyVO naverCapKeyVO) {
		// TODO Auto-generated method stub
			System.out.println("capkeycheck 체크 1) ");
		
			String clientId = CLIENT_ID;//"YOUR_CLIENT_ID";//애플리케이션 클라이언트 아이디값";
	        String clientSecret =CLIENT_SEC ;//"YOUR_CLIENT_SECRET";//애플리케이션 클라이언트 시크릿값";
	        StringBuffer response = null;
	        try {
	            String code = "1"; // 키 발급시 0,  캡차 이미지 비교시 1로 세팅
	            String key = naverCaptchaVO.getKey();//"CAPTCHA_KEY"; // 캡차 키 발급시 받은 키값
	            System.out.println("capkeycheck 체크 2) CAPTCHA_KEY => "+key);
	            
	            String value = naverCapKeyVO.getKey();//"USER_VALUE"; // 사용자가 입력한 캡차 이미지 글자값
	            System.out.println("capkeycheck 체크 3) USER_VALUE => "+value);
	            
	            String preApiURL="";
	            if(naverCapKeyVO.getType()=="IMG") {
	            	preApiURL ="https://naveropenapi.apigw.ntruss.com/captcha/v1/nkey";
	            }else {
	            	preApiURL ="https://naveropenapi.apigw.ntruss.com/scaptcha/v1/skey";
	            }
//	            String apiURL = "https://naveropenapi.apigw.ntruss.com/captcha/v1/nkey?code=" + code +"&key="+ key + "&value="+ value;
//	            String apiURL = "https://naveropenapi.apigw.ntruss.com/scaptcha/v1/skey?code=" + code +"&key="+ key + "&value="+ value;
	            String apiURL = preApiURL+"?code="+ code +"&key="+ key + "&value="+ value;
	            System.out.println("capkeycheck 체크 4) apiURL => "+apiURL);	            
	            
	            URL url = new URL(apiURL);
	            HttpURLConnection con = (HttpURLConnection)url.openConnection();
	            con.setRequestMethod("GET");
	            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
	            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
	            int responseCode = con.getResponseCode();
	            BufferedReader br;
	            if(responseCode==200) { // 정상 호출
	                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	            } else {  // 오류 발생
	                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	            }
	            String inputLine;
	            response = new StringBuffer();
	            while ((inputLine = br.readLine()) != null) {
	                response.append(inputLine);
	            }
	            br.close();
	            System.out.println(response.toString());
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        
			// json형식의 문자열로 된 키정보를 키값만 얻어오기
			JSONObject jsonObject = new JSONObject(response.toString());
			Boolean result = jsonObject.getBoolean("result"); // 필드 result -boolean / 필드 responseTime-String
			System.out.println("capkeycheck 체크 5) 결과 필드 확인 => ");
			System.out.println("capkeycheck 체크 6) getBoolean(\"result\") => "+ jsonObject.getBoolean("result"));
		
		return result;
	}

}//class
