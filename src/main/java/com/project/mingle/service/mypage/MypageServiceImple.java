package com.project.mingle.service.mypage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.mingle.mapper.MypageMapper;
import com.project.mingle.vo.UserVO;
import com.project.mingle.vo.mypage.MyActInfo;
import com.project.mingle.vo.mypage.MyRequestReplyVO;
import com.project.mingle.vo.mypage.MyRequestVO;
import com.project.mingle.vo.mypage.MyResellVO;
import com.project.mingle.vo.mypage.MyStyleReplyVO;
import com.project.mingle.vo.mypage.MyStyleVO;
import com.project.mingle.vo.mypage.MyboardRequestVO;
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
	public List<MyActInfo> mybuylist(String userid, MyboardRequestVO myboardRequestVO) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		int limit = 12;
		int offset = myboardRequestVO.getResellno();
		List<MyResellVO> myResellVOs = mypageMapper.getmybuylist(userid, limit, offset);
		// 리스트 병합 및 정렬
		List<MyActInfo> combinedList = new ArrayList<>();
		combinedList.addAll(myResellVOs);
		combinedList.sort(Comparator.comparing(MyActInfo::getWriteDate).reversed());

		// 결과 반환
		return combinedList.stream().limit(limit).collect(Collectors.toList());
	}
	

	@Override
	public List<MyActInfo> mysellist(String userid, MyboardRequestVO myboardRequestVO) {
		// TODO Auto-generated method stub
		int limit = 12;
		int offset = myboardRequestVO.getResellno();
		List<MyResellVO> myResellVOs = mypageMapper.getMysellist(userid, limit, offset);
		// 리스트 병합 및 정렬
		List<MyActInfo> combinedList = new ArrayList<>();
		combinedList.addAll(myResellVOs);
		combinedList.sort(Comparator.comparing(MyActInfo::getWriteDate).reversed());

		// 결과 반환
		return combinedList.stream().limit(limit).collect(Collectors.toList());
	}
	
	
	
	
	
	@Override
	public List<MyActInfo> myboard(String userid, MyboardRequestVO myboardRequestVO) {
		// TODO Auto-generated method stub

		int limit = 9;
		int offset = myboardRequestVO.getRequestno();
		List<MyRequestVO> myRequestVOs = mypageMapper.getMyRequest(userid, limit, offset);

		offset = myboardRequestVO.getResellno();
		List<MyResellVO> myResellVOs = mypageMapper.getMyResell(userid, limit, offset);

		offset = myboardRequestVO.getStyleno();
		List<MyStyleVO> myStyleVOs = mypageMapper.getMyReStyle(userid, limit, offset);

		// 리스트 병합 및 정렬
		List<MyActInfo> combinedList = new ArrayList<>();
		combinedList.addAll(myRequestVOs);
		combinedList.addAll(myResellVOs);
		combinedList.addAll(myStyleVOs);
		combinedList.sort(Comparator.comparing(MyActInfo::getWriteDate).reversed());

		// 결과 반환
		return combinedList.stream().limit(limit).collect(Collectors.toList());
	}

	@Override
	public List<MyActInfo> myReply(String userid, MyboardRequestVO myboardRequestVO) {
		// TODO Auto-generated method stub

		int limit = 9;
		int offset = myboardRequestVO.getRequestno();
		System.out.println("MypageServiceImple.myReply() ->myboardRequestVO : " + offset);
		List<MyRequestReplyVO> myRequestVOs = mypageMapper.getMyRequestReply(userid, limit, offset);

		offset = myboardRequestVO.getStyleno();
		List<MyStyleReplyVO> myStyleVOs = mypageMapper.getMyReStyleReply(userid, limit, offset);

		// 리스트 병합 및 정렬
		List<MyActInfo> combinedList = new ArrayList<>();
		combinedList.addAll(myRequestVOs);
		combinedList.addAll(myStyleVOs);
		combinedList.sort(Comparator.comparing(MyActInfo::getWriteDate).reversed());

		// 결과 반환
		return combinedList.stream().limit(limit).collect(Collectors.toList());
	}

	@Override
	public ResponseDto<String> userPut(String userid, CheckVO checkVO) {
		// TODO Auto-generated method stub

		System.out.println("userPut 임플 호출");
		System.out.println("userPut 임플 userid " + userid);
		System.out.println("userPut 임플 checkVO getType " + checkVO.getType());
		System.out.println("userPut 임플 checkVO getData " + checkVO.getData());
		int resultInt = -1;
		UserVO userVO = null;
		switch (checkVO.getType()) {
		case "userid":
			System.out.println(checkVO.getData());
			userVO = mypageMapper.ddDataCheck("user_id", checkVO.getData());
			if (userVO == null) {
				resultInt = mypageMapper.userPut(userid, "user_id", checkVO.getData());
				if (resultInt > 0) {
					// 변경성공
					return new ResponseDto<String>(UserResp.ID_C_OK.getValue(), "아이디 변경 성공"); // 211
				} else {
					// 변경 실패
					return new ResponseDto<String>(UserResp.ID_C_FAILE.getValue(), "아이디 변경 실패"); // 212
				}
			} else {
				// 데이터 중복
				return new ResponseDto<String>(UserResp.ID_C_DD.getValue(), "아이디 중복"); // 213
			}
		case "userpw":
			System.out.println(checkVO.getData());
			String rawPwd = checkVO.getData();
			String encodedPwd = passwordEncoder.encode(rawPwd);
			resultInt = mypageMapper.userPut(userid, "user_pwd", encodedPwd);

			if (resultInt > 0) {
				// 변경성공
				return new ResponseDto<String>(UserResp.PW_C_OK.getValue(), "비밀번호 변경 성공"); // 221
			} else {
				// 변경 실패
				return new ResponseDto<String>(UserResp.PW_C_FAILE.getValue(), "비밀번호 변경 실패"); // 222
			}

		case "usernick":
			userVO = mypageMapper.ddDataCheck("user_nick", checkVO.getData());
			if (userVO == null) {
				resultInt = mypageMapper.userPut(userid, "user_nick", checkVO.getData());
				if (resultInt > 0) {
					// 변경성공
					return new ResponseDto<String>(UserResp.NICK_C_OK.getValue(), "닉네임 변경 성공");
				} else {
					// 변경 실패
					return new ResponseDto<String>(UserResp.NICK_C_FAILE.getValue(), "닉네임 변경 실패");
				}
			} else {
				// 데이터 중복
				System.out.println("usernick 체크 else) : ");
				return new ResponseDto<String>(UserResp.NICK_C_DD.getValue(), "닉네임 중복");
			}

		case "usertel":
			System.out.println(checkVO.getData());
			userVO = mypageMapper.ddDataCheck("user_tel", checkVO.getData());
			if (userVO == null) {
				resultInt = mypageMapper.userPut(userid, "user_tel", checkVO.getData());
				if (resultInt > 0) {
					// 변경성공
					return new ResponseDto<String>(UserResp.TEL_C_OK.getValue(), "전화변호 변경 성공");
				} else {
					// 변경 실패
					return new ResponseDto<String>(UserResp.TEL_C_FAILE.getValue(), "전화변호 변경 실패");
				}
			} else {
				// 데이터 중복
				return new ResponseDto<String>(UserResp.TEL_C_DD.getValue(), "전화변호 중복");
			}

		case "useraddr":
			System.out.println(checkVO.getData());
			resultInt = mypageMapper.userPut(userid, "user_addr", checkVO.getData());
			if (resultInt > 0) {
				// 변경성공
				return new ResponseDto<String>(UserResp.ADDR_C_OK.getValue(), "주소 변경 성공");
			} else {
				// 변경 실패
				return new ResponseDto<String>(UserResp.ADDR_C_FAILE.getValue(), "주소 변경 실패");
			}

		case "usergen":
			System.out.println(checkVO.getData());
			resultInt = mypageMapper.userPut(userid, "user_gender", checkVO.getData());
			if (resultInt > 0) {
				// 변경성공
				return new ResponseDto<String>(UserResp.GEN_C_OK.getValue(), "성별 변경 성공");
			} else {
				// 변경 실패
				return new ResponseDto<String>(UserResp.GEN_C_FAILE.getValue(), "성별 변경 실패");
			}

		case "userimg":
			System.out.println(checkVO.getData());
			resultInt = mypageMapper.userPut(userid, "user_img", checkVO.getData());
			System.out.println("호출 확인 : userimg");
			if (resultInt > 0) {
				// 변경성공
				System.out.println("호출 확인 : userimg 변경성공");
				return new ResponseDto<String>(UserResp.IMG_C_OK.getValue(), "이미지 변경 성공");
			} else {
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
		int resultDel = mypageMapper.userOut(userid);
		return resultDel;
	}








}
