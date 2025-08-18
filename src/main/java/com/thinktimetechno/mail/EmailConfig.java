/*
 * Copyright (c) 2022.
 * Automation Framework Selenium - Anh Tester
 */

package com.thinktimetechno.mail;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.thinktimetechno.constants.FrameworkConstants;

/**
 * Data for Sending email after execution
 */
public class EmailConfig {
	public static String executionDateOnly = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")); // for subject
    //Nhớ tạo mật khẩu app (App Password) cho Gmail mới gửi được nhen
    //Nếu dùng mail của Hosting thì bình thường
    //Enable Override Report and Send mail in config file => src/test/resources/config/config.properties
    //OVERRIDE_REPORTS=yes
    //send_email_to_users=yes

    public static final String SERVER = "smtp.hostinger.com";
    public static final String PORT = "587";

    public static final String FROM = "priya@thinktime.in";
    public static final String PASSWORD = "Priya@2023";
   //"anushka@cpraedcourse.com","shankar@thinktime.in","sunnykumar@cpraedcourse.com","hieu@cpraedcourse.com","ranjan@learntastic.com"
    public static final String[] TO = {"kalai@thinktime.in"};
    public static final String SUBJECT = FrameworkConstants.REPORT_TITLE + " | "+ executionDateOnly;
}
