package task.converter;

import java.util.ArrayList;
import java.util.List;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import task.dto.LineDto;
import task.model.Line;

@Component
public class LineDtosConverter implements Converter<List<Line>,List<LineDto>> {

    @Override
    public List<LineDto> convert(List<Line> lines) {
        ArrayList<LineDto> lineDtos = new ArrayList<>();
        for (Line line : lines) {
            LineDto lineDto = new LineDto();
            lineDto.setId(line.getId());
            lineDto.setTitle(line.getTitle());
            lineDto.setLongestWord(line.getLongestWord());
            lineDto.setShortestWord(line.getShortestWord());
            lineDto.setLineLength(line.getLineLength());
            lineDto.setAverageWordLength(line.getAverageWordLength());
            lineDtos.add(lineDto);
        }
        return lineDtos;
    }
}
