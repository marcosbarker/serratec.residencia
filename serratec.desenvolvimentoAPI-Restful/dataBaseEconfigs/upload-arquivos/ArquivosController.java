package com.residencia.dell.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.residencia.dell.services.ArquivosService;
import com.residencia.dell.vo.ArquivosVO;

@RestController
@RequestMapping("/arquivos")
public class ArquivosController {
	
	@Autowired
	ArquivosService arquivosService;
	
	@PostMapping("/uploadFile")
    public ArquivosVO uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = arquivosService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/foto/downloadFile/")
                .path(fileName)
                .toUriString();

        return new ArquivosVO(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }
	
	@PostMapping("/deleteFile")
    public boolean deleteFile(@RequestParam("file") String file) {
        return arquivosService.deleteFile(file);
    }
}
