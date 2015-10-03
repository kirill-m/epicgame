package frontend;

import freemarker.template.TemplateException;
import main.AccountService;
import main.UserProfile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class SignUpServlet extends HttpServlet {
    private AccountService accountService;

    public SignUpServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override public void doGet( HttpServletRequest request,
                                HttpServletResponse response) throws ServletException, IOException {

        Map<String, Object> pageVariables = new HashMap<>();

        response.getWriter().println(PageGenerator.getPage("signup.html", pageVariables));
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @Override public void doPost(@NotNull HttpServletRequest request,
                       @NotNull HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        Map<String, Object> pageVariables = new HashMap<>();

        if (accountService.addUser(name, new UserProfile(name, password))) {
            pageVariables.put("signUpStatus", "New user created");
        } else {
            pageVariables.put("signUpStatus", "User with name: " + name + " already exists");
        }

        response.getWriter().println(PageGenerator.getPage("signupstatus.html", pageVariables));
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
