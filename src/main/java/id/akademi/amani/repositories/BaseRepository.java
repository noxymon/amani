package id.akademi.amani.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID>
{
}
