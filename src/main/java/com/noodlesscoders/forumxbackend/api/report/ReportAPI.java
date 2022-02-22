package com.noodlesscoders.forumxbackend.api.report;

import com.noodlesscoders.forumxbackend.api.report.bean.NoContentException;
import com.noodlesscoders.forumxbackend.resource.controller.report.bean.ReportIO;

public interface ReportAPI {

    void sendReport(ReportIO report) throws NoContentException;

}
