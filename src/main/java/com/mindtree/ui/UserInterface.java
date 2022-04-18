package com.mindtree.ui;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.env.Environment;

import com.mindtree.dto.MovieDTO;
import com.mindtree.config.JdbcConfig;
import com.mindtree.service.MovieService;

public class UserInterface {

	 static Environment  ev;
	 static MovieService movieService;
	static AbstractApplicationContext ac;
	 static final Logger LOGGER=Logger.getLogger(UserInterface.class);
	public static void main(String args[])
	{
		ac=new AnnotationConfigApplicationContext(JdbcConfig.class);
		ev=ac.getEnvironment();
		movieService=ac.getBean(MovieService.class);
		getAllMovie();
		getMovie();
		addMovie();
		updateRevenue();
		deleteMovie();
		ac.close();
	}
	static void getMovie() {
		try {
			MovieDTO movieDTO = movieService.findMovie("M1001");
			if(movieDTO!=null){
			LOGGER.info(movieDTO);
			}
			else
				LOGGER.info(ev.getProperty("UserInterface.MOVIE_NOT_FOUND"));
		} catch (Exception e) {
			LOGGER.info(ev.getProperty(e.getMessage(), "Some exception occured.Please check log file."));
		}
	}
	static void getAllMovie() {
		try {
			List<MovieDTO> movieDTO = movieService.getMovies(0);
			if(movieDTO!=null){
			LOGGER.info(movieDTO);
			}
			else
				LOGGER.info(ev.getProperty("UserInterface.MOVIE_NOT_FOUND"));
		} catch (Exception e) {
			LOGGER.info(ev.getProperty(e.getMessage(), "Some exception occured.Please check log file."));
		}
	}

	static void addMovie() {
		try {
			MovieDTO movieDTO = new MovieDTO();
			movieDTO.setMovieId("M1006");
			movieDTO.setMovieName("The Terminator");
			movieDTO.setLanguage("English");
			movieDTO.setReleasedIn(1984);
			movieDTO.setRevenueInDollars(87000000);
			String movieId = movieService.addMovie(movieDTO);
			LOGGER.info(ev.getProperty("UserInterface.INSERT_SUCCESS") + movieId);
		} catch (Exception e) {
			LOGGER.info(ev.getProperty(e.getMessage(), "Some exception occured.Please check log file."));
		}
	}

	static void updateRevenue() {
		try {
			movieService.updateRevenue("M1006",100000);
			LOGGER.info(ev.getProperty("UserInterface.UPDATE_SUCCESS"));
		} catch (Exception e) {
			LOGGER.info(e);
			LOGGER.info(ev.getProperty(e.getMessage(), "Some exception occured.Please check log file."));
		}
	}

	static void deleteMovie() {
		try {
			movieService.deleteMovie("M1006");
			LOGGER.info(ev.getProperty("UserInterface.DELETE_SUCCESS"));
		} catch (Exception e) {
			LOGGER.info(ev.getProperty(e.getMessage(), "Some exception occured.Please check log file."));
		}
	}

}
