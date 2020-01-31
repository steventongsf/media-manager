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
package com.sfhuskie.mediamanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sfhuskie.mediamanager.repositories.VideoRepository;

/**
* 	@author Steven Tong
*/

@Controller
public class VideosController {
    
    private VideoRepository videoRepository;
    
    public VideosController(VideoRepository videoRepository) {
        super();
        this.videoRepository = videoRepository;
    }

    @RequestMapping({"/videos","/videos/index","/videos/index.html"})
    public String getVideos(Model model) {
        model.addAttribute("videos", this.videoRepository.findAll());
        // name of view
        return "videos/index";
    }
}
