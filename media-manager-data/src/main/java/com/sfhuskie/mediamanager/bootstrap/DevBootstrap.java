package com.sfhuskie.mediamanager.bootstrap;
/*
Copyright 2020 Steven Tong

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
import java.util.Date;
import java.util.Set;
import java.util.HashSet;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.sfhuskie.mediamanager.model.User;
import com.sfhuskie.mediamanager.model.Video;
import com.sfhuskie.mediamanager.model.Activity;
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
        v2 = this.videoRepository.save(v2);
        User user1 = new User();
        user1.setEmail("sfhuskie@gmail.com");
        user1.setFirstname("Steven");
        user1.setLastname("Tong");
        Activity activity1 = new Activity();
            activity1.setStartDate(new Date());
            activity1.setDuration(new Long(61000000));
            activity1.setVideo(video1);
            Activity activity2 = new Activity();
            activity2.setStartDate(new Date());
            activity2.setDuration(new Long(61000000));
            activity2.setVideo(v2);
        Set<Activity> views = new HashSet<Activity>();
        views.add(activity1);
        views.add(activity2);
        user1.setActivities(views);
        this.userRepository.save(user1);
    }

}
