package com.noodlesscoders.forumxbackend.resource.controller.report;

import com.noodlesscoders.forumxbackend.api.report.ReportAPI;
import com.noodlesscoders.forumxbackend.api.report.bean.NoContentException;
import com.noodlesscoders.forumxbackend.resource.controller.ErrorIO;
import com.noodlesscoders.forumxbackend.resource.controller.report.bean.ReportIO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/report")
public class ReportController {

    private final Logger logger = LoggerFactory.getLogger(ReportController.class);

    @Autowired
    private ReportAPI reportAPI;

    @GetMapping
    public String report(Model model) {
        model.addAttribute("report", new ReportIO());
        model.addAttribute("error", new ErrorIO(false));
        return "report";
    }

    @PostMapping
    public String report(@ModelAttribute("report") ReportIO report, Model model) {
        try {
            reportAPI.sendReport(report);
        } catch (NoContentException e) {
            logger.error(UUID.randomUUID() + ": error with report: " + report + " Message: " + e.getMessage());
            model.addAttribute("error", new ErrorIO(true, e.getMessage()));
            return "report";
        }
        return "report_success";
    }
}
