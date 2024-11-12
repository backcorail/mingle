package com.project.mingle.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomVO {
	//방관련 변수
    private int room_no;
    private int item_no;
    
    //방멤버관련 변수
    private int member_no;
    private String user_id;
    
    //아이템 관련 변수
    private String item_name;
    private String item_price;
    private String item_file_name;
    private String item_status;
    
    //유저데이터관련 변수
    private String user_nick;
    private String user_img;
    private int user_status;
}
