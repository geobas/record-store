package com.record.shop.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.record.shop.model.Record;
import com.record.shop.repository.RecordRepository;

@Service
public class RecordServiceImpl implements RecordService {

    private final static Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());	
	
	@Autowired
	private RecordRepository repo;

	@Value("${uploadfilepath}")
	private String uploadfilepath;
	
	@Override
	public List<Record> list() {
		return repo.findAll();
	}

	@Override
	public Record create(Record Record) {
		log.info("Record " + Record.toString() + " was saved successfully.");
		return repo.saveAndFlush(Record);
	}

	@Override
	public Record get(Long id) {
		return repo.findOne(id);
	}

	@Override
	public Record update(Long id, Record Record) {
		Record existingRecord = repo.findOne(id);
		BeanUtils.copyProperties(Record, existingRecord);
		log.info("Record " + Record.toString() + " was updated successfully.");
		return repo.saveAndFlush(existingRecord);
	}

	@Override
	public Record delete(Long id) throws IOException {
		// remove record
		Record existingRecord = repo.findOne(id);
		repo.delete(existingRecord);
		
		log.info("Record " + existingRecord.toString() + " was deleted successfully.");
		
		// remove directory
		File directory = new File(uploadfilepath + "/" + id);
		FileUtils.deleteDirectory(directory);
		
		return existingRecord;
	}

	@Override
	public void singleFileUpload(MultipartFile file, Long id) {
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
            
            Record record = repo.findOne(id);
            log.info("The cover for " + record.toString() + " was uploaded successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
			e.printStackTrace();
		}				
	}

}
