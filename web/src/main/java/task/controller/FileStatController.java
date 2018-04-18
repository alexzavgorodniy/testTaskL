package task.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import task.converter.LineDtosConverter;
import task.dao.impl.FilesDaoHibernate;
import task.dao.impl.LineDaoHibernate;
import task.dto.LineDto;
import task.model.Line;
import task.model.ReadFile;

@Controller
public class FileStatController {

    private LineDtosConverter dtoConverter;

    @Autowired
    public FileStatController(LineDtosConverter dtoConverter) {
        this.dtoConverter = dtoConverter;
    }

    @GetMapping("/filestat/{id}")
    public ModelAndView show(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("filestat");
        ReadFile file = new FilesDaoHibernate().findOneByFileId(id);
        List<Line> allLinesByFileId = new LineDaoHibernate().findAllLinesByFileId(id);
        List<LineDto> lineDtos = dtoConverter.convert(allLinesByFileId);
        modelAndView.addObject("lineDtos", lineDtos);
        modelAndView.addObject("file", file);
        return modelAndView;
    }
}
