package com.photo.app.users.api.data;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.photo.app.users.model.AlbumResponseModel;

@FeignClient(name="albums-ws")
public interface AlbumsServiceClient {

	@GetMapping("/users/{id}/albumss")
	public List<AlbumResponseModel> getAlbums(@PathVariable String id);
}
