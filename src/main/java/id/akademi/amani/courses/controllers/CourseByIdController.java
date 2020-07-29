package id.akademi.amani.courses.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import id.akademi.amani.courses.CourseException;
import id.akademi.amani.courses.controllers.models.CourseResponse;
import id.akademi.amani.courses.services.FetchSingleCourse;
import id.akademi.amani.repositories.entities.MasterCourse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/course")
public class CourseByIdController
{
    private final FetchSingleCourse fetchSingleCourse;

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable String id)
    {
        try {
            final MasterCourse masterCourse = fetchSingleCourse.byId(id);

            return new ResponseEntity(
                    CourseResponse.from(masterCourse),
                    HttpStatus.OK
            );
        }catch (CourseException exception){
            return new ResponseEntity(exception, HttpStatus.BAD_REQUEST);
        }
    }
}
