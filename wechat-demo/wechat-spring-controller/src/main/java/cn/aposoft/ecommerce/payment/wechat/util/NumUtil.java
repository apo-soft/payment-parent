package cn.aposoft.ecommerce.payment.wechat.util;



import java.util.Random;


/**自动生成默认20位随机数的主键
 */
public class NumUtil {
	private static String codesrc = "0123456789abcdefghijklmnopqrstuvwxyz";
	private static final Random random = new Random();  
	
	public static final int DEFAULTNUM=20;
	/**
	 * 生成
	 * @param num 生成随机数的长度 
	 * @return string
	 */
	public static String makeNum() {
		String id = "";
		for(int i = 0; i < DEFAULTNUM; i ++) {
			int n = appointRangeValue( 0, 35 );
			String c = codesrc.substring(n, n+1 );
			id += c;
		}
		return id;
	}
	
	public static String makeNum(int length){
		
		if(length<=0){
			throw new ArrayIndexOutOfBoundsException();
		}
		
		StringBuilder id = new StringBuilder();
		for(int i = 0; i < length; i ++) {
			int n = appointRangeValue( 0, 35 );
			String c = codesrc.substring(n, n+1 );
			id.append(c);
		}
		return id.toString();
	}
	
	/**
	 * 取随机数
	 * @param minValue
	 * @param maxValue
	 * @return
	 */
	public static Integer appointRangeValue(Integer minValue, Integer maxValue) {  
        if(maxValue <= 0){  
            System.out.println("maxValue must more than zero");  
        }  
        return random.nextInt(maxValue) % (maxValue - minValue + 1) + minValue;  
    }  
	
}
