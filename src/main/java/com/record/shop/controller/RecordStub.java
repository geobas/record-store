package com.record.shop.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.record.shop.model.Record;

public class RecordStub {
	private static Map<Long, Record> wrecks = new HashMap<Long, Record>();
	private static Long idIndex = 3L;

	//populate initial wrecks
	static {
//		Record a = new Record(1L, "U869", "A very deep German UBoat", "FAIR", 200, 44.12, 138.44, 1994);
//		wrecks.put(1L, a);
//		Record b = new Record(2L, "Thistlegorm", "British merchant boat in the Red Sea", "GOOD", 80, 44.12, 138.44, 1994);
//		wrecks.put(2L, b);
//		Record c = new Record(3L, "S.S. Yongala", "A luxury passenger ship wrecked on the great barrier reef", "FAIR", 50, 44.12, 138.44, 1994);
//		wrecks.put(3L, c);
	}

	public static List<Record> list() {
		return new ArrayList<Record>(wrecks.values());
	}

	public static Record create(Record wreck) {
		idIndex += idIndex;
		wreck.setId(idIndex);
		wrecks.put(idIndex, wreck);
		return wreck;
	}

	public static Record get(Long id) {
		return wrecks.get(id);
	}

	public static Record update(Long id, Record wreck) {
		wrecks.put(id, wreck);
		return wreck;
	}

	public static Record delete(Long id) {
		return wrecks.remove(id);
	}
}
