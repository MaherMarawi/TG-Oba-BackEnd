package com.example.ObaProject.controllers;

import com.example.ObaProject.response.ActiviteitResponse;
import com.example.ObaProject.response.BoekResponse;
import com.example.ObaProject.response.ComprehensiveActivityResponse;
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
    public ComprehensiveActivityResponse getActivities() {
        return activityService.getActivities(1);
    }

    @GetMapping("/page/{page}")
    public ComprehensiveActivityResponse getActivities(@PathVariable int page) {
        return activityService.getActivities(page);
    }

    @GetMapping("/{search_value}")
    public ComprehensiveActivityResponse searchActivity(@PathVariable String search_value) {
        return activityService.searchActivity(search_value, 1);
    }

    @GetMapping("/{search_value}/page/{page}")
    public ComprehensiveActivityResponse searchActivity(@PathVariable String search_value, @PathVariable int page) {
        return activityService.searchActivity(search_value, page);
    }

    @GetMapping("/zoek/{search_value}")
    public ActiviteitResponse zoekActivity(@PathVariable String search_value) {
        return activityService.zoekActivity(search_value, 1);
    }

    @GetMapping("/zoek/{search_value}/page/{page}")
    public ActiviteitResponse zoekActivity(@PathVariable String search_value, @PathVariable int page) {
        return activityService.zoekActivity(search_value, page);
    }

    @GetMapping("/wijk/{wijk_naam}")
    public ComprehensiveActivityResponse getActivitiesInLocation(@PathVariable String wijk_naam) {
        return activityService.getActivitiesInLocation(wijk_naam, 1);
    }

    @GetMapping("/wijk/{wijk_naam}/page/{page}")
    public ComprehensiveActivityResponse getActivitiesInLocation(@PathVariable String wijk_naam, @PathVariable int page) {
        return activityService.getActivitiesInLocation(wijk_naam, page);
    }
}
