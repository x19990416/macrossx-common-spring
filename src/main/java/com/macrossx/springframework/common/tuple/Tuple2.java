package com.macrossx.springframework.common.tuple;
/**
 * 2元组
 * 
 * @author starseeker.limin@gmail.com(X-Forever)
 *
 * @param _1
 *            Nullable，元组的第1个元素
 * @param _2
 *            Nullable，元组的第2个元素
 */
public class Tuple2<T1, T2> extends Tuple1<T1> {
	public Tuple2(T1 t_1, T2 t_2) {
		super(t_1);
		this.t_2 = t_2;
	}

	public final T2 t_2;

	@Override
	public String toString() {
		return "(" + t_1 + "," +t_2 + ")";
	}

}
