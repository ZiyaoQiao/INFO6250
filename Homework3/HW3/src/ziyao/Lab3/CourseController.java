package Lab3;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@Controller
public class CourseController extends AbstractController {

    List<Course> courseList;
    //Global object belongs to every users.
    //Be careful, do not put anything here that you don't want to share.
    //Later this will come from the database.

    public CourseController() {
        //This method will only be call for once
        courseList = new ArrayList<>();
        Course c1 = new Course();
        c1.setCourseDescription("java programming");
        c1.setCrn("36099");
        c1.setInstructor("Khaled M. Bugrara");
        c1.setName("AED");

        Course c2 = new Course();
        c2.setCourseDescription("Course fro learning web technologies used in frint end");
        c2.setCrn("37913");
        c2.setInstructor("YusufOzbek");
        c2.setName("Web Dsign and user exp");

        Course c3 = new Course();
        c3.setCourseDescription("course for learning algorithms");
        c3.setCrn("34267");
        c3.setInstructor("Khaled M. Bugrara");
        c3.setName("Program Structure and Algorithms");

        Course c4 = new Course();
        c4.setCourseDescription("course for learning java EE");
        c4.setCrn("31606");
        c4.setInstructor("YusufOzbek");
        c4.setName("Web Tools");

        courseList.add(c1);
        courseList.add(c2);
        courseList.add(c3);
        courseList.add(c4);

    }

    HashSet<Course> mycourses;

    @RequestMapping("viewMyCourses.do")
    protected ModelAndView viewMyCourses(HttpServletRequest request, HttpServletResponse response){
        return new ModelAndView("mycourses");
    }

    @RequestMapping("course.do")
    protected ModelAndView processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //We are using one servlet for multiple things.
        //action is the url parameter to differentiate between different requests
        String action = request.getParameter("action");

        //this session will only be created when the user logs in. Otherwise do not create it.
        HttpSession session = request.getSession();

        if(session.getAttribute("myCourseSet") != null){
            mycourses = (HashSet<Course>) session.getAttribute("myCourseSet");
        }else{
            mycourses = new HashSet<>();
        }
        if (action.equals("add")) {

            String[] crn = request.getParameterValues("crn");
            if(crn == null)
                return new ModelAndView("mycourses");
            for(String coursecrn : crn){
                for(Course course:courseList){
                    if(course.getCrn().equals(coursecrn)){
                        mycourses.add(course);
                    }
                }
            }
            session.setAttribute("myCourseSet",mycourses);
            return new ModelAndView("mycourses");

        } else if (action.equals("search")) {

            String searchType = request.getParameter("searchType");
            String searchQuery = request.getParameter("query");

            ArrayList<Course> searchResults = new ArrayList<>();
            if(searchType.equals("crn")){
                for(Course course: courseList){
                    if(course.getCrn().equals(searchQuery)){
                        searchResults.add(course);
                    }
                }
            }else if(searchType.equals("title")){
                for(Course course:courseList){
                    if(course.getCourseDescription().contains(searchQuery)){
                        searchResults.add(course);
                    }
                }
            }
            session.setAttribute("searchResults",searchResults);

            return new ModelAndView("courseview");

        } else if(action.equals("remove")) {
           //To be completed by students as part of Lab HW
            String crn = request.getParameter("crn");
            Iterator iter = mycourses.iterator();
            while(iter.hasNext()){
                Course tmp = (Course)iter.next();
                if(tmp.getCrn().equals(crn))
                    iter.remove();
            }
            session.setAttribute("myCourseSet",mycourses);
            return new ModelAndView("mycourses");
        }
        return null;
    }


    @RequestMapping("searchCourse.do")
        protected ModelAndView directToSearchCourse(HttpServletRequest request, HttpServletResponse response){
            return new ModelAndView("searchCourse");
        }

        @Override
        protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
            processRequest(httpServletRequest,httpServletResponse);
            return new ModelAndView("courseview","courseSet",mycourses);
    }
}
