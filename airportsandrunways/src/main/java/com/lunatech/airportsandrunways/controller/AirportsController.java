package com.lunatech.airportsandrunways.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lunatech.airportsandrunways.model.Airport;
import com.lunatech.airportsandrunways.model.Country;
import com.lunatech.airportsandrunways.model.Pager;
import com.lunatech.airportsandrunways.model.Runway;
import com.lunatech.airportsandrunways.model.SuggestionWrapper;
import com.lunatech.airportsandrunways.service.AirportService;
import com.lunatech.airportsandrunways.service.CountryService;
import com.lunatech.airportsandrunways.service.RunwayService;

@Controller
public class AirportsController {

	private CountryService countryService;
	private AirportService airportService;
	private RunwayService runwayService;
	
    private static final int BUTTONS_TO_SHOW = 3;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 5;
    private static final int[] PAGE_SIZES = { 5, 10};
	
	@Autowired
	public AirportsController(CountryService countryService, AirportService airportService, RunwayService runwayService) {
		this.countryService = countryService;
		this.airportService = airportService;
		this.runwayService = runwayService;
	}
	
	  // http://localhost:8080
	  // basic site
	  @GetMapping("/")
	  public String autocomplete(ModelAndView modelAndView) {
		  modelAndView.addObject("title", "airport search");
		  modelAndView.addObject("autocomplete-input", "");
	
	    return "airportsearch";
	  }

	/**
	 * Choosing Reports will print 
	 * 1.  10 countries with highest number of airports 
	 * (with count) and countries with lowest number of airports.
	 * 2.  Type of runways (as indicated in "surface" column) per country
	 * 3.  Bonus: Print the top 10 most common runway identifications 
	 * (indicated in "le_ident" column)
	 * 
	 * @return
	 */
	@GetMapping("/reports")
	public ModelAndView reports() {
		List<Map<String, Integer>> countriesWithMost = countryService.getCountriesWithMostAirports();//PageRequest.of(0, 10)).getContent(
		List<Map<String, Integer>> countriesWithLeast = countryService.getCountriesWithLeastAirports();
		List<String> runwaySurfaces = runwayService.getDistinctSurfaces();
		List<Map<Integer, Integer>> commonRunwayIdentifications = runwayService.getCommonIdentifications();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("countriesWithMost", countriesWithMost);
		modelAndView.addObject("countriesWithLeast", countriesWithLeast);
		modelAndView.addObject("runwaySurfaces", runwaySurfaces);
		modelAndView.addObject("identifications", commonRunwayIdentifications);
		modelAndView.setViewName("reports");
		return modelAndView;
	}

	/**
	 * Choosing Reports will print 
	 * 1.  10 countries with highest number of airports 
	 * (with count) and countries with lowest number of airports.
	 * 2.  Type of runways (as indicated in "surface" column) per country
	 * 3.  Bonus: Print the top 10 most common runway identifications 
	 * (indicated in "le_ident" column)
	 * 
	 * @return
	 */
	@GetMapping("/mostreport")
	public ModelAndView mostreport() {
		List<Map<String, Integer>> countriesWithMost = countryService.getCountriesWithMostAirports();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("countriesWithMost", countriesWithMost);
		modelAndView.setViewName("mostreport");
		return modelAndView;
	}

	/**
	 * Choosing Reports will print 
	 * 1.  10 countries with highest number of airports 
	 * (with count) and countries with lowest number of airports.
	 * 2.  Type of runways (as indicated in "surface" column) per country
	 * 3.  Bonus: Print the top 10 most common runway identifications 
	 * (indicated in "le_ident" column)
	 * 
	 * @return
	 */
	@GetMapping("/fewestreport")
	public ModelAndView fewestreport() {
		
		List<Map<String, Integer>> countriesWithLeast = countryService.getCountriesWithLeastAirports();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("countriesWithLeast", countriesWithLeast);
		modelAndView.setViewName("fewestreport");
		return modelAndView;
	}

	/**
	 * Choosing Reports will print 
	 * 1.  10 countries with highest number of airports 
	 * (with count) and countries with lowest number of airports.
	 * 2.  Type of runways (as indicated in "surface" column) per country
	 * 3.  Bonus: Print the top 10 most common runway identifications 
	 * (indicated in "le_ident" column)
	 * 
	 * @return
	 */
	@GetMapping("/surfacesreport")
	public ModelAndView surfacesreport() {
		List<String> runwaySurfaces = runwayService.getDistinctSurfaces();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("runwaySurfaces", runwaySurfaces);
		modelAndView.setViewName("surfacesreport");
		return modelAndView;
	}

	/**
	 * Choosing Reports will print 
	 * 1.  10 countries with highest number of airports 
	 * (with count) and countries with lowest number of airports.
	 * 2.  Type of runways (as indicated in "surface" column) per country
	 * 3.  Bonus: Print the top 10 most common runway identifications 
	 * (indicated in "le_ident" column)
	 * 
	 * @return
	 */
	@GetMapping("/identsreport")
	public ModelAndView identsreport() {
		List<Map<Integer, Integer>> commonRunwayIdentifications = runwayService.getCommonIdentifications();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("identifications", commonRunwayIdentifications);
		modelAndView.setViewName("identsreport");
		return modelAndView;
	}
	  
