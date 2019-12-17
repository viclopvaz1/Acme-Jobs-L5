
package acme.features.administrator.auditor;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.roles.Auditor;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@RequestMapping("/administrator/auditor/")
@Controller
public class AdministratorAuditorController extends AbstractController<Administrator, Auditor> {

	@Autowired
	AdministratorAuditorCreateService createService;


	@PostConstruct
	private void initialise() {

		super.addBasicCommand(BasicCommand.CREATE, this.createService);
	}

}
