package io.tracein.exporter;

import com.google.protobuf.InvalidProtocolBufferException;
import io.opentelemetry.proto.collector.trace.v1.ExportTraceServiceRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExportApi {
    @RequestMapping(value = "/v1/traces", consumes = {"application/x-protobuf"})
    public void receiveTraceData(@RequestBody byte[] data) throws InvalidProtocolBufferException {
        ExportTraceServiceRequest res = ExportTraceServiceRequest.parseFrom(data);
        System.out.println("Received data: " + res);
    }
}
