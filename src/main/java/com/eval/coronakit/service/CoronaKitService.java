package com.eval.coronakit.service;

import com.eval.coronakit.entity.CoronaKit;
import com.eval.coronakit.exception.CoronaException;

public interface CoronaKitService {
	public CoronaKit saveKit(CoronaKit kit) throws CoronaException;
	public CoronaKit getKitById(int kitId) throws CoronaException;
}
