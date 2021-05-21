package com.photo.app.users.api.data;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.photo.app.users.model.AlbumResponseModel;

import feign.FeignException;
import feign.hystrix.FallbackFactory;

@FeignClient(name="albums-ws", fallbackFactory  = AlbumsFallback.class)
public interface AlbumsServiceClient {

	@GetMapping("/users/{id}/albums")
	public List<AlbumResponseModel> getAlbums(@PathVariable String id);
}
@Component
class AlbumsFallback implements FallbackFactory<AlbumsServiceClient>
{

	@Override
	public AlbumsServiceClient create(Throwable cause) {
		// TODO Auto-generated method stub
		return new AlbumsServiceClientFallback(cause);
	}
	
}

class AlbumsServiceClientFallback implements AlbumsServiceClient{

	Logger log = LoggerFactory.getLogger(AlbumsServiceClientFallback.class);
	private final Throwable cause;
	public AlbumsServiceClientFallback(Throwable cause) {
		this.cause=cause;
	}

	@Override
	public List<AlbumResponseModel> getAlbums(String id) {

		if(cause instanceof FeignException && ((FeignException) cause).status() == 404) {
			log.error("404 error took place when getAlbums was called with userId: " +id 
					+ " Error Message : "+cause.getLocalizedMessage());
		}else {
			log.error("Other Error took place  when getAlbums was called : "+cause.getLocalizedMessage());
		}
		
		return new ArrayList<>();
	}
	
	
}