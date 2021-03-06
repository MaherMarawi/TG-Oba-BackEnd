package com.example.ObaProject.controllers;

import com.example.ObaProject.response.ComprehensiveCursusResponse;
import com.example.ObaProject.response.CursusResponse;
import com.example.ObaProject.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/oba/techgrounds/cursussen")
public class CourseController {

    @Autowired
    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("")
    public ComprehensiveCursusResponse getCourses() {
        return courseService.getCourses(1);
    }

    @GetMapping("/page/{page}")
    public ComprehensiveCursusResponse getCourses(@PathVariable int page) {
        return courseService.getCourses(page);
    }

    @GetMapping("/random")
    public CursusResponse getRandomCourses() {
        return courseService.getRandomCourses(1);
    }

    @GetMapping("/random/page/{page}")
    public CursusResponse getRandomCourses(@PathVariable int page) {
        return courseService.getRandomCourses(page);
    }

    @GetMapping("/random/datum/{datum}")
    public CursusResponse getRandomCoursesWithDate(@PathVariable String datum) {
        return courseService.getRandomCoursesWithDate(datum, 1);
    }

    @GetMapping("/random/datum/{datum}/page/{page}")
    public CursusResponse getRandomCoursesWithDate(@PathVariable String datum, @PathVariable int page) {
        return courseService.getRandomCoursesWithDate(datum, page);
    }


    @GetMapping("/{search_value}")
    public ComprehensiveCursusResponse searchCourse(@PathVariable String search_value) {
        return courseService.searchCourse(search_value, 1);
    }

    @GetMapping("/{search_value}/page/{page}")
    public ComprehensiveCursusResponse searchCourse(@PathVariable String search_value, @PathVariable int page) {
        return courseService.searchCourse(search_value, page);
    }

    @GetMapping("/zoek/{search_value}")
    public CursusResponse zoekCourse(@PathVariable String search_value) {
        return courseService.zoekCourse(search_value, 1);
    }

    @GetMapping("/zoek/{search_value}/page/{page}")
    public CursusResponse zoekCourse(@PathVariable String search_value, @PathVariable int page) {
        return courseService.zoekCourse(search_value, page);
    }

    @GetMapping("/zoek/{search_value}/datum/{datum}")
    public CursusResponse searchCourseWithDate(@PathVariable String search_value, @PathVariable String datum) {
        return courseService.searchCourseWithDate(search_value, datum, 1);
    }

    @GetMapping("/zoek/{search_value}/datum/{datum}/page/{page}")
    public CursusResponse searchCourseWithDate(@PathVariable String search_value, @PathVariable String datum, @PathVariable int page) {
        return courseService.searchCourseWithDate(search_value, datum, page);
    }
}
