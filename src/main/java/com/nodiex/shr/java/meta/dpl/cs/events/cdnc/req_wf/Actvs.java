package com.nodiex.shr.java.meta.dpl.cs.events.cdnc.req_wf;

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
    /*
    @Override
    public Post post_get(long post_id) {
        T.t("post_get post_id: "+post_id,"req_wf");
    }
    @Override
    public Result post_updt() {
        Result res=new Result();
        Req req=new Req();
        req.exec_type="rs";
        req.s="Gen";
        req.a="post_updt";
        req.b_init();
        HashMap<String,Object> post_b=new HashMap<String,Object>();
        req.b.put("post",post_b);
        T.t("post.id:"+post.id,"req_wf");
        post_b.put("id",post.id);
        post_b.put("class_name","clm.d.app.unet.Post");
        HashMap<String,Object> props=new HashMap<String,Object>();
        post_b.put("props",props);
        prds.send("req",req);
        return res;
    }
    */
}
