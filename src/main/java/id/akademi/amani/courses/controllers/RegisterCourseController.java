package id.akademi.amani.courses.controllers;

import id.akademi.amani.courses.controllers.models.RegisterCourseRequest;
import id.akademi.amani.courses.mappers.RequestMapper;
import id.akademi.amani.courses.services.RegisterCourse;
import id.akademi.amani.courses.services.models.MasterCourse;
import id.akademi.amani.courses.services.models.RegisterCourseParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/course")
public class RegisterCourseController
{
    private final RequestMapper  requestMapper;
    private final RegisterCourse registerCourse;

    @PostMapping("/")
    public ResponseEntity<?> addNew(RegisterCourseRequest registerCourseRequest)
    {
        final RegisterCourseParam registerCourseParam = requestMapper.from(registerCourseRequest);
        final MasterCourse masterCourse = registerCourse.addNew(registerCourseParam);
        return new ResponseEntity<>(masterCourse, HttpStatus.ACCEPTED);
    }
}
