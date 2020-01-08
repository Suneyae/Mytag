package com.test.javaAPI.collections;

import org.junit.Test;

public class MapTest {
	public static void main(String[] args) {
		// Map map = new HashMap();
		// // map.ha
		// map.put("a", "b");
		// map.put("a", "c");
		// System.out.println(map.toString());

		int hashcodea = hash("a");
		System.out.println("a:" + hashcodea);
		int hashcodeb = hash("b");
		System.out.println("b:" + hashcodeb);
		System.out.println("A:" + hash("A"));
		MapTest m = new MapTest();
		MapTest m_ = new MapTest();
		System.out.println("m1:" + m.hash(m));
		System.out.println("m2:" + hash(m));
		System.out.println("m.hashCode:"+m.hashCode());
		System.out.println("m_.hashCode:"+m_.hashCode());
		System.out.println("null:" + hash(null));
		test();
		
	}

	static final int hash(Object key) {
		int h;
		return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	}

	@Test
	public static void test(){
		int a = 15;
		int b = 2;
		System.out.println("a 与 b 异或的结果是："+(a^b));
	}

}
