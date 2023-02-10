package com.bono.service;

import org.springframework.stereotype.Service;

import com.bono.domain.ReserveVO;
import com.bono.mapper.HomeMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class HomeServiceImpl implements HomeService {
	
	private HomeMapper mapper;
	
	@Override
	public int reserve(ReserveVO vo) {
		checkIfExists(vo.getReserveid());
		log.info("reserve.........." + vo);
		return mapper.reserve(vo);
		
	}

	@Override
	public ReserveVO get(String reserveid) {
		log.info("get........." + reserveid);
		return mapper.read(reserveid);
	}

	@Override
	public int remove(String reserveid) {
		log.info("remove......." + reserveid);
		ReserveVO vo = mapper.read(reserveid);
		
		return mapper.delete(reserveid);
	}
	
	@Override
	public boolean checkIfExists(String reserveid) {
		log.info("checkIfExists........");
	    int count = mapper.existsById(reserveid);
	    if (count > 0) {
	        return true;
	    }
	    return false;
	}

	@Override
	public boolean checkReservationExists(String date, String title, String time) {
		log.info("checkReservationExists............");
        int count = mapper.existsBySameService(date, title, time);
        
        return count > 0;
    }

	
	

}
