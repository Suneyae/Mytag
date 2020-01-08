package com.test.javaAPI.enums;
/**
 * 关于枚举的简单使用
 * 参见：http://www.hollischuang.com/archives/195 
 * 以及网易云课堂：http://study.163.com/course/courseLearn.htm?courseId=214022#/learn/video?lessonId=309256&courseId=214022 
 * 或者 30天轻松掌握JavaWeb视频 的关于枚举的课程 第10 课
 * @author Wei
 * @time  2016年10月3日 下午6:17:32
 */
enum Season {
	SPRING(1), SUMMER(2), AUTUMN(3), WINTER(4);

	private int code;

	private Season(int code) {
		this.code = code;
		System.out.println("-------------code:"+code);
	}

	public int getCode() {
		return code;
	}
}

public class UseSeason {
	/**
	 * 将英文的季节转换成中文季节
	 * 
	 * @param season
	 * @return
	 */
	public String getChineseSeason(Season season) {
		StringBuffer result = new StringBuffer();
		switch (season) {
		case SPRING:
			result.append("[中文：春天，枚举常量:" + season.name() + "，数据:" + season.getCode() + "]");
			break;
		case AUTUMN:
			result.append("[中文：秋天，枚举常量:" + season.name() + "，数据:" + season.getCode() + "]");
			break;
		case SUMMER:
			result.append("[中文：夏天，枚举常量:" + season.name() + "，数据:" + season.getCode() + "]");
			break;
		case WINTER:
			result.append("[中文：冬天，枚举常量:" + season.name() + "，数据:" + season.getCode() + "]");
			break;
		default:
			result.append("地球没有的季节 " + season.name());
			break;
		}
		return result.toString();
	}

	public void doSomething() {
//		for (Season s : Season.values()) {
//			System.out.println(getChineseSeason(s));// 这是正常的场景
//		}
		// System.out.println(getChineseSeason(5));
		// 此处已经是编译不通过了，这就保证了类型安全
		Season s = Season.SPRING;
		System.out.println(getChineseSeason(s));
	}

	public static void main(String[] arg) {
		UseSeason useSeason = new UseSeason();
		useSeason.doSomething();
	}
}