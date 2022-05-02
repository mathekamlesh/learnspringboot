package learn.springboot.oracle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyOracleController {
    private final DataService dataService;
    @Autowired
    public MyOracleController(DataService dataService) {
        this.dataService = dataService;
    }

    @PostMapping
    public List<MerchantSrData> data(@RequestParam String categoryId){
        return this.dataService.getSrMerchants(categoryId);
    }
}
