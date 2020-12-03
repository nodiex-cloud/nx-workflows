package com.nodiex.shr.java;
import com.nodiex.shr.java.Reqr;
import org.springframework.context.ConfigurableApplicationContext;
import com.nodiex.shr.java.meta.dpl.cs.events.Prds_grp;
public class Globals extends Object_g {
	public static ConfigurableApplicationContext spring_ctx;
	public static Prds_grp prds;
	public static void init() {
		Reqr.i=new Reqr();
	}
	public static void beans_init() {
		prds=spring_ctx.getBean(Prds_grp.class);
	}
}