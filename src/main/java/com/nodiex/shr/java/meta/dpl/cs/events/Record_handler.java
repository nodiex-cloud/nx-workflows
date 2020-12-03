package com.nodiex.shr.java.meta.dpl.cs.events;
import com.nodiex.shr.java.req.Req;
import com.nodiex.shr.java.req.Req_handler;
import com.nodiex.shr.java.T;
import org.apache.kafka.clients.consumer.ConsumerRecord;
public class Record_handler implements Runnable {
	public Req_handler req_handler;
	public ConsumerRecord<String, Req> record;
	public Req req;
	public Record_handler(ConsumerRecord<String, Req> lrecord) {
		record=lrecord;
		T.t("Record_handler construct","events_con");
		req_handler=new Req_handler();
	}
	@Override
	public void run() {
		T.t("run","events_con");
		req=record.value();
		T.t("Record_handler.run k: "+record.key()+" v: "+req.toString(),"events_con");
		req_handler.req_exec(req);
	}
}