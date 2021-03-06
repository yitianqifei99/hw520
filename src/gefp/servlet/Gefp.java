package gefp.servlet;

import gefp.models.Checkpoint;
import gefp.models.CheckpointManager;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/gefp", loadOnStartup = 1)
public class Gefp extends HttpServlet
{
    private static String[] runways = new String[]{"Academics", "Career Preparation", "Leadership and Community Engagement"};

    private static String homePath;

    @Override
    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);

        config.getServletContext().setAttribute("runways", runways);

        if (config.getServletContext().getRealPath("/").contains("/HW/")) {
            homePath = "/";
        } else {
            homePath = "http://cs3.calstatela.edu:8080/cs520stu40/";
        }

        config.getServletContext().setAttribute("homePath", homePath);

//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            throw new ServletException(e);
//        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        CheckpointManager manager = new CheckpointManager(request.getSession().getAttribute("checkpoints"));

        request.setAttribute("manager", manager);
        request.getRequestDispatcher("/WEB-INF/gefp/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    }

    public static boolean isEmpty(String string)
    {
        return string == null || string.trim().length() == 0;
    }

    public static String getHomePath()
    {
        return homePath;
    }



}
