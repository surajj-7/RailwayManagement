package com.app.service;


import java.util.List;

import com.app.entity.Category;
import com.app.entity.Railway;

public interface RailwayService {
	
	public Railway addRailway(Railway railway);
	
	public void deleteRailway(Long id);
	
	public List<Railway> getAllRailway(Category c);
	
	public List<Railway> payloadRailway();
	
	void updateRailway(Railway railway);
	
	List<Railway> sortRailway();
	
	
	
}
