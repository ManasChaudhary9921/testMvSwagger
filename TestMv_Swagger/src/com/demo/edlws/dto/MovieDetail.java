package com.demo.edlws.dto;

import org.springframework.data.repository.NoRepositoryBean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

public class MovieDetail{

String MovieName;
String Poster;

public String getMovieName() {
	return MovieName;
}
public void setMovieName(String movieName) {
	MovieName = movieName;
}
public String getPoster() {
	return Poster;
}
public void setPoster(String poster) {
	Poster = poster;
}

}
