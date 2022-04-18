package com.mindtree.service;

import java.util.List;

import com.mindtree.dto.MovieDTO;
import com.mindtree.exception.MovieBankException;

public interface MovieService {
	public MovieDTO findMovie(String movieId) throws MovieBankException ;
	public String addMovie (MovieDTO movieDTO) throws MovieBankException ;
	public List<MovieDTO> getMovies (Integer year) throws MovieBankException ;
	public void updateRevenue (String movieId, Integer amount) throws MovieBankException ;
	public void deleteMovie(String movieId) throws MovieBankException ;
}
