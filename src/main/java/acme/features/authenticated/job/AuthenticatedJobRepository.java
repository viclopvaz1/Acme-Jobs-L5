
package acme.features.authenticated.job;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;

import acme.entities.jobs.Job;
import acme.framework.repositories.AbstractRepository;

public interface AuthenticatedJobRepository extends AbstractRepository {

	@Query("select a from Job a where status = 1")
	Collection<Job> findMany();
	@Query("select o from Job o where o.id = ?1")
	Job findOneById(int id);

}
