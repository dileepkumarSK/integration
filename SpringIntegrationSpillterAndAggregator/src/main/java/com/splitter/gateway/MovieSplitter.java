package com.splitter.gateway;



import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

import com.splitter.pojo.Movie;


@MessagingGateway
public interface MovieSplitter {

	@Gateway(requestChannel = "movie.list.Spitter")
	Object proceed(Movie mv);
}
