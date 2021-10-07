package com.example.ObaProject.controllers;

import com.example.ObaProject.response.ActiviteitResponse;
import com.example.ObaProject.response.Response;
import com.example.ObaProject.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/oba/techgrounds/activiteiten")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("")
    public ActiviteitResponse getActivities() {
        return activityService.getActivities();
    }

    @GetMapping("/{search_value}")
    public ActiviteitResponse searchActivity(@PathVariable String search_value) {
        return activityService.searchActivity(search_value);
    }
//    @GetMapping("/{wijk_naam}")
//    public Response activiteitenSearch(@PathVariable String wijk_naam) {
//        return activityService.activiteitenSearch(wijk_naam);
//    }
}
