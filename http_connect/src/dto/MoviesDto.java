package dto;

import java.util.ArrayList;

import lombok.Data;

@Data
class GenresList {
	private String Action;
	private String Drama;
	private String Thriller;
}

@Data
class MoviesList {
	private int id;
	private String url;
	private String imd_code;
	private String title;
	private String title_english;
	private String title_long;
	private String slug;
	private String year;
	private String rating;
	private String runtime;
	private ArrayList<GenresList> genresArray;
	private String summary;
	private String description_full;
	private String synopsis;
	private String yt_trailer_code;
	private String language;
	private String mpa_rating;
	private String background_image;
	private String background_image_original;
	private String small_cover_image;
	private String medium_cover_image;
	private String large_cover_image;
	private String state;
}

@Data
class DataObj {
	private String movies_count;
	private int limit;
	private int page_number;
	private ArrayList<MoviesList> moviesArray;
}

@Data
public class MoviesDto {
	private String status;
	private String status_message;
	private DataObj data;
}
