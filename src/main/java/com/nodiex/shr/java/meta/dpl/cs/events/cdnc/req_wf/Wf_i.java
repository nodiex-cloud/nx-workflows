package com.nodiex.shr.java.meta.dpl.cs.events.cdnc.req_wf;

import com.uber.cadence.workflow.WorkflowMethod;
import com.nodiex.shr.java.req.Req;
import com.nodiex.shr.java.Result;
import com.nodiex.shr.java.meta.dpl.cs.events.cdnc.Wf_run_i;

public interface Wf_i extends Wf_run_i {
    @WorkflowMethod(taskList=Req_wf_p.Task_list,executionStartToCloseTimeoutSeconds = 180)
    public Result run(Req req);
}
