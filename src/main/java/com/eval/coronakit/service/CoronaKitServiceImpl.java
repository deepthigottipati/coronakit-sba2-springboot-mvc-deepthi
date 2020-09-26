package com.eval.coronakit.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eval.coronakit.dao.CoronaKitRepository;
import com.eval.coronakit.entity.CoronaKit;
import com.eval.coronakit.entity.ProductMaster;
import com.eval.coronakit.exception.CoronaException;

@Service
public class CoronaKitServiceImpl implements CoronaKitService {

	@Autowired
	CoronaKitRepository repository;
	
	@Override
	public CoronaKit saveKit(CoronaKit kit) throws CoronaException {
		if(kit!=null) {
			if(repository.existsById(kit.getId())) {
				throw new CoronaException("Item code already used!");
			}
			
			repository.save(kit);
		}
		return kit;
	}

	@Override
	public CoronaKit getKitById(int kitId) throws CoronaException {
		Optional<CoronaKit> result = repository.findById(kitId);

		CoronaKit theCoronaKit = null;

		if (result.isPresent()) {
			theCoronaKit = result.get();
		} else {
			throw new CoronaException("Did not find employee id - " + kitId);
		}

		return theCoronaKit;
	}

}
