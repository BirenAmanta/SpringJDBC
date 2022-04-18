package com.mindtree.reposiotry;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.dto.MovieDTO;

@Repository
@Transactional
public class MovieRepositoryImpl implements MovieRepository {

	@Autowired
	JdbcTemplate jdbcTemplet;

	public MovieDTO findMovie(String movieId) {
		String query = "select * from movie where movieId=? ";
		MovieDTO data = jdbcTemplet.queryForObject(query, new MovieRowMapper(), new Object[] { movieId });
		return data;
	}

	public String addMovie(MovieDTO movieDTO) {
		String query = "INSERT INTO movie(movieId,movieName,language,releasedIn, revenueInDollars) VALUES(?,?,?,?,?)";
		jdbcTemplet.update(query,movieDTO.getMovieId() ,movieDTO.getMovieName(), movieDTO.getLanguage(),
				movieDTO.getReleasedIn(), movieDTO.getRevenueInDollars());
		if (findMovie(movieDTO.getMovieId()) != null) {
			return movieDTO.getMovieId();
		}
		return null;
	}

	public List<MovieDTO> getMovies(Integer year) {
		String queryResult = "select * from movie where releasedIn>=? ";
		List<MovieDTO> data = jdbcTemplet.query(queryResult, new MovieRowMapper(), new Object[] { year });
		return data;
	}

	public void updateRevenue(String movieId, Integer amount) {
		String queryResult = "update movie set revenueInDollars=? where movieId=?";
		jdbcTemplet.update(queryResult, new Object[] { amount, movieId });
	}

	public void deleteMovie(String movieId) {
		String queryResult = "delete from movie where movieId=?";
		jdbcTemplet.update(queryResult, new Object[] { movieId });
	}

}
