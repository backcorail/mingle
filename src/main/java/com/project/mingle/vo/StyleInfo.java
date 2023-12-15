package com.project.mingle.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class StyleInfo {
    private int style_no;
    private String style_name;
    private String user_nick;
    private String style_file_name;
    private String user_img; // 유저 이미지 필드 추가
}