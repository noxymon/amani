package id.akademi.amani.courses.controllers;

import id.akademi.amani.courses.controllers.models.CoursesResponse;
import id.akademi.amani.courses.services.FetchCourses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/course")
public class AllCoursesController
{
    private final FetchCourses fetchCourses;

    @GetMapping("/")
    public ResponseEntity<CoursesResponse> findAll()
    {
        return new ResponseEntity(
                CoursesResponse.from(fetchCourses.all()),
                HttpStatus.OK
        );
    }
}
