package observer.design.pattern.controller;

import observer.design.pattern.Modal.Celebrity;
import observer.design.pattern.Modal.Fan;
import observer.design.pattern.data.SingletonSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    public MainController() {

    }

    @RequestMapping("/")
    private String home(Model model){
        System.out.println("inside /");
        return "home.jsp";
    }

    //---------------------CELEB-------------------
    @RequestMapping("/newCeleb")
    private String newCeleb(Model model){

        System.out.println("inside /newCeleb");
        System.out.println("Size ->> "+SingletonSource.getInstance().getCelebrities().size());
        return "newCeleb.jsp";
    }


    @RequestMapping("/celebLogin")
    private String celebLogin(Model model){
        System.out.println("inside /celebLogin");
        System.out.println("Size ->> "+SingletonSource.getInstance().getCelebrities().size());
        return "celebLogin.jsp";
    }

    @RequestMapping("/newMessage")
    private String newMessage(Model model, HttpServletRequest request){
        System.out.println("inside /newMessage");

        HttpSession session = request.getSession();
        Celebrity c = (Celebrity) session.getAttribute("celebSession");
        c.addMessages(request.getParameter("msg"));
        c.notifyAllObservers();

        model.addAttribute("celeb", c);

        return "celebHome.jsp";
    }

    @RequestMapping("/celebLogout")
    private String celebLogout(Model model, HttpServletRequest request){
        System.out.println("inside /celebLogout");

        HttpSession session = request.getSession();
        session.setAttribute("celebSession", null);

        return "home.jsp";
    }

    @RequestMapping("/celebLoginSubmit")
    private String celebLogin_submit(Model model, HttpServletRequest request){
        System.out.println("inside /celebLoginSubmit");
        System.out.println("Size ->> "+SingletonSource.getInstance().getCelebrities().size());


        Celebrity celebrity = new Celebrity();
        celebrity.setfName(request.getParameter("fName"));
        celebrity.setlName(request.getParameter("lName"));
        List<Celebrity> celebs = SingletonSource.getInstance().getCelebrities();
        for(Celebrity c: celebs){
            String name = c.getfName()+c.getlName();
            String cName = celebrity.getfName()+celebrity.getlName();
            if(name.equalsIgnoreCase(cName)){
                HttpSession session = request.getSession(true);
                session.setAttribute("celebSession", c);
                System.out.println("FansCount -> "+c.getFans().size());
                return "celebHome.jsp";
            }
        }
        return "home.jsp";
    }

    @RequestMapping("/registerCeleb")
    private String registerCeleb(Model model, HttpServletRequest request){

        System.out.println("inside /registerCeleb");
        System.out.println("Size ->> "+SingletonSource.getInstance().getCelebrities().size());

        Celebrity celebrity = new Celebrity();
        celebrity.setfName(request.getParameter("fName"));
        celebrity.setlName(request.getParameter("lName"));
        SingletonSource.getInstance().addCeleb(celebrity);
        System.out.println("Size ->> "+SingletonSource.getInstance().getCelebrities().size());

        HttpSession session = request.getSession(true);
        session.setAttribute("celebSession", celebrity);
        return "celebHome.jsp";
    }

    //---------------------FAN-------------------

    @RequestMapping("/newFan")
    private String newFan(Model model){
        System.out.println("inside /newFan");
        return "newFan.jsp";
    }

    @RequestMapping("/fanLogin")
    private String fanLogin(Model model){
        System.out.println("inside /fanLogin");
        return "fanLogin.jsp";
    }

    @RequestMapping("/fanLoginSubmit")
    private String fanLogin_submit(Model model, HttpServletRequest request){
        System.out.println("inside /fanLoginSubmit");
        System.out.println("Size ->> "+SingletonSource.getInstance().getFans().size());

        Fan fan = new Fan();
        fan.setfName(request.getParameter("fName"));
        fan.setlName(request.getParameter("lName"));
        List<Fan> fans = SingletonSource.getInstance().getFans();
        for(Fan f: fans){
            String name = f.getfName()+f.getlName();
            String fanName = fan.getfName()+fan.getlName();
            if(name.equalsIgnoreCase(fanName)){
                HttpSession session = request.getSession();
                session.setAttribute("fanSession", fan);
                model.addAttribute("celebs", SingletonSource.getInstance().getCelebrities());
                return "fanHome.jsp";
            }
        }
        return "home.jsp";
    }

    @RequestMapping("/registerFan")
    private String registerFan(Model model, HttpServletRequest request){
        System.out.println("inside /registerFan");
        System.out.println("Size ->> "+SingletonSource.getInstance().getFans().size());

        Fan fan = new Fan();
        fan.setfName(request.getParameter("fName"));
        fan.setlName(request.getParameter("lName"));
        SingletonSource.getInstance().addFan(fan);
        System.out.println("FanSize ->> "+SingletonSource.getInstance().getFans().size());
        System.out.println("CelebSize ->> "+SingletonSource.getInstance().getCelebrities().size());

        HttpSession session = request.getSession();
        session.setAttribute("fanSession", fan);
        model.addAttribute("celebs", SingletonSource.getInstance().getCelebrities());

        return "fanHome.jsp";
    }
    @RequestMapping("/fanLogout")
    private String fanLogout(Model model, HttpServletRequest request){
        System.out.println("inside /fanLogout");
        System.out.println("Size ->> "+SingletonSource.getInstance().getFans().size());

        HttpSession session = request.getSession();
        session.setAttribute("fanSession", null);

        return "home.jsp";
    }

    @RequestMapping("/follow")
    private String follow(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        Fan fan = (Fan) session.getAttribute("fanSession");

        String c = request.getParameter("celeb");

        List<Celebrity> celebs = SingletonSource.getInstance().getCelebrities();
        for(Celebrity celeb : celebs){
            String name = celeb.getfName()+celeb.getlName();
            if(name.equals(c)){
                celeb.register(fan);
                System.out.println(fan+" following "+c);
                model.addAttribute("name", name);
                model.addAttribute("following", true);
            }
        }
        model.addAttribute("celebs", celebs);
        return "fanHome.jsp";
    }
}
