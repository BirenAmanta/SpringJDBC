package com.mindtree.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.dto.MovieDTO;
import com.mindtree.exception.MovieBankException;
import com.mindtree.reposiotry.MovieRepository;
@Service
public class MovieServiceImpl implements MovieService {
	@Autowired
	MovieRepository movieRepository;
	
	
	public MovieDTO findMovie(String movieId) throws MovieBankException {
		MovieDTO data=movieRepository.findMovie(movieId);
		if(data==null)
		{
			throw new MovieBankException("Service.MOVIE_UNAVAILABLE");
		}
		return data;
	}

	public String addMovie(MovieDTO movieDTO) throws MovieBankException {
		if(movieRepository.findMovie(movieDTO.getMovieId())!=null)
		{
			throw new MovieBankException("Service.MOVIE_AVAILABLE");
		}
		String movieId=movieRepository.addMovie(movieDTO);
		return movieId;
	}

	public List<MovieDTO> getMovies(Integer year) throws MovieBankException {
		List<MovieDTO>data=movieRepository.getMovies(year);
		if(data==null)
		{
			throw new MovieBankException("Service.NO_MOVIE_RELEASED");
		}
		return data;
	}

	public void updateRevenue(String movieId, Integer amount) throws MovieBankException {
		if(movieRepository.findMovie(movieId)!=null)
		{
			movieRepository.updateRevenue(movieId, amount);
		}
		
	}

	public void deleteMovie(String movieId) throws MovieBankException {
		if(movieRepository.findMovie(movieId)!=null)
		{
			movieRepository.deleteMovie(movieId);
		}
		
	}

}
