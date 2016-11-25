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
	public Tuple3(T1 _1, T2 _2, T3 _3) {
		super(_1, _2);
		this._3 = _3;
	}

	public final T3 _3;

	@Override
	public String toString() {
		return "(" + _1 + "," + _2 + "," + _3 + ")";
	}
}
