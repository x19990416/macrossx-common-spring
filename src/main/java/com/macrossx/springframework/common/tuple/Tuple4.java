package com.macrossx.springframework.common.tuple;

/**
 * 4元组
 * 
 * @author starseeker.limin@gmail.com(X-Forever)
 *
 * @param _1
 *            Nullable，元组的第1个元素
 * @param _2
 *            Nullable，元组的第2个元素
 * @param _3
 *            Nullable，元组的第3个元素
 * @param _4
 *            Nullable，元组的第4个元素
 */
public class Tuple4<T1, T2, T3, T4> extends Tuple3<T1, T2, T3> {
	public Tuple4(T1 t_1, T2 t_2, T3 t_3, T4 t_4) {
		super(t_1, t_2, t_3);
		this.t_4 = t_4;
	}

	public final T4 t_4;

	@Override
	public String toString() {
		return "(" + t_1 + "," + t_2 + "," + t_3 + "," + t_4 + ")";
	}
}
