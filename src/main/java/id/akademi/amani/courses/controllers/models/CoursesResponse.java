package id.akademi.amani.courses.controllers.models;

import id.akademi.amani.repositories.entities.MasterCourse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class CoursesResponse
{
    private final List<CourseResponse> courseResponseList;

    public static CoursesResponse from(List<MasterCourse> masterCourseList)
    {
        List<CourseResponse> courseResponseList = new ArrayList<>();
        masterCourseList.parallelStream()
                        .forEach(masterCourse -> {
                            courseResponseList.add(
                                    CourseResponse.from(masterCourse)
                            );
                        });
        return new CoursesResponse(courseResponseList);
    }
}
