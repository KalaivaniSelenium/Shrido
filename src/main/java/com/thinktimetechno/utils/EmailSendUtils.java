package com.thinktimetechno.utils;

import com.thinktimetechno.constants.FrameworkConstants;
import com.thinktimetechno.mail.EmailAttachmentsSender;
import com.thinktimetechno.utils.FailedApiTracker.FailedAPI;

import javax.mail.MessagingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.thinktimetechno.mail.EmailConfig.*;


public class EmailSendUtils {

    private EmailSendUtils() {
        super();
    }


    public static void sendEmail(int total, int passed, List<FailedAPI> failedList) {
        if (FrameworkConstants.SEND_EMAIL_TO_USERS.trim().equalsIgnoreCase(FrameworkConstants.YES)) {
            System.out.println("****************************************");
            System.out.println("Send Email - START");
            System.out.println("****************************************");

            System.out.println("File name: " + FrameworkConstants.getExtentReportFilePath());

            String messageBody = buildApiExecutionSummary(total, passed, failedList);
            String attachmentFile = FrameworkConstants.getExtentReportFilePath();

            try {
                EmailAttachmentsSender.sendEmailWithAttachments(
                        SERVER, PORT, FROM, PASSWORD, TO, SUBJECT, messageBody, attachmentFile);
                System.out.println("Email sent successfully.");
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            
            
            System.out.println("Send Email - END");
            FailedApiTracker.clearFailures(); // Clear list for next run
            System.out.println("****************************************");
            
        }
    }

    

    private static String buildApiExecutionSummary(int total, int passed, List<FailedAPI> failedList) {
    	int failed = failedList.size();
    	double failPercent = ((double) failed / total) * 100;

        // Failed APIs Table
        StringBuilder failedApiTable = new StringBuilder();
        if (!failedList.isEmpty()) {
            failedApiTable.append("<h3 style='color:#4682B4; font-size:15px;'>Failed APIs</h3>") // Ink Blue Heading
                    .append("<table style='border-collapse: collapse; width: 60%; margin-bottom:15px;'>") // Added space below
                    .append("<tr style='background-color:black; color:#FFD700; text-align:center;'>") // Black bg + Gold text
                    .append("<th style='border: 1px solid #ccc; padding: 8px; text-align:center;'>API Name</th>")
                    .append("<th style='border: 1px solid #ccc; padding: 8px; text-align:center; width: 150px;'>Status Code</th>")
                    .append("</tr>");

            for (FailedAPI api : failedList) {
                failedApiTable.append("<tr>")
                        .append("<td style='border: 1px solid #ccc; padding: 8px; text-align:center;'>").append(api.name).append("</td>")
                        .append("<td style='border: 1px solid #ccc; padding: 8px; text-align:center;'>").append(api.statusCode).append("</td>")
                        .append("</tr>");
            }

            failedApiTable.append("</table>");
        }

        String executionDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' hh:mm a"));
        String companyName = "ThinkTime Automation Team";
        // Full HTML message
        return "<html><body style='font-family:Arial,sans-serif;'>"
                + "<p>Hi Team,</p>"
                + "<p>Please find below the execution summary of the recent <strong>API testing:</strong></p>"
                
                // Application details
                + "<p><strong>Application Name:</strong> Shrido </p>"
                //+ "<p><strong>Application URL:</strong> <a href='https://cpraedcourse.com' style='color:#1E90FF;'>https://cpraedcourse.com</a></p>"
                + "<p><strong>Execution Date & Time:</strong> " + executionDate + "</p>"

                // Execution Summary Heading
                + "<h3 style='color:#4682B4; font-size:15px;'>Execution Summary</h3>"
                + "<table style='border-collapse: collapse; width: 40%; text-align:center;'>"
                + "<tr style='background-color:black; color:#FFD700;'>"
                + "<th style='border: 1px solid #ccc; padding: 8px; text-align:center;'>Total</th>"
                + "<th style='border: 1px solid #ccc; padding: 8px; text-align:center;'>Passed</th>"
                + "<th style='border: 1px solid #ccc; padding: 8px; text-align:center;'>Failed</th>"
                + "</tr>"
                + "<tr>"
                + "<td style='border: 1px solid #ccc; padding: 8px; text-align:center;'>" + total + "</td>"
                + "<td style='border: 1px solid #ccc; padding: 8px; text-align:center; color:green;'>" + passed + "</td>"
                + "<td style='border: 1px solid #ccc; padding: 8px; text-align:center; color:red;'>" + failed + "</td>"
                + "</tr>"
                + "</table>"

                // Failure percentage (modified note)
                + "<p style='margin-top:10px;'><strong>" + String.format("%.0f", failPercent)
                + "% of the APIs failed during testing.</strong></p>"

                // Failed APIs Table
                + failedApiTable.toString()

                // Observations Heading
                + "<h3 style='color:#4682B4; font-size:15px;'>Observations</h3>"
                + "<ul>"
                + "<li>Multiple APIs are returning <strong>500 errors</strong>.</li>"
                + "<li>Some are returning <strong>400</strong> even with valid input.</li>"
                + "<li>Needs validation on <strong>request handling</strong> and <strong>error messaging</strong>.</li>"
                + "</ul>"

                // Replaced footer message
                + "<p>Please download the attached HTML report to access detailed test results.</p>"
                + "<p>Best regards,<br/>" + companyName + ".<br/>"
				+ "<a href='https://thinktime.in/' style='color:#1E90FF;'>www.thinktime.in</a></p>" + "</body></html>";
    }
}

