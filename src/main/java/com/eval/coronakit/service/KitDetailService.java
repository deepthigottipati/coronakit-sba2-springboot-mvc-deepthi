package com.eval.coronakit.service;

import java.util.List;

import com.eval.coronakit.entity.KitDetail;
import com.eval.coronakit.exception.CoronaException;

public interface KitDetailService {
	public KitDetail addKitItem(KitDetail kitItem) throws CoronaException;
	public KitDetail getKitItemById(int itemId) throws CoronaException;
	public List<KitDetail> getAllKitItemsOfAKit();
	String deleteKitItem(int itemId) throws CoronaException;
}
