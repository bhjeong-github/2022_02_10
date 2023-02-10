package com.bono.service;

import com.bono.domain.ReserveVO;

public interface HomeService {
	
	public int reserve(ReserveVO vo);
	
	public ReserveVO get(String reserveid);
	
	public int remove(String reserveid);
	
	public boolean checkIfExists(String reserveid);
	
	public boolean checkReservationExists(String date, String title, String time);
}
