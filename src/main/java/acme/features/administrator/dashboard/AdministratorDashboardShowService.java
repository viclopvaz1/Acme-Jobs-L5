
package acme.features.administrator.dashboard;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.forms.Dashboard;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorDashboardShowService implements AbstractShowService<Administrator, Dashboard> {

	@Autowired
	AdministratorDashboardRepository repository;


	@Override
	public boolean authorise(final Request<Dashboard> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Dashboard> request, final Dashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "numberOfCompaniesGroupedBySector", "numberOfInvestorsGroupedBySector", "ratioOfJobsGroupedByStatus", "ratioOfApplicationsGroupedByStatus", "TotalJobs", "TotalApplications");

	}

	@Override
	public Dashboard findOne(final Request<Dashboard> request) {
		assert request != null;

		Collection<Object[]> numberOfCompaniesGroupedBySector = this.repository.findBySector();
		Collection<Object[]> numberOfInvestorsGroupedBySector = this.repository.findBySector2();
		Collection<Object[]> gbs = this.repository.findByStatus();
		Collection<Object[]> gbs2 = this.repository.findBySector2();
		Double total = this.repository.findTotalJobs();
		Double totalap = this.repository.findTotalApplication();

		Dashboard result = new Dashboard();
		result.setNumberOfCompaniesGroupedBySector(numberOfCompaniesGroupedBySector);
		result.setNumberOfInvestorsGroupedBySector(numberOfInvestorsGroupedBySector);
		result.setRatioOfJobsGroupedByStatus(gbs);
		result.setRatioOfApplicationsGroupedByStatus(gbs2);
		result.setTotalJobs(total);
		result.setTotalApplications(totalap);

		return result;

	}

	/*
	 * @Override
	 * public Collection<Dashboard> findMany(final Request<Dashboard> request) {
	 * assert request != null;
	 *
	 * Collection<Dashboard> result;
	 *
	 * result = this.repository.findBySector();
	 *
	 * return result;
	 * }
	 */

}
