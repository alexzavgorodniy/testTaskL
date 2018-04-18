package task.converter;

import java.util.ArrayList;
import java.util.List;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import task.dto.ReadFileDto;
import task.model.ReadFile;

@Component
public class ReadFileDtoConverter implements Converter<List<ReadFile>, List<ReadFileDto>> {

    @Override
    public List<ReadFileDto> convert(List<ReadFile> readFileList) {
        ArrayList<ReadFileDto> readFileDtos = new ArrayList<>();
        for (ReadFile readFile : readFileList) {
            ReadFileDto readFileDto = new ReadFileDto();
            readFileDto.setId(readFile.getId());
            readFileDto.setName(readFile.getName());
            readFileDto.setLineCount(readFile.getLineCount());
            readFileDtos.add(readFileDto);
        }
        return readFileDtos;
    }
}
