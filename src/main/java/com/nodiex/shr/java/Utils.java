package com.nodiex.shr.java;
import java.io.InputStream;
import java.io.IOException;
import org.apache.commons.io.IOUtils;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.io.PrintWriter;
import java.io.StringWriter;
import com.nodiex.shr.java.req.Req;
import java.util.HashMap;
import com.nodiex.shr.java.Ser;
import com.nodiex.shr.java.Post;
public class Utils {
	public static void killHolderOfPort(int port) {
		final String how = "-KILL";
		try {
			Runtime.getRuntime().exec(new String[]{"sh", "-c", "lsof -i :" + port + " -t | xargs kill " + how});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	 * todo: get global node_id
	 */
	public static String node_id() {
		return "n";
	}
	public static void he(Exception e) {
		T.t(e.toString());
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw));
		String exceptionAsString = sw.toString();
		T.t(exceptionAsString);
	}
	public static String is_to_str(InputStream is,String enc) {
		if(enc==null) {
			enc="UTF-8";
		}
		String r=null;
		try {
			r=IOUtils.toString(is,enc);
		} catch(Exception e) {
			he(e);
		}
		return r;
	}
	//url encode
	public static String ue(String v) {
		try {
			return URLEncoder.encode(v, StandardCharsets.UTF_8.toString());
		} catch(Exception e) {
			he(e);
			return null;
		}
	}
	public static Result task_crt(Req req) {
		Globals.prds.send("req",req);
		return new Result();
	}
	/**
	workflow instance run false
	*/
	public static Result wfi_run_f(Post p,boolean p_do_save) {
		Result res=null;
		Req req=new Req();
		req.exec_type="jvm";
		req.s="Tmpl";
		req.a="wfi_op";
		String wfp_hash=null;
		wfp_hash=p.type2;
		if(wfp_hash==null) {
			wfp_hash="req";
		}
		req.b_init();
		HashMap<String,Object> b=req.b;
		b.put("op","run_f");
		b.put("wfp_hash",wfp_hash);
		b.put("p",Long.toString(p.id));
		T.t(req.toString());
		res=task_crt(req);
		return res;
	}
	/**
	req workflow instance create
		create a workflow that executes a req synchronously, generally of exec_type:rs
	*/
	public static Result req_wfi_crt(Req wf_req,Post p,String cron_sch) {
		Req req=new Req();
		req.exec_type="jvm";
		req.s="Tmpl";
		req.a="wfi_op";
		String wfp_hash=null;
		wfp_hash="req";
		req.b_init();
		HashMap<String,Object> b=req.b;
		b.put("op","crt");
		b.put("wfp_hash",wfp_hash);
		b.put("wfi_id","p"+Long.toString(p.id));
		b.put("req",Ser.sSer(wf_req,"json"));
		if(cron_sch!=null) {
			b.put("cron_sch",cron_sch);
		}
		Result task_res=task_crt(req);
		return task_res;
	}
}
