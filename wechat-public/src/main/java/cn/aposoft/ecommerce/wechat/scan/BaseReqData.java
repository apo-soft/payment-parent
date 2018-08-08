package cn.aposoft.ecommerce.wechat.scan;

/**
 * Created by lisong on 16/6/20.
 */
public class BaseReqData extends BasicTO{
    private String FunCod;
    private String compOrgCode;
    private String MAC;

    public String getFunCod() {
        return FunCod;
    }

    public void setFunCod(String funCod) {
        FunCod=funCod;
    }

    public String getCompOrgCode() {
        return compOrgCode;
    }

    public void setCompOrgCode(String compOrgCode) {
        this.compOrgCode=compOrgCode;
    }

    public String getMAC() {
        return MAC;
    }

    public void setMAC(String MAC) {
        this.MAC=MAC;
    }
}
