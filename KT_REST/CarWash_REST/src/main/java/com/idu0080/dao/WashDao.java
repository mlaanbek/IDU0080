package com.idu0080.dao;

import java.util.List;

import com.idu0080.entities.Wash;

public interface WashDao {
	public List<Wash> getAllWashes();
	public Wash getWashById(String wash_id);
	public void deleteWash(String wash_id);
	public boolean createOrUpdateWash(Wash wash);
	public List<Wash> searchByWashType(String washType);
}
