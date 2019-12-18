
package acme.features.authenticated.authenticated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedAuthenticatedShowService implements AbstractShowService<Authenticated, Authenticated> {

	@Autowired
	AuthenticatedAuthenticatedRepository repository;


	@Override
	public boolean authorise(final Request<Authenticated> request) {

		assert request != null;

		boolean result = false;
		Principal principal = request.getPrincipal();
		int threadId = request.getModel().getInteger("threadId");
		if (principal.getActiveRoleId() == this.repository.findCreatorUserByThreadId(threadId)) {
			result = true;
		}
		return result;

	}

	@Override
	public void unbind(final Request<Authenticated> request, final Authenticated entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		request.unbind(entity, model, "id", "threadId");
	}

	@Override
	public Authenticated findOne(final Request<Authenticated> request) {
		// TODO Auto-generated method stub
		assert request != null;

		Authenticated result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findAuthenticatedById(id);

		return result;
	}
}
