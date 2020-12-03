package com.nodiex.shr.java.meta.dpl.cs.events.tmpl.req_wf;

import io.temporal.activity.ActivityMethod;
import com.nodiex.shr.java.req.Req;
import com.nodiex.shr.java.Result;
import io.temporal.activity.ActivityInterface;
@ActivityInterface
public interface Actvs_i {
	//(scheduleToCloseTimeoutSeconds = 180)
	@ActivityMethod
	public Result req_exec(Req req);
}
