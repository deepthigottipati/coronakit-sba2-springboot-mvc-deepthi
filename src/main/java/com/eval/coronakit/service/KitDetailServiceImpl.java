package com.eval.coronakit.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eval.coronakit.dao.KitDetailRepository;
import com.eval.coronakit.entity.KitDetail;
import com.eval.coronakit.entity.ProductMaster;
import com.eval.coronakit.exception.CoronaException;

@Service
public class KitDetailServiceImpl implements KitDetailService {

	@Autowired
	KitDetailRepository repository;
	
	@Override
	@Transactional
	public KitDetail addKitItem(KitDetail kitItem) throws CoronaException {
		
		if(kitItem!=null) {
			/*
			 * if(repository.existsById(kitItem.getId())) { throw new
			 * CoronaException("Item code already used!"); }
			 */
			
			repository.save(kitItem);
		}
		return kitItem;
	}

	
	@Override
	@Transactional
	public KitDetail getKitItemById(int itemId) throws CoronaException {
		Optional<KitDetail> result = repository.findById(itemId);

		KitDetail thekitDetail = null;

		if (result.isPresent()) {
			thekitDetail = result.get();
		} else {
			throw new CoronaException("Did not find item id - " + itemId);
		}

		return thekitDetail;
	}

	@Override
	@Transactional
	public List<KitDetail> getAllKitItemsOfAKit() {

		return repository.findAll();

	}
	
	@Override
	@Transactional
	public String deleteKitItem(int itemId) throws CoronaException {

		if(!repository.existsById(itemId)) {
			throw new CoronaException("Product Not Found");
		}
	
		repository.deleteById(itemId);
		
		return "Deleted product id - " + itemId;
		

	}

}
