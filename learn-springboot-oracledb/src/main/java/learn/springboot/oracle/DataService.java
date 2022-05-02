package learn.springboot.oracle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class DataService {
    private final DataRepositoryCustomImpl dataRepository;

    @Autowired
    public DataService(DataRepositoryCustomImpl dataRepository) {
        this.dataRepository = dataRepository;
    }

    public List<MerchantSrData> getSrMerchants(String categoryId){
        return this.dataRepository.getSrMerchants(categoryId);
    }
}
