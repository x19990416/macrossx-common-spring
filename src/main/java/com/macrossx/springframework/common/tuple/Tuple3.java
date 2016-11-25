package com.macrossx.springframework.common.tuple;
/**
 * 3元组
 * 
 * @author starseeker.limin@gmail.com(X-Forever)
 *
 * @param _1
 *            Nullable，元组的第1个元素
 * @param _2
 *            Nullable，元组的第2个元素
 * @param _3
 *            Nullable，元组的第3个元素
 */
public class Tuple3<T1, T2, T3> extends Tuple2<T1, T2> {
	public Tuple3(T1 t_1, T2 t_2, T3 t_3) {
		super(t_1, t_2);
		this.t_3 = t_3;
	}

	public final T3 t_3;

	@Override
	public String toString() {
		return "(" + t_1 + "," + t_2 + "," + t_3 + ")";
	}
}
