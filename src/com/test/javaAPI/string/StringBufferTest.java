package com.test.javaAPI.string;
/**
 * 测试StringBuffer ,StringBuilder,String这三者的差异区别
 * 参见：http://www.cnblogs.com/xudong-bupt/p/3961159.html
 * 参加：http://www.cnblogs.com/fancydeepin/archive/2013/04/23/min-snail-speak_String-StringBuffer-StringBuilder.html
 * @author Wei
 * @time  2017年3月21日 上午9:43:17
 */
public class StringBufferTest {

	public StringBufferTest() {
		// TODO Auto-generated constructor stub
	}
	
//	private final int LOOP_TIMES = 200000;
	private final int LOOP_TIMES = 1000000;
	    private final String CONSTANT_STRING = "min-snail";
	    
	    public static void main(String[] args) {
	        
	        new StringBufferTest().startup();
	    }
	    
	    public void testString(){
	        String string = "";
	        long beginTime = System.currentTimeMillis();
	        for(int i = 0; i < LOOP_TIMES; i++){
	            string += CONSTANT_STRING;
	        }
	        long endTime = System.currentTimeMillis();
	        System.out.print("String : " + (endTime - beginTime) + "\t");
	    }
	    
	    public void testStringBuffer(){
	        StringBuffer buffer = new StringBuffer();
	        long beginTime = System.currentTimeMillis();
	        for(int i = 0; i < LOOP_TIMES; i++){
	            buffer.append(CONSTANT_STRING);
	        }
	        buffer.toString();
	        long endTime = System.currentTimeMillis();
	        System.out.print("StringBuffer : " + (endTime - beginTime) + "\t");
	    }
	    
	    public void testStringBuilder(){
	        StringBuilder builder = new StringBuilder();
	        long beginTime = System.currentTimeMillis();
	        for(int i = 0; i < LOOP_TIMES; i++){
	            builder.append(CONSTANT_STRING);
	        }
	        builder.toString();
	        long endTime = System.currentTimeMillis();
	        System.out.print("StringBuilder : " + (endTime - beginTime) + "\t");
	    }
	    
	    public void startup(){
	        for(int i = 0; i < 6; i++){
	            System.out.print("The " + i + " [\t    ");
//	            testString();
	            testStringBuffer();
	            testStringBuilder();
	            System.out.println("]");
	        }
	    }

}
