package com.nodiex.shr.java.req;
import com.nodiex.shr.java.Ser;
public class Res {
	public Object b;
	@Override 
	public String toString() {
		return Ser.sSer(this);
	}
}
