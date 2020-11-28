package com.example.movierecord.controller;

import com.example.movierecord.domain.Movie;
import com.example.movierecord.domain.Rating;
import com.example.movierecord.form.MovieSearchForm;
import com.example.movierecord.service.MovieService;
import com.example.movierecord.service.MovieServiceImpl;
import com.example.movierecord.service.RatingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MoviesController {

    @Autowired
    private MovieServiceImpl movieService;

    @Autowired
    private RatingServiceImpl ratingService;


    /**
     * listed all movie records saved
     *
     * @param pageable
     * @param model
     * @return
     */
    @GetMapping("/movies")
    public String listAll(@PageableDefault(size = 20, sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable,
                          Model model) {
        Page<Movie> page1 = movieService.showAllMoviesByPage(pageable);
        model.addAttribute("page", page1);
        return "movies";
    }


    /**
     * get one movie record
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/movies/{id}")
    public String getMovieInfo(@PathVariable long id, Model model) {
        Movie movie = movieService.showMovieById(id);
        if (movie == null) {
            movie = new Movie();
        }
        model.addAttribute("movie", movie);
        return "movie";
    }

    /**
     * get the movie record input page
     *
     * @param model
     * @return
     */
    @GetMapping("/movies/input")
    public String inputPage(Model model) {
        model.addAttribute("movie", new Movie());
        return "input";
    }

    /**
     * edit one movie record
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/movies/{id}/input")
    public String editMovie(@PathVariable long id, Model model) {
        Movie movie = movieService.showMovieById(id);
        model.addAttribute("movie", movie);
        return "input";
    }

    /**
     * post one movie record
     *
     * @param movie
     * @param attributes
     * @return
     */
    @PostMapping("/movies")
    public String post(Movie movie, final RedirectAttributes attributes) {
        Movie movieSaved = movieService.saveMovie(movie);
        if (movieSaved != null) {
            attributes.addFlashAttribute("message", "Update Success");
        }
        return "redirect:/movies";
    }


    /**
     * remove one movie record
     *
     * @param id
     * @param attributes
     * @return
     */
    @GetMapping("/movies/{id}/delete")
    public String deleteMovie(@PathVariable long id,
                              final RedirectAttributes attributes) {
        movieService.deleteMovieById(id);
        attributes.addFlashAttribute("message", "Delete Success");
        return "redirect:/movies";
    }

    /**
     * get the search page
     *
     * @param model
     * @return
     */
    @GetMapping("/search")
    public String searchPage(Model model) {
        model.addAttribute("searchForm", new MovieSearchForm());
        return "search";
    }

    /**
     * perform the searching
     *
     * @param form
     * @param pageable
     * @param model
     * @return
     */
    @PostMapping("/search")
    public String listMoviesBySearch(MovieSearchForm form, Pageable pageable, Model model) {
        String title = form.getTitle();
        String country = form.getCountry();
        String genre = form.getGenre();
        String director = form.getDirector();

        Page<Movie> page = movieService.queryBy(title, country, genre, director, pageable);
        model.addAttribute("page", page);
        return "searchresult";
    }

    /**
     * get all rating records for that movie
     *
     * @param id
     * @param pageable
     * @param model
     * @return
     */
    @GetMapping("movies/{id}/ratings")
    public String getRatings(@PathVariable long id, Pageable pageable, Model model) {
        Page<Rating> ratingList = ratingService.showAllRatingsByPage(id, pageable);
        model.addAttribute("page", ratingList);
        return "ratings";
    }

    /**
     * get the rating input page
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/movies/{id}/ratingInput")
    public String ratingInputPage(@PathVariable long id, Model model) {
        Rating rating = new Rating();
        rating.setMovie(movieService.showMovieById(id));
        model.addAttribute("rating", rating);
        return "ratingInput";
    }

    /**
     * post one rating record
     *
     * @param rating
     * @return
     */
    @PostMapping("movies/{id}/ratings")
    public String postRating(Rating rating) {
        Rating ratingSaved = ratingService.saveRating(rating);
        return "redirect:/movies/{id}/ratings";
    }

}
