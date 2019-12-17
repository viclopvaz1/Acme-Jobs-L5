
package acme.features.sponsor.comercialbanner;

import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.comercialbanners.ComercialBanner;
import acme.entities.roles.Sponsor;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractCreateService;

@Service
public class SponsorComercialBannerCreateService implements AbstractCreateService<Sponsor, ComercialBanner> {

	@Autowired
	SponsorComercialBannerRepository repository;


	@Override
	public boolean authorise(final Request<ComercialBanner> request) {
		assert request != null;

		//		boolean result;
		//		Principal principal;
		//		Sponsor sponsor;
		//		int id;
		//
		//		principal = request.getPrincipal();
		//		id = principal.getAccountId();
		//		sponsor = this.repository.findSponsorById(id);
		//
		//		result = sponsor.getCreditCard().isEmpty();
		//
		//		return !result;
		return true;
	}

	@Override
	public void bind(final Request<ComercialBanner> request, final ComercialBanner entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "sponsor");

	}

	@Override
	public void unbind(final Request<ComercialBanner> request, final ComercialBanner entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "picture", "slogan", "targetUrl", "creditCard", "monthExp", "yearExp", "cvv");

	}

	@Override
	public ComercialBanner instantiate(final Request<ComercialBanner> request) {
		assert request != null;

		ComercialBanner result;
		Principal principal;
		Sponsor sponsor;
		int sponsorId;

		principal = request.getPrincipal();
		sponsorId = principal.getActiveRoleId();
		sponsor = this.repository.findSponsorById(sponsorId);

		result = new ComercialBanner();
		result.setSponsor(sponsor);

		return result;
	}

	@Override
	public void validate(final Request<ComercialBanner> request, final ComercialBanner entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		String palabrasSpam;
		String[] split;
		Collection<String> spam = new HashSet<>();

		palabrasSpam = this.repository.spamWords();
		split = palabrasSpam.split(", ");
		for (String s : split) {
			spam.add(s);
		}

		Calendar calendar = new GregorianCalendar();
		Integer month = calendar.getTime().getMonth();
		Integer year = calendar.getTime().getYear() + 1900;

		if (!errors.hasErrors("monthExp")) {
			errors.state(request, entity.getYearExp() > year || entity.getMonthExp() >= month && entity.getYearExp() == year, "monthExp", "sponsor.comercial-banner.form.error.monthExp");
		}

		if (!errors.hasErrors("yearExp")) {
			errors.state(request, entity.getYearExp() >= year, "yearExp", "sponsor.comercial-banner.form.error.yearExp");
		}

		if (!errors.hasErrors("slogan")) {
			boolean isSpam = true;
			for (String s : spam) {
				isSpam = entity.getSlogan().contains(s);
			}

			errors.state(request, isSpam == false, "slogan", "sponsor.comercial-banner.form.error.spamWordsSlogan");
		}

	}

	@Override
	public void create(final Request<ComercialBanner> request, final ComercialBanner entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
