package id.akademi.amani.courses.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import id.akademi.amani.courses.mappers.MasterCourseMapper;
import id.akademi.amani.courses.services.models.MasterCourse;
import id.akademi.amani.repositories.MasterCourseRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FetchCourses
{
  private final MasterCourseRepository   masterCourseRepository;
  private final CourseTransactionService courseTransactionService;
  private final MasterCourseMapper       masterCourseMapper = MasterCourseMapper.INSTANCE;

  public List<MasterCourse> all()
  {
    return masterCourseRepository.findAll()
    .parallelStream()
    .map(entity -> {
      MasterCourse map = masterCourseMapper.map(entity);
      map.setJoinedCount(courseTransactionService.countAttendeeOf(entity.getId()));
      return map;
    })
    .collect(Collectors.toList());
  }
}
