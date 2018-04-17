package task.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import task.converter.LineDtosConverter;
import task.dao.EntityDao;
import task.dao.impl.DaoFactoryHiberImpl;
import task.dto.LineDto;
import task.model.Line;
import task.service.ParseFile;


@Controller
public class IndexController {

    private LineDtosConverter dtoConverter;

    @Autowired
    public IndexController(LineDtosConverter dtoConverter) {
        this.dtoConverter = dtoConverter;
    }

    @GetMapping({"/", "/index"})
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("index");
        DaoFactoryHiberImpl factory = new DaoFactoryHiberImpl();
        List<Line> lines = new ParseFile().openFile();
        EntityDao<Line> lineDao = factory.getLineDao();
        lineDao.addAllLines(lines);
        List<Line> lineList = lineDao.findAll();
        List<LineDto> lineDtos = dtoConverter.convert(lineList);
        modelAndView.addObject("lineDtos", lineDtos);
        return modelAndView;
    }
}
