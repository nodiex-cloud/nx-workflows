package com.nodiex.shr.java.meta.dpl.cs.events.cdnc.req_wf;
import com.nodiex.shr.java.req.Req;
import com.uber.cadence.workflow.Workflow;

import com.nodiex.shr.java.Result;

public class Wf implements Wf_i {
    public final Actvs_i actvs=Workflow.newActivityStub(Actvs_i.class);
    public long post_id;
    @Override
    public Result run(Req req) {
        Result res=new Result();
        actvs.req_exec(req);
        return res;
    }
}