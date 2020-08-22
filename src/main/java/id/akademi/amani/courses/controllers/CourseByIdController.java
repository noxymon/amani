package id.akademi.amani.courses.controllers;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import id.akademi.amani.courses.CourseException;
import id.akademi.amani.courses.controllers.models.CourseResponse;
import id.akademi.amani.courses.services.FetchSingleCourse;
import id.akademi.amani.courses.services.models.MasterCourse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/course")
public class CourseByIdController
{
    private final FetchSingleCourse fetchSingleCourse;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id)
    {
        return findById(id, null);
    }

    @GetMapping("/{id}/{memberId}")
    public ResponseEntity<?> findById(@PathVariable String id, @PathVariable String memberId)
    {
        try {
            final MasterCourse masterCourseEntity = fetchSingleCourse.byId(id, Optional.ofNullable(memberId));
            final CourseResponse courseResponse = CourseResponse.from(masterCourseEntity);
            return new ResponseEntity<CourseResponse>(courseResponse, HttpStatus.OK);
        } catch (CourseException exception) {
            return new ResponseEntity<Throwable>(exception, HttpStatus.BAD_REQUEST);
        }
    }
}
