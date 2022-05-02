package learn.springboot.oracle;
import javax.persistence.*;

@Entity @Table(name = "SR_ANALYTICS_COHORT", schema = "SIJPMWHDB")
public class MerchantSrData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "AUTO_ID", nullable = false)
    private Long AUTO_ID;
    private String SR_ID;
    private Long MERCHANT_ID;
    private String CATEGORY_ID;
    private String SUB_CATEGORY_ID;
    private String SR_CREATED_DATE;



    public MerchantSrData(Long AUTO_ID, String SR_ID, Long MERCHANT_ID, String CATEGORY_ID, String SUB_CATEGORY_ID, String SR_CREATED_DATE) {
        this.AUTO_ID = AUTO_ID;
        this.SR_ID = SR_ID;
        this.MERCHANT_ID = MERCHANT_ID;
        this.CATEGORY_ID = CATEGORY_ID;
        this.SUB_CATEGORY_ID = SUB_CATEGORY_ID;
        this.SR_CREATED_DATE = SR_CREATED_DATE;
    }

    public MerchantSrData() {
    }

    public Long getAUTO_ID() {
        return AUTO_ID;
    }

    public void setAUTO_ID(Long AUTO_ID) {
        this.AUTO_ID = AUTO_ID;
    }

    public String getSR_ID() {
        return SR_ID;
    }

    public void setSR_ID(String SR_ID) {
        this.SR_ID = SR_ID;
    }

    public Long getMERCHANT_ID() {
        return MERCHANT_ID;
    }

    public void setMERCHANT_ID(Long MERCHANT_ID) {
        this.MERCHANT_ID = MERCHANT_ID;
    }

    public String getCATEGORY_ID() {
        return CATEGORY_ID;
    }

    public void setCATEGORY_ID(String CATEGORY_ID) {
        this.CATEGORY_ID = CATEGORY_ID;
    }

    public String getSUB_CATEGORY_ID() {
        return SUB_CATEGORY_ID;
    }

    public void setSUB_CATEGORY_ID(String SUB_CATEGORY_ID) {
        this.SUB_CATEGORY_ID = SUB_CATEGORY_ID;
    }

    public String getSR_CREATED_DATE() {
        return SR_CREATED_DATE;
    }

    public void setSR_CREATED_DATE(String SR_CREATED_DATE) {
        this.SR_CREATED_DATE = SR_CREATED_DATE;
    }

    @Override
    public String toString() {
        return "MerchantSrData{" +
                "AUTO_ID=" + AUTO_ID +
                ", SR_ID='" + SR_ID + '\'' +
                ", MERCHANT_ID=" + MERCHANT_ID +
                ", CATEGORY_ID='" + CATEGORY_ID + '\'' +
                ", SUB_CATEGORY_ID='" + SUB_CATEGORY_ID + '\'' +
                ", SR_CREATED_DATE=" + SR_CREATED_DATE +
                '}';
    }
}
