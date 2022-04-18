package com.mindtree.reposiotry;

import java.util.List;

import com.mindtree.dto.MovieDTO;

public interface MovieRepository {
	public MovieDTO findMovie(String movieId);
	public String addMovie (MovieDTO movieDTO) ;
	public List<MovieDTO> getMovies (Integer year) ;
	public void updateRevenue (String movieId, Integer amount) ;
	public void deleteMovie(String movieId);
}
