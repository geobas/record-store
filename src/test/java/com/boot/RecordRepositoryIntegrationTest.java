package com.boot;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.record.shop.RecordStoreApplication;
import com.record.shop.model.Record;
import com.record.shop.repository.RecordRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(RecordStoreApplication.class)
public class RecordRepositoryIntegrationTest {

	@Autowired
	private RecordRepository repo;

	@Test
	public void testFindAll() {
		List<Record> records = repo.findAll();
		assertThat(records.size(), is(greaterThanOrEqualTo(0)));
	}
	
}
