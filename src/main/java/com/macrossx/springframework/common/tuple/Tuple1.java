package com.macrossx.springframework.common.tuple;

/**
 * 1元组
 * 
 * @author starseeker.limin@gmail.com(X-Forever)
 *
 * @param _1 Nullable，元组的第一个元素
 */
public class Tuple1<T1> {
	public final T1 _1;

	public Tuple1(T1 _1) {
		this._1 = _1;
	}

	@Override
	public String toString() {
		return "("+_1+")"; 
	}
}
