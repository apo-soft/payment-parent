package cn.aposoft.ecommerce.payment.cshpay;

public class CshTest {
	String fileName = "E:/environments/properties/pay/csh/csh.properties";
	CshPropertiesConfig config = new CshPropertiesConfig(fileName, "utf-8");

	public void pay() {
		System.out.println(config.bid());
	}

	public static void main(String[] args) {
		CshTest test = new CshTest();
		test.pay();
	}

}
