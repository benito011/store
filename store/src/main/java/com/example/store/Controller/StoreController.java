package com.example.store.Controller;
import java.util.List;
import java.util.Optional;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.store.Reporistory.StoreRepository;
import com.example.store.model.Store;

@RestController
@RequestMapping("/api")
public class StoreController {

	@Autowired
	private StoreRepository storeRepository;


	@GetMapping("/store")
	public List<Store> getAllProducts() {
		return storeRepository.findAll();
	}

 @PostMapping("/store")
public Store createStore(@RequestBody Store store) {
	 return storeRepository.save(store);
 }

@PutMapping("/store/{id}")
public ResponseEntity<Store> store(@PathVariable(value = "id") Integer storeId,
   @RequestBody Store storeDetails) {
     Optional<Store> stores = storeRepository.findById(storeId);
     Store store=stores.get();
     store.setProduct(storeDetails.getProduct());
     store.setPrice(storeDetails.getPrice());
     store.setExpirtyDate(storeDetails.getExpirtyDate());
     store.setManufacturingDate(storeDetails.getManufacturingDate());
     store.setSale(storeDetails.getSale());
     final Store updatedstore = storeRepository.save(store);
     return ResponseEntity.ok(updatedstore);
}

@DeleteMapping("store/{id}")
public Map storedelete(@PathVariable(value = "id") Integer storeId,
		@RequestBody Store storeDetails) {
    Optional<Store> stores = storeRepository.findById(storeId);
    Store store=stores.get();
    storeRepository.delete(store);
	return null;
    
}
}



