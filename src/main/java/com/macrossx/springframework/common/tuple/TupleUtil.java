package com.macrossx.springframework.common.tuple;/**
 * 元组创建工具类 
 * @author starseeker.limin@gmail.com(X-Forever)
 */
public final class TupleUtil {
	/**
	 * 生成1元组
	 */
	public static <T1> Tuple1<T1> of(T1 t_1) {
		return new Tuple1<T1>(t_1);
	}

	/**
	 * 生成2元组
	 */

	public static <T1, T2> Tuple2<T1, T2> of(T1 t_1, T2 t_2) {
		return new Tuple2<T1, T2>(t_1, t_2);
	}

	/**
	 * 生成3元组
	 */
	public static <T1, T2, T3> Tuple3<T1, T2, T3> of(T1 t_1, T2 t_2, T3 t_3) {
		return new Tuple3<T1, T2, T3>(t_1, t_2, t_3);
	}

	/**
	 * 生成4元组
	 */
	public static <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> of(T1 t_1, T2 t_2, T3 t_3, T4 t_4) {
		return new Tuple4<T1, T2, T3, T4>(t_1, t_2, t_3, t_4);
	}
}
