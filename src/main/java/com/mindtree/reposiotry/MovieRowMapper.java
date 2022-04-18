package com.mindtree.reposiotry;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mindtree.dto.MovieDTO;

public class MovieRowMapper implements RowMapper<MovieDTO> {

	public MovieDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MovieDTO movie=new MovieDTO();
		movie.setLanguage(rs.getString("language"));
		movie.setMovieId(rs.getString("movieId"));
		movie.setReleasedIn(rs.getInt("releasedIn"));
		movie.setRevenueInDollars(rs.getInt("revenueInDollars"));
		movie.setMovieName(rs.getString("movieName"));
		return movie;
	}

}
