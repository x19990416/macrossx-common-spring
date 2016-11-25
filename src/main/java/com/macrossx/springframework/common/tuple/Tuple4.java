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
	public Tuple4(T1 _1, T2 _2, T3 _3, T4 _4) {
		super(_1, _2, _3);
		this._4 = _4;
	}

	public final T4 _4;

	@Override
	public String toString() {
		return "(" + _1 + "," + _2 + "," + _3 + "," + _4 + ")";
	}
}
