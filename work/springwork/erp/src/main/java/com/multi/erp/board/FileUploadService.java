package com.multi.erp.board;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	// 파일업로드를 수행하는 메소드 - 파일업로드를 하기 위해서 List<MultipartFile> 객체와 실제 업로드할 위치를 매개변수로 전달받아 사용
	public void uploadFiles(List<MultipartFile>multipartFiles, String path) 
							throws IllegalStateException, IOException {
		for(MultipartFile multipartFile:multipartFiles) {
			// 파일명
			String filename = multipartFile.getOriginalFilename();
			// ~~~~~~~/WEB-INF/upload + / + 파일명
			// ----------------------
			// path
			multipartFile.transferTo(new File(path+File.separator+filename));
		}
	}
}
