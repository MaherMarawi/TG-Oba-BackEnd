package com.example.ObaProject.controllers;

import com.example.ObaProject.response.ActiviteitResponse;
import com.example.ObaProject.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return activityService.getActivities(1);
    }

    @GetMapping("/page/{page}")
    public ActiviteitResponse getActivities(@PathVariable int page) {
        return activityService.getActivities(page);
    }

    @GetMapping("/{search_value}")
    public ActiviteitResponse searchActivity(@PathVariable String search_value) {
        return activityService.searchActivity(search_value, 1);
    }

    @GetMapping("/{search_value}/page/{page}")
    public ActiviteitResponse searchActivity(@PathVariable String search_value, @PathVariable int page) {
        return activityService.searchActivity(search_value, page);
    }

    @GetMapping("/wijk/{wijk_naam}")
    public ActiviteitResponse getActivitiesInLocation(@PathVariable String wijk_naam) {
        return activityService.getActivitiesInLocation(wijk_naam, 1);
    }

    @GetMapping("/wijk/{wijk_naam}/page/{page}")
    public ActiviteitResponse getActivitiesInLocation(@PathVariable String wijk_naam, @PathVariable int page) {
        return activityService.getActivitiesInLocation(wijk_naam, page);
    }
}
