package com.record.shop.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.record.shop.model.Record;
import com.record.shop.service.RecordService;

@RestController
@RequestMapping("api/v1/")
public class RecordController {
	
	@Autowired
	private RecordService record;
	
	@Value("${uploadfilepath}")
	private String uploadfilepath;	
	
	@RequestMapping(value = "records", method = RequestMethod.GET)
	public List<Record> list() {
		return record.list();
	}

	@RequestMapping(value = "records", method = RequestMethod.POST)
	public Record create(@RequestBody Record Record) {
		return record.create(Record);
	}

	@RequestMapping(value = "records/{id}", method = RequestMethod.GET)
	public Record get(@PathVariable Long id) {
		return record.get(id);
	}

	@RequestMapping(value = "records/{id}", method = RequestMethod.PUT)
	public Record update(@PathVariable Long id, @RequestBody Record Record) {
		return record.update(id, Record);
	}

	@RequestMapping(value = "records/{id}", method = RequestMethod.DELETE)
	public Record delete(@PathVariable Long id) throws IOException {		
		return record.delete(id);
	}
	
	@RequestMapping(value = "imageUpload/{id}", method = RequestMethod.POST)
	public void singleFileUpload(@PathVariable MultipartFile file, @PathVariable Long id) {        
        try {
        	
        	if ( file.isEmpty() ) throw new Exception("File is empty.");
        	
        	// Create record's image directory if not already exists
        	File directory = new File(uploadfilepath + "/" + id);
        	if ( !directory.exists() ) directory.mkdir();
        	
            // Get the file and save it
            byte[] bytes = file.getBytes();
            String fileLocation = directory + "/" + file.getOriginalFilename();
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
