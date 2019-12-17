
package acme.entities.comercialbanners;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

import acme.entities.roles.Sponsor;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ComercialBanner extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	@URL
	private String				picture;

	@NotBlank
	private String				slogan;

	@NotBlank
	@URL
	private String				targetUrl;

	@NotBlank
	@CreditCardNumber
	private String				creditCard;

	@NotBlank
	private String				name;

	@NotBlank
	private String				network;

	@NotNull
	@Range(min = 1, max = 12)
	private Integer				monthExp;

	@NotNull
	private Integer				yearExp;

	@NotNull
	private Integer				cvv;

	// Relationships ----------------------------------------------------------

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Sponsor				sponsor;

}
