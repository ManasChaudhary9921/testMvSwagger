package com.demo.edlws.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Movie {
/*
	@Id
	@JsonIgnore
	Long iD;*/
	@Id
	String MovieId;
	String MovieName;
	String MovieType;
	String Language;
	@Column(length = 500)
	String Actors_Actresses;
	String ReleaseDate;
	String Year;
	String Type;
	String Rated;
	String Runtime;
	String Genre;
	String Director;
	@Column(name = "Writer", length = 1000)
	String Writer;
	
	@Column(name = "Plot", length = 3500)
	String Plot;
	String MovieImage;
	String Status;
	String Country;
	String Awards;
	String Metascore;
	String Wiki_Link;
	String ImdbRating;
	String ImdbVotes;
	String ImdbID;
	String Poster;
	String IsNew;
	String IsActive;
	String EntryDate;
	String ModifiedDate;
	String UpdateSongDate;
	String UpdateDialoguesDate;
	
	
	public String getMovieId() {
		return MovieId;
	}


	public void setMovieId(String movieId) {
		MovieId = movieId;
	}


	public String getMovieName() {
		return MovieName;
	}


	public void setMovieName(String movieName) {
		MovieName = movieName;
	}


	public String getMovieType() {
		return MovieType;
	}


	public void setMovieType(String movieType) {
		MovieType = movieType;
	}


	public String getLanguage() {
		return Language;
	}


	public void setLanguage(String language) {
		Language = language;
	}


	public String getActors_Actresses() {
		return Actors_Actresses;
	}


	public void setActors_Actresses(String actors_Actresses) {
		Actors_Actresses = actors_Actresses;
	}


	public String getReleaseDate() {
		return ReleaseDate;
	}


	public void setReleaseDate(String releaseDate) {
		ReleaseDate = releaseDate;
	}


	public String getYear() {
		return Year;
	}


	public void setYear(String year) {
		Year = year;
	}


	public String getType() {
		return Type;
	}


	public void setType(String type) {
		Type = type;
	}


	public String getRated() {
		return Rated;
	}


	public void setRated(String rated) {
		Rated = rated;
	}


	public String getRuntime() {
		return Runtime;
	}


	public void setRuntime(String runtime) {
		Runtime = runtime;
	}


	public String getGenre() {
		return Genre;
	}


	public void setGenre(String genre) {
		Genre = genre;
	}


	public String getDirector() {
		return Director;
	}


	public void setDirector(String director) {
		Director = director;
	}


	public String getWriter() {
		return Writer;
	}


	public void setWriter(String writer) {
		Writer = writer;
	}


	public String getPlot() {
		return Plot;
	}


	public void setPlot(String plot) {
		Plot = plot;
	}


	public String getMovieImage() {
		return MovieImage;
	}


	public void setMovieImage(String movieImage) {
		MovieImage = movieImage;
	}


	public String getStatus() {
		return Status;
	}


	public void setStatus(String status) {
		Status = status;
	}


	public String getCountry() {
		return Country;
	}


	public void setCountry(String country) {
		Country = country;
	}


	public String getAwards() {
		return Awards;
	}


	public void setAwards(String awards) {
		Awards = awards;
	}


	public String getMetascore() {
		return Metascore;
	}


	public void setMetascore(String metascore) {
		Metascore = metascore;
	}


	public String getWiki_Link() {
		return Wiki_Link;
	}


	public void setWiki_Link(String wiki_Link) {
		Wiki_Link = wiki_Link;
	}


	public String getImdbRating() {
		return ImdbRating;
	}


	public void setImdbRating(String imdbRating) {
		ImdbRating = imdbRating;
	}


	public String getImdbVotes() {
		return ImdbVotes;
	}


	public void setImdbVotes(String imdbVotes) {
		ImdbVotes = imdbVotes;
	}


	public String getImdbID() {
		return ImdbID;
	}


	public void setImdbID(String imdbID) {
		ImdbID = imdbID;
	}


	public String getPoster() {
		return Poster;
	}


	public void setPoster(String poster) {
		Poster = poster;
	}


	public String getIsNew() {
		return IsNew;
	}


	public void setIsNew(String isNew) {
		IsNew = isNew;
	}


	public String getIsActive() {
		return IsActive;
	}


	public void setIsActive(String isActive) {
		IsActive = isActive;
	}


	public String getEntryDate() {
		return EntryDate;
	}


	public void setEntryDate(String entryDate) {
		EntryDate = entryDate;
	}


	public String getModifiedDate() {
		return ModifiedDate;
	}


	public void setModifiedDate(String modifiedDate) {
		ModifiedDate = modifiedDate;
	}


	public String getUpdateSongDate() {
		return UpdateSongDate;
	}


	public void setUpdateSongDate(String updateSongDate) {
		UpdateSongDate = updateSongDate;
	}


	public String getUpdateDialoguesDate() {
		return UpdateDialoguesDate;
	}


	public void setUpdateDialoguesDate(String updateDialoguesDate) {
		UpdateDialoguesDate = updateDialoguesDate;
	}


	@Override
	public String toString() {
		return "Movie [MovieId=" + MovieId + ", MovieName=" + MovieName + ", MovieType=" + MovieType + ", Language="
				+ Language + ", Actors_Actresses=" + Actors_Actresses + ", ReleaseDate=" + ReleaseDate + ", Year="
				+ Year + ", Type=" + Type + ", Rated=" + Rated + ", Runtime=" + Runtime + ", Genre=" + Genre
				+ ", Director=" + Director + ", Writer=" + Writer + ", Plot=" + Plot + ", MovieImage=" + MovieImage
				+ ", Status=" + Status + ", Country=" + Country + ", Awards=" + Awards + ", Metascore=" + Metascore
				+ ", Wiki_Link=" + Wiki_Link + ", ImdbRating=" + ImdbRating + ", ImdbVotes=" + ImdbVotes + ", ImdbID="
				+ ImdbID + ", Poster=" + Poster + ", IsNew=" + IsNew + ", IsActive=" + IsActive + ", EntryDate="
				+ EntryDate + ", ModifiedDate=" + ModifiedDate + ", UpdateSongDate=" + UpdateSongDate
				+ ", UpdateDialoguesDate=" + UpdateDialoguesDate + "]";
	}
	
	
}
