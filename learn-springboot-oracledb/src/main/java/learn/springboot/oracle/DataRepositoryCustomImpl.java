package learn.springboot.oracle;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public class DataRepositoryCustomImpl implements DataRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    public List<MerchantSrData> getSrMerchants(String categoryId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<MerchantSrData> query = cb.createQuery(MerchantSrData.class);
        Root<MerchantSrData> merchantSrData = query.from(MerchantSrData.class);



        Path<String> cateogryIdPath = merchantSrData.get("CATEGORY_ID");
//        Path<String> subCateogryIdPath = merchantSrData.get("SUB_CATEGORY_ID");

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.equal(cateogryIdPath, categoryId));
        query.select(merchantSrData)
                .where(cb.or(predicates.toArray(new Predicate[predicates.size()])));

        return entityManager.createQuery(query)
                .getResultList();
    }
}
