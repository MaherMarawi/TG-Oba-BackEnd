package com.example.ObaProject.services;

import com.example.ObaProject.api.GetRequest;
import com.example.ObaProject.api.QueryArrange;
import com.example.ObaProject.configuration.ApiConfig;
import com.example.ObaProject.configuration.ResultConfig;
import com.example.ObaProject.data.Samen;
import com.example.ObaProject.data.Response;
import com.example.ObaProject.response.MainResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.*;

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
        response.setBooks(bookService.searchBook(search_value, "&refine=true"));
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
