package com.record.shop.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.record.shop.model.Record;
import com.record.shop.repository.RecordRepository;

@Service
public class RecordServiceImpl implements RecordService {

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
		return repo.saveAndFlush(existingRecord);
	}

	@Override
	public Record delete(Long id) throws IOException {
		// remove record
		Record existingRecord = repo.findOne(id);
		repo.delete(existingRecord);
		
		// remove directory
		File directory = new File(uploadfilepath + "/" + id);
		FileUtils.deleteDirectory(directory);
		
		return existingRecord;
	}

}
