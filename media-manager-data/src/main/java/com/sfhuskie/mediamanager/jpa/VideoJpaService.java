package com.sfhuskie.mediamanager.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.sfhuskie.mediamanager.model.Video;
import com.sfhuskie.mediamanager.repositories.VideoRepository;
import com.sfhuskie.mediamanager.services.VideoService;

import java.util.HashSet;
import java.util.Set;


@Service
@Profile("jpa")
public class VideoJpaService implements VideoService {

    private final VideoRepository videoRepository;

    public VideoJpaService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    public Set<Video> findAll() {
        Set<Video> videos = new HashSet<>();
        videoRepository.findAll().forEach(videos::add);
        return videos;
    }

    @Override
    public Video findById(Long id) {
        return videoRepository.findById(id).orElse(null);
    }

    @Override
    public Video save(Video object) {
        return videoRepository.save(object);
    }

    @Override
    public void delete(Video object) {
    	videoRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
    	videoRepository.deleteById(id);
    }
}
