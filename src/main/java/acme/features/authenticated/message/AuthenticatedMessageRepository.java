
package acme.features.authenticated.message;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.messages.Message;
import acme.entities.threads.Thread;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedMessageRepository extends AbstractRepository {

	@Query("select m from Message m where m.id=?1")
	Message findOneById(int id);

	@Query("select t from Thread t where t.id=?1")
	Thread findThreadById(int id);

	@Query("select t from Thread t join t.messages m where m.id=?1")
	Thread findThreadByMessageId(int id);

}
