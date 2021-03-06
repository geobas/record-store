package com.record.shop.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.record.shop.model.Record;

public interface RecordService {
	List<Record> list();
	Record create(Record Record);
	Record get(Long id);
	Record update(Long id, Record Record);
	Record delete(Long id) throws IOException;
	void singleFileUpload(MultipartFile file, Long id);
}
