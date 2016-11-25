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
	public Tuple2(T1 _1, T2 _2) {
		super(_1);
		this._2 = _2;
	}

	public final T2 _2;

	@Override
	public String toString() {
		return "(" + _1 + "," + _2 + ")";
	}

}
