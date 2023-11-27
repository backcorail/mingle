package com.project.mingle.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import com.project.mingle.mapper.KreamMapper;
import com.project.mingle.vo.KreamVO;

@Service
public class KreamServiceImpl implements KreamService{
	@Inject
    KreamMapper mapper;
	
    private static String News_URL = "https://kream.co.kr/?tab=home_men";

    @PostConstruct
    public List<KreamVO> getKreamDatas(){
        List<KreamVO> kreamList = new ArrayList<>();
        try {
		        Document document = Jsoup.connect(News_URL).get();
		
		        Elements contents = document.select(".product_item");
		        for (Element content : contents) {
		            KreamVO kream = KreamVO.builder()
//		            		.item_images(content.select("img").attr("abs:src")) // 이미지
		            		.item_image(content.select("img").attr("abs:src")) // 이미지
		                    .item_name(content.select(".info_box .name").text())		// 제목
		                    .item_price(content.select(".price .num").text())		// 가격
		                    .build();
		            kreamList.add(kream);
		            System.out.println(content.select("img").attr("abs:src"));
		            System.out.println(content.select(".info_box .name").text());
		            System.out.println(content.select(".price .num").text());
		         }
		       
	        }catch(Exception e) {
	        	e.printStackTrace();
	        }
        

        return kreamList;
    }

	@Override
	public int kreamInsert(List<KreamVO> kreamlist) {
		return mapper.kreamInsert(kreamlist);
	}
}