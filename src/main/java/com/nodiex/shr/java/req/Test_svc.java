package com.nodiex.shr.java.req;
import java.util.HashMap;
import com.nodiex.shr.java.req.Req_info;
import com.nodiex.shr.java.T;
import org.springframework.stereotype.Component;
import com.nodiex.shr.java.Result;
@Component
public class Test_svc {
	public void test(HashMap<String,Object> b,Req_info req_info) {
		T.t("test");
		req_info.r(new Result());
	}
}