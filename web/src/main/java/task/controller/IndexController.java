package task.controller;

import java.io.File;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import task.converter.ReadFileDtoConverter;
import task.dao.impl.FilesDaoHibernate;
import task.dto.ReadFileDto;
import task.model.ReadFile;
import task.service.FileSearching;


@Controller
public class IndexController {

    private ReadFileDtoConverter dtoConverter;

    @Autowired
    public IndexController(ReadFileDtoConverter dtoConverter) {
        this.dtoConverter = dtoConverter;
    }

    @GetMapping({"/", "index"})
    public ModelAndView showIndex() {
        ModelAndView modelAndView = new ModelAndView("index");
        FileSearching fileSearching = new FileSearching();
        fileSearching.processFilesFromFolder(new File(".././web/src/main/java/task/config"));
        List<ReadFile> allReadFiles = new FilesDaoHibernate().findAll();
        List<ReadFileDto> readFileDtos = dtoConverter.convert(allReadFiles);
        modelAndView.addObject("readFileDtos", readFileDtos);
        return modelAndView;
    }
}
