package com.Bhran.documentweb.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import com.Bhran.documentweb.entities.Document;
import com.Bhran.documentweb.repository.DocumentRepo;

@Controller
public class DocumentController {

	@Autowired
	DocumentRepo drepo;
	@RequestMapping("displayUpload")
	public String displayUpload(ModelMap modelmap) {
		List<Document> documents = drepo.findAll();
		System.out.println(documents.size());
		modelmap.addAttribute("document", documents);
		return "documentUpload";
		
	}
	
	@RequestMapping(value="/upload" , method=RequestMethod.POST)
	public String uploadDocument(@RequestParam("document") MultipartFile multipartFile,@RequestParam("id") long id,ModelMap modelmap ) {
		
		
		
		Document doc = new Document();
		doc.setId(id);
		doc.setName(multipartFile.getOriginalFilename());
		try {
			doc.setData(multipartFile.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		drepo.save(doc);
		
		List<Document> documents = drepo.findAll();
		modelmap.addAttribute("document", documents);
		return "documentUpload";
	}
	
	@RequestMapping("/download")
	public StreamingResponseBody download(@RequestParam("id") long id,HttpServletResponse res) {
		Document id2 = drepo.findById(id).get();
		byte[] data = id2.getData();
		
		res.setHeader("Content-Disposition", "attachment;filename=down.jpeg");
		return outputStream-> {
			outputStream.write(data);
		};
		
	}
}
