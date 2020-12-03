package com.nodiex.shr.java.meta.dpl.cs.events.tmpl.req_wf;
import com.nodiex.shr.java.req.Req;
import io.temporal.workflow.Workflow;
import io.temporal.activity.ActivityOptions;
import java.time.Duration;
import com.nodiex.shr.java.Result;

public class Wf implements Wf_i {
    public final Actvs_i actvs=Workflow.newActivityStub(Actvs_i.class,ActivityOptions.newBuilder().setScheduleToCloseTimeout(Duration.ofMillis(180000)).build());
    public long post_id;
    @Override
    public Result run(Req req) {
        Result res=new Result();
        actvs.req_exec(req);
        return res;
    }
}