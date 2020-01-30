package com.sfhuskie.mediamanager.repositories;


import org.springframework.data.repository.CrudRepository;

import com.sfhuskie.mediamanager.model.Video;

public interface VideoRepository extends CrudRepository<Video, Long> {
}
