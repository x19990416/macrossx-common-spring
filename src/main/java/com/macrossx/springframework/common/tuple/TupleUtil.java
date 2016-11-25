package com.macrossx.springframework.common.tuple;

/**
 * 元组创建工具类 
 * @author starseeker.limin@gmail.com(X-Forever)
 */
public final class TupleUtil {
	/**
	 * 生成1元组
	 */
	public static <T1> Tuple1<T1> of(T1 _1) {
		return new Tuple1<T1>(_1);
	}

	/**
	 * 生成2元组
	 */

	public static <T1, T2> Tuple2<T1, T2> of(T1 _1, T2 _2) {
		return new Tuple2<T1, T2>(_1, _2);
	}

	/**
	 * 生成3元组
	 */
	public static <T1, T2, T3> Tuple3<T1, T2, T3> of(T1 _1, T2 _2, T3 _3) {
		return new Tuple3<T1, T2, T3>(_1, _2, _3);
	}

	/**
	 * 生成4元组
	 */
	public static <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> of(T1 _1, T2 _2, T3 _3, T4 _4) {
		return new Tuple4<T1, T2, T3, T4>(_1, _2, _3, _4);
	}
}
