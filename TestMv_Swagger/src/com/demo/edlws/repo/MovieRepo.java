package com.demo.edlws.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.edlws.dto.MovieDetail;
import com.demo.edlws.entity.Movie;

public interface MovieRepo extends JpaRepository<Movie, String> {

	@Query(value="select Distinct m.Genre from Movie m ", nativeQuery=true)
	public List<String> findDistinctGenre();
	
}
