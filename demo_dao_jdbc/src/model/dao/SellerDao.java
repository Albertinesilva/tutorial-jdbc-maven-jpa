package model.dao;

import java.util.List;

import model.entities.Seller;

public interface SellerDao {

	void insert(Seller obj);

	void update(Seller obj);

	void deleltById(Integer id);

	Seller findBYId(Integer id);

	List<Seller> findAll();
}
