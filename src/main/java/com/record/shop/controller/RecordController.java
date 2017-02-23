package com.record.shop.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.record.shop.model.Record;
import com.record.shop.repository.RecordRepository;

@RestController
@RequestMapping("api/v1/")
public class RecordController {
	
	@Autowired
	private RecordRepository repo;

	@Value("${uploadfilepath}")
	private String uploadfilepath;
	
	@RequestMapping(value = "records", method = RequestMethod.GET)
	public List<Record> list() {
		return repo.findAll();
	}

	@RequestMapping(value = "records", method = RequestMethod.POST)
	public Record create(@RequestBody Record Record) {
		return repo.saveAndFlush(Record);
	}

	@RequestMapping(value = "records/{id}", method = RequestMethod.GET)
	public Record get(@PathVariable Long id) {
		return repo.findOne(id);
	}

	@RequestMapping(value = "records/{id}", method = RequestMethod.PUT)
	public Record update(@PathVariable Long id, @RequestBody Record Record) {
		Record existingRecord = repo.findOne(id);
		BeanUtils.copyProperties(Record, existingRecord);
		return repo.saveAndFlush(existingRecord);
	}

	@RequestMapping(value = "records/{id}", method = RequestMethod.DELETE)
	public Record delete(@PathVariable Long id) {
		Record existingRecord = repo.findOne(id);
		repo.delete(existingRecord);
		return existingRecord;
	}
	
	@RequestMapping(value = "imageUpload", method = RequestMethod.POST)
	public void singleFileUpload(@PathVariable MultipartFile file) {
        
        try {
        	
        	if ( file.isEmpty() ) throw new Exception("File is empty.");
        	
            // Get the file and save it
            byte[] bytes = file.getBytes();
            String fileLocation = new File(uploadfilepath).getAbsolutePath() + "/" + file.getOriginalFilename();
            FileOutputStream fos = new FileOutputStream(fileLocation);
            fos.write(bytes);
            fos.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
}
