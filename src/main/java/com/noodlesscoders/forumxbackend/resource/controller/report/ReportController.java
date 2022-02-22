package com.noodlesscoders.forumxbackend.resource.controller.report;

import com.noodlesscoders.forumxbackend.api.report.ReportAPI;
import com.noodlesscoders.forumxbackend.api.report.bean.NoContentException;
import com.noodlesscoders.forumxbackend.resource.controller.report.bean.ReportIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportAPI reportAPI;

    @GetMapping
    public String report(Model model) {
        model.addAttribute("report", new ReportIO());
        model.addAttribute("errorStatus", false);
        return "report";
    }

    @PostMapping
    public String report(@ModelAttribute("report") ReportIO report, Model model) {
        try {
            reportAPI.sendReport(report);
        } catch (NoContentException e) {
            model.addAttribute("errorStatus", true);
            model.addAttribute("errorMessage", e.getMessage());
            return "report";
        }
        return "report_succes";
    }
}
