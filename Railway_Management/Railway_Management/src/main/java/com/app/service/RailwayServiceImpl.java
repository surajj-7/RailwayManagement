package com.app.service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Category;
import com.app.entity.Railway;
import com.app.exception.RailwayException;
import com.app.repository.RailwayDAO;

@Service
@Transactional
public class RailwayServiceImpl implements RailwayService {
    
	@Autowired
	private RailwayDAO railwaydao;
	
	@Override
	public Railway addRailway(Railway railway) {
		validTimeRange(railway.getStartTime(),railway.getEndTime());
		return railwaydao.save(railway);
	}

	@Override
	public void deleteRailway(Long id) {
      railwaydao.deleteById(id);
	}

	@Override
	public List<Railway> getAllRailway(Category c) {
		return railwaydao.findByCategory(c);
	}
	
	public List<Railway> payloadRailway()
	{
		return railwaydao.findAll();
	}
	
	public void validTimeRange(String start,String end)
	{
		DateTimeFormatter df=DateTimeFormatter.ofPattern("HH:mm");
		LocalTime st=LocalTime.parse(start,df);
		LocalTime et=LocalTime.parse(end,df);
		if(st.isAfter(et))
		{
			throw new RailwayException("Start date should before end date");
		}
		
	}

	@Override
	public void updateRailway( Railway railway) {
		/*Optional<Railway>optional=railwaydao.findById(id);
		
		Railway rail=optional.get();
		rail.setR_id(railway.getR_id());
		rail.setR_name(railway.getR_name());
		rail.setCategory(railway.getCategory());
		rail.setDestination(railway.getDestination());
		rail.setDistance(railway.getDistance());
		rail.setEndTime(railway.getEndTime());
		rail.setStartTime(railway.getStartTime());
		rail.setFrequency(railway.getFrequency());
		rail.setSource(railway.getSource());
		
		railwaydao.save(rail);*/
		railwaydao.save(railway);
		
	}
	
	public List<Railway> sortRailway()
	{
		List<Railway>rail=railwaydao.findAll();
		rail.sort(Comparator.comparing(r->r.getCategory().name()));
		return rail;
	}

}
