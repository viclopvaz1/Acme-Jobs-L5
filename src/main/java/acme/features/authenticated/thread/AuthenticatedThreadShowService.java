
package acme.features.authenticated.thread;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.threads.Thread;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedThreadShowService implements AbstractShowService<Authenticated, Thread> {

	@Autowired
	AuthenticatedThreadRepository repository;


	@Override
	public boolean authorise(final Request<Thread> request) {

		assert request != null;

		boolean result;
		int threadId;
		Thread thread;
		Principal principal;

		threadId = request.getModel().getInteger("id");
		thread = this.repository.findOneThreadById(threadId);
		List<Authenticated> users = (List<Authenticated>) thread.getAuthenticated();
		principal = request.getPrincipal();
		result = users.stream().filter(x -> x.getUserAccount().getId() == principal.getAccountId()).count() > 0;
		return result;
	}

	@Override
	public void unbind(final Request<Thread> request, final Thread entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		request.unbind(entity, model, "title", "moment");
	}

	@Override
	public Thread findOne(final Request<Thread> request) {
		// TODO Auto-generated method stub
		assert request != null;

		Thread result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneThreadById(id);

		return result;
	}
}
