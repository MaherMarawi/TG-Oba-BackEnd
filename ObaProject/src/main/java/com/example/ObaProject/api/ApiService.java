package com.example.ObaProject.api;

import com.example.ObaProject.configuration.ApiConfig;
import com.example.ObaProject.configuration.ResultConfig;
import com.example.ObaProject.response.ActiviteitResponse;
import com.example.ObaProject.data.Boek;
import com.example.ObaProject.configuration.BoekConfig;
import com.example.ObaProject.response.BoekResponse;
import com.example.ObaProject.configuration.CursusConfig;
import com.example.ObaProject.configuration.ActiviteitConfig;
import com.example.ObaProject.response.CursusResponse;
import com.example.ObaProject.configuration.FacetConfig;
import com.example.ObaProject.data.Samen;
import com.example.ObaProject.services.ActivityService;
import com.example.ObaProject.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.*;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class ApiService {

    @Autowired
    private ActivityService activityService;
    private CourseService courseService;
    public ApiService(ActivityService activityService,
                      CourseService courseService) {
        this.activityService = activityService;
        this.courseService = courseService;
    }
//    public Response search(String search_value) {
//
//        StringBuilder query = queryArrange.getQuery(search_value);
//        String url = apiConfig.getUrl() +
//                     query +
//                     apiConfig.getAuthorization() +
//                     "&refine=true";
//        System.out.println(url);
//        Document doc = request.sendRequest(url);
//        Response search = resultConfig.resultsToJson(doc.getElementsByTagName("result"));
//        return search;
//    }

    public Samen activiteit_cusus() {
        Samen samen = new Samen();
        samen.setActiviteiten(activityService.getActivities());
        samen.setCursussen(courseService.getCourses());
        return samen;
    }
}
