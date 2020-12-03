package com.nodiex.shr.java.meta.dpl.cs.events;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.nodiex.shr.java.App_base;
import com.nodiex.shr.java.T;
import com.nodiex.shr.java.Utils;
import com.nodiex.shr.java.Ser;
import com.nodiex.shr.java.meta.dpl.cs.events.cdnc.Cdnc_mgr;
import com.nodiex.shr.java.meta.dpl.cs.events.tmpl.Tmpl_mgr;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import com.nodiex.shr.java.req.Req_props;
import org.springframework.boot.SpringApplication;
import com.nodiex.shr.java.req.Req_info_mock;
import com.nodiex.shr.java.Globals;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
@Configuration
@EnableAutoConfiguration
@ComponentScan
@ImportResource("classpath:applicationContext.xml")
public class Consumer_app_base extends App_base {
	@Autowired
	public Cons_grp cons_grp;
	@Autowired
	public Prds_grp prds_grp;
	@Autowired
	public Cdnc_mgr cdnc_mgr;
	@Autowired
	public Tmpl_mgr tmpl_mgr;
	@Autowired
	public Req_props req_props;
	public Consumer_app_base() {
		super();
	}
	public void run_t() {
		T.t("run_t");
		T.t("rs_url:"+req_props.rs_url);
		cons_grp.run_t();
		prds_grp.run_t();
		cdnc_mgr.run_t();
		tmpl_mgr.run_t();
	}
	public void run_f() {
		T.t("run_f");
		cons_grp.run_f();
		prds_grp.run_f();
		cdnc_mgr.run_f();
		tmpl_mgr.run_f();
	}
}