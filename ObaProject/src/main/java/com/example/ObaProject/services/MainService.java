package com.example.ObaProject.services;

import com.example.ObaProject.data.Samen;
import com.example.ObaProject.response.MainResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {

    @Autowired
    private ActivityService activityService;
    private CourseService courseService;
    private BookService bookService;
    public MainService(ActivityService activityService,
                       BookService bookService,
                       CourseService courseService) {
        this.activityService = activityService;
        this.courseService = courseService;
        this.bookService = bookService;
    }
    public MainResponse search(String search_value) {
        MainResponse response = new MainResponse();
        response.setActiviteiten(activityService.searchActivity(search_value));
        response.setBoeken(bookService.searchBook(search_value, "&refine=true"));
        response.setCursussen(courseService.searchCourse(search_value));
        return response;
    }

    public Samen activiteit_cursus() {
        Samen samen = new Samen();
        samen.setActiviteiten(activityService.getActivities());
        samen.setCursussen(courseService.getCourses());
        return samen;
    }
}
