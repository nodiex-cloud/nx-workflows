package com.nodiex.shr.java;
/**
object generic
*/
public class Object_g {
	public String hash;
	public String name;
	public Long id;
	public String key;
	public boolean dbg;
	/**
	serialize class name
	*/
	public String ser_class_name;
	public boolean data_view_ser;
	public void ser_init() {
		data_view_ser=true;
		ser_class_name_init();
	}
	public void ser_class_name_init() {
	}
	@Override 
	public String toString() {
		return Ser.sSer(this);
	}
}
