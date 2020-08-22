package id.akademi.amani.courses.controllers.models;

import java.util.ArrayList;
import java.util.List;
import id.akademi.amani.courses.services.models.MasterCourse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CoursesResponse
{
    private final List<CourseResponse> courseResponseList;

    public static CoursesResponse from(List<MasterCourse> masterCourseEntityList)
    {
        List<CourseResponse> courseResponseList = new ArrayList<>();
        masterCourseEntityList
          .parallelStream()
          .forEach(masterCourse -> {
                            courseResponseList.add(
                                    CourseResponse.from(masterCourse)
                            );
                        });
        return new CoursesResponse(courseResponseList);
    }
}
