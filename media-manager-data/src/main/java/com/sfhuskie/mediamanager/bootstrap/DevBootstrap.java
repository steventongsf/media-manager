package com.sfhuskie.mediamanager.bootstrap;

import java.util.Date;
import java.util.Set;
import java.util.HashSet;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.sfhuskie.mediamanager.model.User;
import com.sfhuskie.mediamanager.model.Video;
import com.sfhuskie.mediamanager.model.View;
import com.sfhuskie.mediamanager.repositories.UserRepository;
import com.sfhuskie.mediamanager.repositories.VideoRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{
    private VideoRepository videoRepository;
    private UserRepository userRepository;
    
    public DevBootstrap(VideoRepository videoRepository, UserRepository userRepository) {
        this.videoRepository = videoRepository;
        this.userRepository = userRepository;
    }
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
        
    }
    private void initData() {
        //Video a = new Video(null, "Welcome to Paradise","c:/videos/welcome to paradise.mp4");
        
        Video video1 = new Video();
        video1.setTitle("Welcome to the Jungle");
        video1.setLocation("e:/videos/welcometothejungle.m4");
        video1 = this.videoRepository.save(video1);
        System.out.println(video1);
        Video v2 = new Video();
        v2.setTitle("1999");
        v2.setLocation("e:/videos/1999.m4");
        this.videoRepository.save(v2);
        User user1 = new User();
        user1.setEmail("sfhuskie@gmail.com");
        user1.setFirstname("Steven");
        user1.setLastname("Tong");
        View view1 = new View();
            view1.setViewDate(new Date());
            view1.setViewDuration(new Long(61000000));
            view1.setVideo(video1);
        Set<View> views = new HashSet<View>();
        views.add(view1);
        user1.setViews(views);
        this.userRepository.save(user1);
    }

}
