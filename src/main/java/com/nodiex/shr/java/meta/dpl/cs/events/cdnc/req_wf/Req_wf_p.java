package com.nodiex.shr.java.meta.dpl.cs.events.cdnc.req_wf;
import com.nodiex.shr.java.meta.dpl.cs.events.cdnc.Wf_pack;
//req workflow package
public class Req_wf_p extends Wf_pack<Wf,Wf_i> {
    public static final String Task_list="req";
    public Req_wf_p() {
        super(
            "req",
            Req_wf_p.Task_list,
            Wf.class,
            Wf_i.class,
            new Actvs()
        );
    }
}