package com.project.mingle.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.project.mingle.mapper.ResellMapper;
import com.project.mingle.vo.ResellVO;

@Service
public class ResellServiceImpl implements ResellService {

	@Inject
	ResellMapper mapper;
	
	@Override
	public int resell_totalRecord(ResellVO rVO) {
		return mapper.resell_totalRecord(rVO);
	}
	
	@Override
	public int kream_totalRecord(ResellVO rVO) {
		return mapper.kream_totalRecord(rVO);
	}

	@Override
	public List<ResellVO> resell_boardData(ResellVO rVO) {
		return mapper.resell_boardData(rVO);
	}

	@Override
	public List<ResellVO> kreamData(ResellVO rVO) {
		return mapper.kreamData(rVO);
	}
}
