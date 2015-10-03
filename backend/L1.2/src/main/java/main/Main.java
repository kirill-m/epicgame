package main;

import freemarker.template.TemplateException;
import frontend.AdminPageServlet;
import frontend.LogOutServlet;
import frontend.SignInServlet;
import frontend.SignUpServlet;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.servlet.Servlet;
import java.io.IOException;


public class Main {

    public static final int DEF_PORT = 8080;
    public static final int MAX_VALID_PORT = 49151;
    public static final int MIN_VALID_PORT = 1024;


    public static void main(@NotNull String[] args) throws Exception {
        int port = DEF_PORT;
        if (args.length == 1) {
            String portString = args[0];
            if ((Integer.valueOf(portString) >= MIN_VALID_PORT) && (Integer.valueOf(portString) <= MAX_VALID_PORT))
                port = Integer.valueOf(portString);
            else {
                System.out.append("Incorrect port, try again").append('\n');
                return;
            }
        }

        System.out.append("Starting at port: ").append(String.valueOf(port)).append('\n');

        AccountService accountService = new AccountService();

        Servlet signin = new SignInServlet(accountService);
        Servlet signUp = new SignUpServlet(accountService);
        Servlet logout = new LogOutServlet(accountService);
        Servlet admin = new AdminPageServlet(accountService);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(signin), "/api/v1/auth/signin");
        context.addServlet(new ServletHolder(signUp), "/api/v1/auth/signup");
        context.addServlet(new ServletHolder(logout), "/api/v1/auth/logout");
        context.addServlet(new ServletHolder(admin), "/admin");

        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setDirectoriesListed(true);
        resource_handler.setResourceBase("public_html");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resource_handler, context});

        Server server = new Server(port);
        server.setHandler(handlers);

        server.start();
        server.join();
    }
}