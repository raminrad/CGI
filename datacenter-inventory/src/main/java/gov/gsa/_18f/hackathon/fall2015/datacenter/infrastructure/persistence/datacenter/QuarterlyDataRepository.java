package gov.gsa._18f.hackathon.fall2015.datacenter.infrastructure.persistence.datacenter;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import gov.gsa._18f.hackathon.fall2015.datacenter.domain.datacenter.DatacenterSearchCriteria;
import gov.gsa._18f.hackathon.fall2015.datacenter.domain.datacenter.QuarterlyData;
import gov.gsa._18f.hackathon.fall2015.datacenter.infrastructure.persistence.BaseRepository;

/**
 * @author dfladung
 *
 */
@Repository
public class QuarterlyDataRepository extends BaseRepository<QuarterlyData> {

	public QuarterlyDataRepository() {
		super(QuarterlyData.class);
	}

	@SuppressWarnings("unchecked")
	public List<QuarterlyData> retrieveQuartersByCriteria(DatacenterSearchCriteria dsc) {
		DetachedCriteria cr = DetachedCriteria.forClass(QuarterlyData.class);
		cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		cr.addOrder(Order.asc("fiscal_year"));
		cr.addOrder(Order.asc("quarter"));

		if (dsc.getFiscalYear() != null) {
			cr.add(Restrictions.eq("fiscal_year", dsc.getFiscalYear()));
		}

		if (dsc.getQuarter() != null) {
			cr.add(Restrictions.eq("quarter", dsc.getQuarter()));
		}

		return cr.getExecutableCriteria(datacenterSessionFactory.getCurrentSession()).list();
	}
}
