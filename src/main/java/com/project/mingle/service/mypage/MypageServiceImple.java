package com.project.mingle.service.mypage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.mingle.mapper.MypageMapper;
import com.project.mingle.vo.UserVO;
import com.project.mingle.vo.user.CheckVO;
import com.project.mingle.vo.user.ResponseDto;
import com.project.mingle.vo.user.UserResp;

@Service
public class MypageServiceImple implements MypageService {

	@Autowired
	MypageMapper mypageMapper;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public ResponseDto<String> userPut(String userid, CheckVO checkVO) {
		// TODO Auto-generated method stub
		
		System.out.println("userPut 임플 호출");
		System.out.println("userPut 임플 userid " + userid);
		System.out.println("userPut 임플 checkVO getType " + checkVO.getType());
		System.out.println("userPut 임플 checkVO getData " + checkVO.getData());
		int resultInt = -1;
		UserVO userVO=null;
		switch (checkVO.getType()) {
		case "userid":
			System.out.println(checkVO.getData());
			userVO= mypageMapper.ddDataCheck("user_id",checkVO.getData());
			if(userVO==null) {
				resultInt = mypageMapper.userPut(userid,"user_id",checkVO.getData());
				if(resultInt >0) {
					// 변경성공
					return new ResponseDto<String>(UserResp.ID_C_OK.getValue(), "아이디 변경 성공"); //211
				}else {
					// 변경 실패
					return new ResponseDto<String>(UserResp.ID_C_FAILE.getValue(), "아이디 변경 실패"); //212
				}
			}else {
				// 데이터 중복
				return new ResponseDto<String>(UserResp.ID_C_DD.getValue(), "아이디 중복"); //213
			}			
		case "userpw":
			System.out.println(checkVO.getData());
			String rawPwd = checkVO.getData();
			String encodedPwd = passwordEncoder.encode(rawPwd);
			resultInt = mypageMapper.userPut(userid,"user_pwd",encodedPwd);
			
			if(resultInt >0) {
				// 변경성공
				return new ResponseDto<String>(UserResp.PW_C_OK.getValue(), "비밀번호 변경 성공"); //221
			}else {
				// 변경 실패
				return new ResponseDto<String>(UserResp.PW_C_FAILE.getValue(), "비밀번호 변경 실패"); //222
			}
			
			
		case "usernick":
			userVO= mypageMapper.ddDataCheck("user_nick",checkVO.getData());
			if(userVO==null) {
				resultInt = mypageMapper.userPut(userid,"user_nick",checkVO.getData());
				if(resultInt >0) {
					// 변경성공
					return new ResponseDto<String>(UserResp.NICK_C_OK.getValue(), "닉네임 변경 성공");
				}else {
					// 변경 실패
					return new ResponseDto<String>(UserResp.NICK_C_FAILE.getValue(), "닉네임 변경 실패");
				}
			}else {
				// 데이터 중복
				System.out.println("usernick 체크 else) : ");
				return new ResponseDto<String>(UserResp.NICK_C_DD.getValue(), "닉네임 중복");
			}
			
		case "usertel":
			System.out.println(checkVO.getData());
			userVO= mypageMapper.ddDataCheck("user_tel",checkVO.getData());
			if(userVO==null) {
				resultInt = mypageMapper.userPut(userid,"user_tel",checkVO.getData());
				if(resultInt >0) {
					// 변경성공
					return new ResponseDto<String>(UserResp.TEL_C_OK.getValue(), "전화변호 변경 성공");
				}else {
					// 변경 실패
					return new ResponseDto<String>(UserResp.TEL_C_FAILE.getValue(), "전화변호 변경 실패");
				}
			}else {
				// 데이터 중복
				return new ResponseDto<String>(UserResp.TEL_C_DD.getValue(), "전화변호 중복");
			}
			
		case "useraddr":
			System.out.println(checkVO.getData());
			resultInt = mypageMapper.userPut(userid,"user_addr",checkVO.getData());
			if(resultInt >0) {
				// 변경성공
				return new ResponseDto<String>(UserResp.ADDR_C_OK.getValue(), "주소 변경 성공");
			}else {
				// 변경 실패
				return new ResponseDto<String>(UserResp.ADDR_C_FAILE.getValue(), "주소 변경 실패");
			}			
			
		case "usergen":
			System.out.println(checkVO.getData());
			resultInt = mypageMapper.userPut(userid,"user_gender",checkVO.getData());
			if(resultInt >0) {
				// 변경성공
				return new ResponseDto<String>(UserResp.GEN_C_OK.getValue(), "성별 변경 성공");
			}else {
				// 변경 실패
				return new ResponseDto<String>(UserResp.GEN_C_FAILE.getValue(), "성별 변경 실패");
			}
			
		case "userimg":
			System.out.println(checkVO.getData());
			resultInt = mypageMapper.userPut(userid,"user_img",checkVO.getData());
			System.out.println("호출 확인 : userimg");
			if(resultInt >0) {
				// 변경성공
				System.out.println("호출 확인 : userimg 변경성공");
				return new ResponseDto<String>(UserResp.IMG_C_OK.getValue(), "이미지 변경 성공");
			}else {
				// 변경실패
				System.out.println("값 확인 : userimg 변경실패");
				return new ResponseDto<String>(UserResp.IMG_C_FAILE.getValue(), "이미지 변경 실패");
			}
			
		default:
			System.out.println(checkVO.getData());
			// 어떤 case도 일치하지 않을 때 실행할 코드
			break; // 이 break 문은 종종 생략 가능합니다.
		}
		return null;
	}

	@Override
	public int userOut(String userid) {
		// TODO Auto-generated method stub
		int resultDel =  mypageMapper.userOut(userid);


		return resultDel ;
	}

	
}
