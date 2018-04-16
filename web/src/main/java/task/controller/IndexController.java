package task.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import task.dao.impl.LineDaoHibernate;
import task.model.Line;


@Controller
public class IndexController {

    private LineDaoHibernate dao;

    public IndexController(LineDaoHibernate dao) {
        this.dao = dao;
    }

    @GetMapping("/index")
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Line> lineDtos = dao.findAll();
        modelAndView.addObject("lineDtos",lineDtos);
        return modelAndView;
    }
}
