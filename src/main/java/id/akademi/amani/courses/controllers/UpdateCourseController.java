package id.akademi.amani.courses.controllers;

import id.akademi.amani.courses.controllers.models.UpdateCourseRequest;
import id.akademi.amani.courses.mappers.RequestMapper;
import id.akademi.amani.courses.services.UpdateCourse;
import id.akademi.amani.courses.services.models.UpdateCourseParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/course")
public class UpdateCourseController
{
    private final UpdateCourse updateCourse;
    private final RequestMapper requestMapper = RequestMapper.INSTANCE;

    @PutMapping("/{id}")
    public ResponseEntity<?> method(@PathVariable String id, @RequestBody UpdateCourseRequest updateCourseRequest)
    {
        final UpdateCourseParam paramFromRequest = requestMapper.from(updateCourseRequest);
        return new ResponseEntity<>(
          updateCourse.with(paramFromRequest),
          HttpStatus.OK
        );
    }
}
