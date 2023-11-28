package com.project.mingle.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class KreamVO{
    //private String item_images;
	private String item_image;	
    private String item_name;
    private String item_price;
}

