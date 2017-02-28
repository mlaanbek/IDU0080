package com.idu0080.services;

import java.util.List;

import com.idu0080.entities.Wash;

public interface WashServices {
	public List<Wash> getAllWashes();
	public Wash getWashById(String wash_id);
	public void deleteWash(String wash_id);
	public boolean createOrUpdateWash(Wash wash);
	public List<Wash> searchByWashType(String washType);
}
