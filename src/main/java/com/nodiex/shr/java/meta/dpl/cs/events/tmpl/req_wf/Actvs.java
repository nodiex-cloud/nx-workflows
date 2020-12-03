package com.nodiex.shr.java.meta.dpl.cs.events.tmpl.req_wf;

import com.nodiex.shr.java.Post;
import com.nodiex.shr.java.Result;
import com.nodiex.shr.java.req.Req;
import com.nodiex.shr.java.req.Req_handler;
import com.nodiex.shr.java.T;
import java.util.HashMap;
import java.util.ArrayList;
import com.nodiex.shr.java.Globals;
import com.nodiex.shr.java.req.Req_handler;

public class Actvs implements Actvs_i {
    public Actvs() {
    }
    public Req_handler req_handler;
    @Override
    public Result req_exec(Req req) {
        req_handler=new Req_handler();
        T.t("Actvs.req_exec req: "+req.toString(),"req_wf");
        Result res=req_handler.req_exec(req);
        return res;
    }
}
