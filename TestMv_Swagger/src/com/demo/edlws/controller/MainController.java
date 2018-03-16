package com.demo.edlws.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import javax.persistence.EntityManagerFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.cglib.core.Predicate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.edlws.dto.MovieDetail;
import com.demo.edlws.entity.Movie;
import com.demo.edlws.repo.MovieRepo;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;

@RestController
@RequestMapping(value="/jpa", method=RequestMethod.GET)
@Transactional(rollbackFor= InterruptedException.class,isolation = Isolation.READ_UNCOMMITTED , propagation = Propagation.REQUIRED)
public class MainController {

	@Autowired
	EntityManagerFactory emf;
	
	@Autowired
	MovieRepo mvRepo;
	
	@RequestMapping(value="/addAll/{start}" , method=RequestMethod.POST)
	public ResponseEntity<Object> äddAllCustomer(@PathVariable int start){
		process(start);
		return new ResponseEntity<Object>("Added ALL",org.springframework.http.HttpStatus.CREATED) ;
	}
	
	
	public void process(int start){
    	WebDriver driver =null;
		try {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver= new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("SAMPLETESTLINK"+start);
			
			//String content = /*driver.findElement(By.xpath("string")).getText();*/ driver.getPageSource().substring(driver.getPageSource().indexOf("[{"));
			String content= driver.getPageSource();
			content=content.substring(content.indexOf("[{"), content.indexOf("</string>"));
			//System.out.println(content);
			
			
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			objectMapper.setVisibilityChecker(VisibilityChecker.Std.defaultInstance().withFieldVisibility(Visibility.ANY));
			
			List<Movie> navigation = objectMapper.readValue(content,objectMapper.getTypeFactory().constructCollectionType(List.class, Movie.class));

			for(Movie m: navigation){
				System.out.println(m);
			}
			
			mvRepo.save(navigation);
			
			driver.close();
			driver.quit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.close();
			driver.quit();
		}
    }
	
	@Cacheable(value="movieDb")
	@GetMapping("/getAllMovies")
	public ResponseEntity<Object> getAllMovieNamesAndThumbnails() {
		List<Movie>result= mvRepo.findAll();
		List<MovieDetail>mvdetails= new ArrayList<MovieDetail>();
		for(Movie mv:result){
			MovieDetail mvd= new MovieDetail();
			mvd.setMovieName(mv.getMovieName());
			mvd.setPoster(mv.getPoster());
			mvdetails.add(mvd);
		}
		return new ResponseEntity<Object>(mvdetails, HttpStatus.OK);
	}
	
	@GetMapping(value="/getAllCat", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<String> getAllCategories(){
		List<String> result= mvRepo.findDistinctGenre();
		Set<String> strSet= new HashSet<String>();
		for(String str: result){
			strSet.addAll(Arrays.asList(str.split(",")).stream().map(String::trim).filter(line -> !"N/A".equals(line)).collect(Collectors.toList()));
		}
		result.clear();

		Iterator<String> itr= strSet.iterator();
		while(itr.hasNext()){
			result.add(itr.next());
		}
		
		return result;
	}
	
}
