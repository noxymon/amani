package id.akademi.amani.courses.services;

import id.akademi.amani.repositories.MasterCourseRepository;
import id.akademi.amani.repositories.entities.MasterCourse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FetchCourses
{
    private final MasterCourseRepository masterCourseRepository;

    public List<MasterCourse> all()
    {
        return masterCourseRepository.findAll();
    }
}
