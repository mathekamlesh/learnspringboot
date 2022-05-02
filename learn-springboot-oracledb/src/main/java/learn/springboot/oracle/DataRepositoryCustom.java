package learn.springboot.oracle;

import java.util.List;
import java.util.Set;

public interface DataRepositoryCustom {
    List<MerchantSrData> getSrMerchants(String conditions);
}
