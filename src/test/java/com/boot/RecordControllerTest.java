package com.boot;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.record.shop.controller.RecordController;
import com.record.shop.model.Record;
import com.record.shop.repository.RecordRepository;

public class RecordControllerTest {
	@InjectMocks
	private RecordController sc;

	@Mock
	private RecordRepository repo;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void testRecordGet() {
    	Record rec = new Record();
    	rec.setId(1l);
		when(repo.findOne(1l)).thenReturn(rec);

		Record wreck = sc.get(1L);

		verify(repo).findOne(1l);		

//		assertEquals(1l, wreck.getId().longValue());	
		assertThat(wreck.getId(), is(1l));
	}

}
