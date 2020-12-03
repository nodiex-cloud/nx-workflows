package com.nodiex.shr.java.meta.dpl.cs.events.cdnc.req_wf;

import com.uber.cadence.activity.ActivityMethod;
import com.nodiex.shr.java.req.Req;
import com.nodiex.shr.java.Result;

public interface Actvs_i {
    @ActivityMethod(scheduleToCloseTimeoutSeconds = 180)
    public Result req_exec(Req req);
    /*
    @ActivityMethod(scheduleToCloseTimeoutSeconds = 180)
    public Post post_get(long post_id);
    @ActivityMethod(scheduleToCloseTimeoutSeconds = 180)
    public Result post_updt();
    */
}
