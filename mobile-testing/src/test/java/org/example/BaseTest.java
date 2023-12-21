package org.example;

import org.example.app.pages.*;
import org.example.app.pages.auth.RegisterPage;
import org.example.app.pages.auth.SignInPage;
import org.example.app.pages.complaint.CreateComplaintPage;
import org.mockito.internal.matchers.Not;

public class BaseTest {
    public RegisterPage registerPage = new RegisterPage();

    public SignInPage signInPage = new SignInPage();

    public GovComplaintPage govComplaintPage = new GovComplaintPage();

    public DashboardPage dashboardPage = new DashboardPage();

    public FeedbackPage feedbackPage = new FeedbackPage();

    public NotificationPage notificationPage = new NotificationPage();

    public ProfilPage profilPage = new ProfilPage();

    public SearchPage searchPage = new SearchPage();

    public CreateComplaintPage createComplaintPage = new CreateComplaintPage();




}
