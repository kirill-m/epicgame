package frontend;

import main.AccountService;
import main.UserProfile;
import org.jetbrains.annotations.NotNull;
import templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class SignInServlet extends HttpServlet {
    private AccountService accountService;

    public SignInServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        response.setStatus(HttpServletResponse.SC_OK);

        Map<String, Object> pageVariables = new HashMap<>();

        response.getWriter().println(PageGenerator.getPage("signin.html", pageVariables));
    }

    @Override public void doPost(@NotNull HttpServletRequest request,
                        @NotNull HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");


        response.setStatus(HttpServletResponse.SC_OK);
        Map<String, Object> pageVariables = new HashMap<>();

        UserProfile profile = accountService.getUser(name);
        String sessionCurrent = request.getSession().getId();

        if (accountService.isSignedIn(sessionCurrent) == null)
        {
            if (profile != null && profile.getPassword().equals(password)) {
                accountService.addSessions(String.valueOf(sessionCurrent), profile);
                pageVariables.put("loginStatus", "user " + name + " Login passed");
                pageVariables.put("isLogin",1);
            } else {
                pageVariables.put("loginStatus", "Wrong login/password");
                pageVariables.put("isLogin",0);
            }
        } else {
            pageVariables.put("isLogin",1);
            pageVariables.put("loginStatus", "You are already logged in");
        }
            response.getWriter().println(PageGenerator.getPage("authstatus.html", pageVariables));
    }
}
