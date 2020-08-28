package id.akademi.amani.courses.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import id.akademi.amani.courses.mappers.EntityMapper;
import id.akademi.amani.courses.services.models.MasterCourse;
import id.akademi.amani.repositories.MasterCourseRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FetchCourses
{
  private final MasterCourseRepository   masterCourseRepository;
  private final CourseTransactionService courseTransactionService;
  private final EntityMapper             entityMapper = EntityMapper.INSTANCE;

  public List<MasterCourse> all()
  {
    return masterCourseRepository.findAll()
    .parallelStream()
    .map(entity -> {
      MasterCourse map = entityMapper.from(entity);
      map.setJoinedCount(courseTransactionService.countAttendeeOf(entity.getId().toString()));
      return map;
    })
    .collect(Collectors.toList());
  }
}
