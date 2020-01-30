package com.sfhuskie.mediamanager.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.sfhuskie.mediamanager.model.Video;
import com.sfhuskie.mediamanager.services.VideoService;

import java.util.Set;


@Service
@Profile({"default", "map"})
public class VideoMapService extends AbstractMapService<Video, Long> implements VideoService {
    @Override
    public Set<Video> findAll() {
        return super.findAll();
    }

    @Override
    public Video findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Video save(Video object) {
        return super.save(object);
    }

    @Override
    public void delete(Video object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}