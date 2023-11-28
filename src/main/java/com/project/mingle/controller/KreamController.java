package com.project.mingle.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.mingle.service.KreamServiceImpl;
import com.project.mingle.vo.KreamVO;

@Controller
@RequestMapping("/kream")
public class KreamController {

    private final KreamServiceImpl service;

    public KreamController(KreamServiceImpl service) {
        this.service = service;
    }

    @GetMapping("")
    public String Kream( Model model) throws Exception{
    	System.out.println("크립요청");
        List<KreamVO> kreamList = service.getKreamDatas();
        int result = service.kreamInsert(kreamList);
        System.out.println(result+"hello");
        model.addAttribute("kreams", kreamList);
        
        return "kream";
    }
}