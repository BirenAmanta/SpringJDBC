package com.mindtree.dto;

public class MovieDTO {
	private String movieId;
	private String movieName;
	private String language;
	private Integer releasedIn;
	private Integer revenueInDollars;
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Integer getReleasedIn() {
		return releasedIn;
	}
	public void setReleasedIn(Integer releasedIn) {
		this.releasedIn = releasedIn;
	}
	public Integer getRevenueInDollars() {
		return revenueInDollars;
	}
	public void setRevenueInDollars(Integer revenueInDollars) {
		this.revenueInDollars = revenueInDollars;
	}
	@Override
	public String toString() {
		return "MovieDTO [movieId=" + movieId + ", movieName=" + movieName + ", language=" + language + ", releasedIn="
				+ releasedIn + ", revenueInDollars=" + revenueInDollars + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((movieId == null) ? 0 : movieId.hashCode());
		result = prime * result + ((movieName == null) ? 0 : movieName.hashCode());
		result = prime * result + ((releasedIn == null) ? 0 : releasedIn.hashCode());
		result = prime * result + ((revenueInDollars == null) ? 0 : revenueInDollars.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovieDTO other = (MovieDTO) obj;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (movieId == null) {
			if (other.movieId != null)
				return false;
		} else if (!movieId.equals(other.movieId))
			return false;
		if (movieName == null) {
			if (other.movieName != null)
				return false;
		} else if (!movieName.equals(other.movieName))
			return false;
		if (releasedIn == null) {
			if (other.releasedIn != null)
				return false;
		} else if (!releasedIn.equals(other.releasedIn))
			return false;
		if (revenueInDollars == null) {
			if (other.revenueInDollars != null)
				return false;
		} else if (!revenueInDollars.equals(other.revenueInDollars))
			return false;
		return true;
	}
	
}
