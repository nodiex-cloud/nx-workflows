package com.nodiex.shr.java.req;

import com.nodiex.shr.java.Result;
import com.nodiex.shr.java.Ser;
import com.nodiex.shr.java.T;
import com.nodiex.shr.java.Reqr;
import com.nodiex.shr.java.Globals;
import com.nodiex.shr.java.Utils;
import java.util.HashMap;
import java.lang.reflect.Method;
import com.nodiex.shr.java.meta.dpl.cs.events.cdnc.Cdnc_svc;
import com.nodiex.shr.java.meta.dpl.cs.events.tmpl.Tmpl_svc;
import com.nodiex.shr.java.req.Test_svc;
public class Req_handler {
	public Req_info req_info;
	public Req req;
	public Res res;
	public Req_handler() {
		rs_url=Globals.spring_ctx.getBean(Req_props.class).rs_url;
		T.t("Req_handler rs_url:"+rs_url);
	}
	public String rs_url;
	public Result req_exec(Req lreq) {
		req=lreq;
		req_info=new Req_info();
		req_info.req=req;
		Result res=null;
		T.t("req_exec: "+req.toString(),"req");
		switch(req.exec_type) {
			case "grpc":
				break;
			case "rest"://req from a rest endpoint
				break;
			case "gql"://req from a graphql endpoint
				break;
			case "jvm":
			/*
			the reason for this existing is because there aren't cdnc clients for every language, namely haxe
			the reason why it isn't requested as jvm, is because it isn't clear how a cdnc request should always be handled
				inside of a events jvm, or a seperate cdnc_client service
			 */
			case "cdnc":
			case "tmpl":
			case "akka":
				res=req_exec_jvm();
				break;
			case "rs"://execute a blocking request against reqs_serv with a local multiplexor
				res=req_exec_rs();
				break;
			case "binary"://call a binary
				break;
		}
		//T.t(res.toString());
		return res;
	}
	public Result req_exec_binary() {
		Result res=new Result();

		return res;
	}
	public Result req_exec_rs() {
		Result res=new Result();
		StringBuffer s=new StringBuffer();
		s.append(rs_url);
		s.append("?un_ser=json&ser=json&r=");
		s.append(Utils.ue(Ser.sSer(req,"json")));
		String url=s.toString();
		T.t("req_exec_rs url:"+url,"req");
		String response_str=(String)Reqr.i.http(url);
		return res;
	}
	public Result req_exec_jvm() {
		T.t("req_exec_jvm","req");
		Result res=null;
		String svc_h=req.s;
		Class klass=null;
		Object svc=null;
		try {
		switch(svc_h) {
			case "Cdnc":
				klass=Cdnc_svc.class;
				break;
			case "Tmpl":
				klass=Tmpl_svc.class;
				break;
			case "Test":
				klass=Test_svc.class;
				break;
		}
		svc=Globals.spring_ctx.getBean(klass);
		Class[] args_types = new Class[2];
		args_types[0]=HashMap.class;
		args_types[1]=Req_info.class;
		Method method=klass.getMethod(req.a,args_types);
		method.invoke(svc,req.b,req_info);
		} catch(Exception e) {
		Utils.he(e);
		res=new Result(false);
		res.error_add("e","exception "+e.toString());
		res.info_init();
		//res.info.put("excp",e);
		return res;
		}
		res=(Result)req_info.res;
		return res;
	}
}