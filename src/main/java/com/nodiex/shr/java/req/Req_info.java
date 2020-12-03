package com.nodiex.shr.java.req;
import com.nodiex.shr.java.T;
public class Req_info {
    public Req req;
    public Object res;
    public boolean r_do_complete;
    public void Req_info() {
    	r_do_complete=true;
    }
    public void r(Object b) {
    	r(b,false);
    }
    public void r(Object b,boolean res_is_object) {
    	if(res_is_object) {
    		Res res=new Res();
    		res.b=b;
    		this.res=res;
    	} else {
    		res=b;
    	}
    	complete();
    }
    public void complete() {
    	T.t("complete","req");
    }
}
