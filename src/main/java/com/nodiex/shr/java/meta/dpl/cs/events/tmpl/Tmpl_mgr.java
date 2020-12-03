package com.nodiex.shr.java.meta.dpl.cs.events.tmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.nodiex.shr.java.meta.dpl.cs.events.tmpl.req_wf.Req_wf_p;
import com.nodiex.shr.java.T;
@Component
public class Tmpl_mgr {
	@Autowired
	public Tmpl_svc svc;
	public void run_t() {
		if(svc.st==0) {
			return;
		}
		wfps_run_t();
	}
	public void run_f() {
		if(svc.st==0) {
			return;
		}
		wfps_run_f();
	}
	/**
	workflow packages run true
	*/
	public void wfps_run_t() {
		req_wf_run_t();
	}
	public void wfps_run_f() {
		//todo implement lifecycle of removing wfps
	}
	public void req_wf_run_t() {
		T.t("req_wf_run_t");
		Req_wf_p wfp=null;
		wfp=new Req_wf_p();
		svc.wfps_add(wfp);
	}
}