	// http://localhost:8080/autoreports?searchstr=bra
	@RequestMapping(value ="/autoreports", method = RequestMethod.GET, produces ="application/json")
	@ResponseBody
	public SuggestionWrapper autocompleteQuery(@RequestParam("airportstr") String airportstr) {
	    System.out.println("airportstr: " + airportstr);


	    ArrayList<Country> suggestions = new ArrayList<>();

	    List<Country> countries = countryService.getAllCountries();

	    for (Country country : countries) {
	      // add all countries to the arraylist
	      // if on the query string	      
	      if (country.getName().toLowerCase().contains(airportstr.toLowerCase())) {
	        suggestions.add(country);
	      }
	    }

	    // truncate the list to the first n, max 20 elements
	    int n = suggestions.size() > 20 ? 20 : suggestions.size();
	    List<Country> sulb = new ArrayList<>(suggestions.subList(0, n));

	    SuggestionWrapper sw = new SuggestionWrapper();
	    sw.setSuggestions(sulb);
	    return sw;
	}
	
	/**
	 * Query Option will ask the user for the country name or code and 
	 * print the airports & runways at each airport. 
	 * The input can be country code or country name.
	 *  For bonus points make the test partial/fuzzy. 
	 *  e.g. entering zimb will result in Zimbabwe :)
	 *  
	 * @return
	 */
	@PostMapping("/query")
	public ModelAndView query(ModelAndView modelAndView, 
			@RequestParam(required=false,name="autocomplete-input") String countryName,
			@RequestParam("pageSize") Optional<Integer> pageSize,
            @RequestParam("page") Optional<Integer> page) {
		//List<Airport>airports = airportService.getAirportByCode(countryName);		

        //
        // Evaluate page size. If requested parameter is null, return initial
        // page size
        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        // Evaluate page. If requested parameter is null or less than 0 (to
        // prevent exception), return initial size. Otherwise, return value of
        // param. decreased by 1.
        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
        
		
		System.out.println("countryName: " +countryName);
		Country country = countryService.getCountryByName(countryName);
		System.out.println("country: " +country);
		
		
		Page<Airport> airports = airportService.findByCountryCode(country.getCode(), PageRequest.of(evalPage, evalPageSize));
		Pager pager = new Pager(airports.getTotalPages(),airports.getNumber(),BUTTONS_TO_SHOW);
		modelAndView.addObject("country", country);
		modelAndView.addObject("airports", airports);
        // evaluate page size
        modelAndView.addObject("selectedPageSize", evalPageSize);
        // add page sizes
        modelAndView.addObject("pageSizes", PAGE_SIZES);
        // add pager
        modelAndView.addObject("pager", pager);
		
		return modelAndView;
	}
	
	@GetMapping("/query")
	public ModelAndView queryGet(ModelAndView modelAndView, 
			@RequestParam("countryName") String countryName,
			@RequestParam("pageSize") Optional<Integer> pageSize,
            @RequestParam("page") Optional<Integer> page) {
        // Evaluate page size. If requested parameter is null, return initial
        // page size
        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        // Evaluate page. If requested parameter is null or less than 0 (to
        // prevent exception), return initial size. Otherwise, return value of
        // param. decreased by 1.
        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;		
		Country country = countryService.getCountryByName(countryName);
		Page<Airport> airports = airportService.findByCountryCode(country.getCode(), PageRequest.of(evalPage, evalPageSize));
		System.out.println("country: "+country);
		System.out.println("airports: "+airports);
		Pager pager = new Pager(airports.getTotalPages(),airports.getNumber(),BUTTONS_TO_SHOW);
		modelAndView.addObject("country", country);
		modelAndView.addObject("airports", airports);
        // evaluate page size
        modelAndView.addObject("selectedPageSize", evalPageSize);
        // add page sizes
        modelAndView.addObject("pageSizes", PAGE_SIZES);
        // add pager
        modelAndView.addObject("pager", pager);
		modelAndView.setViewName("query");
		return modelAndView;
	}
	
	/*@PostMapping("/query_")
	public ModelAndView query_(ModelAndView modelAndView, 
			@RequestParam(required=false,name="autocomplete-input") String countryName) {
		
		//List<Airport>airports = airportService.getAirportByCode(countryName);	
		
		System.out.println("countryName: " +countryName);
		Country country = countryService.getCountryByName(countryName);
		System.out.println("country: " +country);
		
		
		List<Airport> airports = airportService.findByCountryCode(country.getCode());
		modelAndView.addObject("country", country);
		modelAndView.addObject("airports", airports);
		
		return modelAndView;
	}*/
	
	@GetMapping("/airport/{id}")
	public ModelAndView airport(@PathVariable Integer id){
		Optional<Airport> airportOptional = airportService.getAirportById(id);
		Airport airport=airportOptional.get();
		List<Runway> runways = runwayService.getRunwayByAirportId(airport.getId());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("airport", airport);
		modelAndView.addObject("runways", runways);
		modelAndView.setViewName("airport");
		return modelAndView;
	}
}
