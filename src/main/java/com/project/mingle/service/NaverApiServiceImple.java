package com.project.mingle.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NaverApiServiceImple implements NaverApiService {

	@Value("${N_CAP_IMG_CLIENT_ID}")
	private String CLIENT_ID;
	
	@Value("${N_CAP_IMG_CLIENT_SEC}")
	private String CLIENT_SEC;
	
	@Override
	public String request() {
		// TODO Auto-generated method stub
		String clientId = CLIENT_ID; //애플리케이션 클라이언트 아이디값";
        String clientSecret = CLIENT_SEC; //애플리케이션 클라이언트 시크릿값";
        StringBuffer response=null;
        try {
            String code = "0"; // 키 발급시 0,  캡차 이미지 비교시 1로 세팅
            String apiURL = "https://naveropenapi.apigw.ntruss.com/captcha/v1/nkey?code=" + code;
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
        return response.toString();
	}

	
}
