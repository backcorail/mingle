package com.project.mingle.vo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StyleInfoDTO {
    private int style_no;
    private String style_name; // 아이템 제목
    private String user_nick; // 작성자 이름
    private String style_file_name; // 아이템 이미지
    private int style_reply_no; // 댓글 갯수
    private String user_img; // 프로필 이미지
    private List<Stylefile> files; 
    private List<Comment> comment;
}