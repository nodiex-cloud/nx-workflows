package com.nodiex.shr.java.meta.dpl.cs.events.tmpl.req_wf;
import java.util.HashMap;
import io.temporal.workflow.WorkflowMethod;
import io.temporal.workflow.WorkflowInterface;
import com.nodiex.shr.java.req.Req;
import com.nodiex.shr.java.Result;
import com.nodiex.shr.java.meta.dpl.cs.events.tmpl.Wf_run_i;
@WorkflowInterface
public interface Wf_i extends Wf_run_i {
	//@WorkflowMethod(taskList=Req_wf_p.Task_list,executionStartToCloseTimeoutSeconds = 180)
	@WorkflowMethod
	public Result run(Req req);
}
