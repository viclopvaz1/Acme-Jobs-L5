
package acme.features.authenticated.thread;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.threads.Thread;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedThreadRepository extends AbstractRepository {

	@Query("select t from Thread t  where t.id = ?1")
	Thread findOneThreadById(int id);
	@Query("select t from Thread t join t.messages m where m.user.id=?1 group by t")
	Collection<Thread> findManyByAuthenticatedId(int authenticatedId);
}
//@Query("select a from Authenticated a where a.id in(select a.thread.authenticated.id from Thread t where t.users.id = ?1")
//	@Query("select t from Thread t where t.users = ANY (select u from users u  where u.id =?1")
