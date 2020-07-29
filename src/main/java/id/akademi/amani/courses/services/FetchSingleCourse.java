package id.akademi.amani.courses.services;

import java.util.Optional;
import org.springframework.stereotype.Service;
import id.akademi.amani.courses.CourseException;
import id.akademi.amani.repositories.MasterCourseRepository;
import id.akademi.amani.repositories.entities.MasterCourse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FetchSingleCourse
{
    private final MasterCourseRepository masterCourseRepository;

    public MasterCourse byId(String id)
    {
        final Optional<MasterCourse> foundCoursesOptional = masterCourseRepository.findById(id);
        if(foundCoursesOptional.isPresent()){
            return foundCoursesOptional.get();
        }
        throw new CourseException("Ooops, we can't found course you look for");
    }
}
