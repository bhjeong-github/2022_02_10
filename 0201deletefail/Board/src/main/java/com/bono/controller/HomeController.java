package com.bono.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bono.domain.ReserveVO;
import com.bono.service.HomeService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
@Controller
@Log4j
@AllArgsConstructor
public class HomeController {
	
	@Autowired
	HomeService service;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		return "home";
	}
	
//	@PostMapping(value = "/reserve",
//				 consumes = "application/json",
//				 produces = MediaType.TEXT_PLAIN_VALUE)
//	public ResponseEntity<String> reserve(@RequestBody ReserveVO vo) {
//		int insertCount = service.reserve(vo);
//		log.info("" + vo);
//		return insertCount == 1 ?
//				new ResponseEntity<>("success", HttpStatus.OK) :
//					new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//	}
	@PostMapping(value = "/reserve", 
				 consumes = "application/json", 
				 produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> reserve(@RequestBody ReserveVO vo) {
        try {
            int result = service.reserve(vo);
            if (result == 1) {
                return new ResponseEntity<>("Success", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("An error occurred while trying to reserve", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
	
	@GetMapping(value = "/reserves/{reserveid}",
				produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ReserveVO> get(@PathVariable("reserveid")String reserveid) {
		log.info("get : " + reserveid);
		return new ResponseEntity<>(service.get(reserveid), HttpStatus.OK);
	}
	
	@PreAuthorize("principal.username == #vo.reserveid")
	@DeleteMapping(value = "/reserves/{reserveid}", 
				   produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@RequestBody ReserveVO vo, @PathVariable("reserveid")String reserveid) {
		log.info("remove : " + reserveid);
		log.info("reserveid : " + vo.getReserveid());
		return service.remove(reserveid) == 1
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping(value = "/reservation/{reserveid}", method = RequestMethod.GET)
    public ResponseEntity<?> checkReservation(@PathVariable String reserveid) {
        if(service.checkIfExists(reserveid)) {
            return new ResponseEntity<>("A reservation with this id already exists", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
	
	@RequestMapping(value = "/reservation/{date}/{title}/{time}", method = RequestMethod.GET)
    public ResponseEntity<?> checkOverlap(@PathVariable("date") String date,
    									  @PathVariable("title") String title, 
    									  @PathVariable("time") String time) {
        if(service.checkReservationExists(date, title, time)) {
            return new ResponseEntity<>("A same reservation already exists", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
	
}
