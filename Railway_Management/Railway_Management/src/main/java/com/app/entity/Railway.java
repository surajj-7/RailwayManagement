package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Railway {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long r_id;
	
	@NotBlank(message="name can not be blank")
	private String r_name;
	
	@NotNull(message="category can not be blank")
	@Enumerated(EnumType.STRING)
	private Category category;
	
	@NotBlank(message="StartTime can not be blank")
	private String StartTime;
	
	@NotBlank(message="EndTime can not be blank")
	private String EndTime;
	
	@NotBlank(message="source can not be blank")
	private String source;
	
	@NotBlank(message="Destination can not be blank")
	private String Destination;
	
	@NotNull(message="station code can not be blank")
	private Long station_code;
	
	@NotNull(message="distance can not be blank")
	private Long Distance;
	
	@NotBlank(message="Frequency can not be blank")
	private String frequency;

	public Long getR_id() {
		return r_id;
	}

	public void setR_id(Long r_id) {
		this.r_id = r_id;
	}

	public String getR_name() {
		return r_name;
	}

	public void setR_name(String r_name) {
		this.r_name = r_name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getStartTime() {
		return StartTime;
	}

	public void setStartTime(String startTime) {
		StartTime = startTime;
	}

	public String getEndTime() {
		return EndTime;
	}

	public void setEndTime(String endTime) {
		EndTime = endTime;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return Destination;
	}

	public void setDestination(String destination) {
		Destination = destination;
	}

	public Long getStation_code() {
		return station_code;
	}

	public void setStation_code(Long station_code) {
		this.station_code = station_code;
	}

	public Long getDistance() {
		return Distance;
	}

	public void setDistance(Long distance) {
		Distance = distance;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	
	public Railway(Long r_id, @NotBlank(message = "name can not be blank") String r_name,
			@NotBlank(message = "category can not be blank") Category category,
			@NotBlank(message = "StartTime can not be blank") String startTime,
			@NotBlank(message = "EndTime can not be blank") String endTime,
			@NotBlank(message = "source can not be blank") String source,
			@NotBlank(message = "Destination can not be blank") String destination,
			@NotNull(message = "station code can not be blank") Long station_code,
			@NotNull(message = "distance can not be blank") Long distance,
			@NotBlank(message = "Frequency can not be blank") String frequency) {
		super();
		this.r_id = r_id;
		this.r_name = r_name;
		this.category = category;
		StartTime = startTime;
		EndTime = endTime;
		this.source = source;
		Destination = destination;
		this.station_code = station_code;
		Distance = distance;
		this.frequency = frequency;
	}
	
	

	public Railway() {
	}

	@Override
	public String toString() {
		return "Railway [  r_name=" + r_name + ", category=" + category + ", StartTime=" + StartTime
				+ ", EndTime=" + EndTime + ", source=" + source + ", Destination=" + Destination + " Distance=" + Distance + "]";
	}
	
}
