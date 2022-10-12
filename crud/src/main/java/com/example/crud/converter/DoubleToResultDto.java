package com.example.crud.converter;

import com.example.crud.dto.ResultDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DoubleToResultDto implements Converter<Double, ResultDto> {
    @Override
    public ResultDto convert(Double source) {
        ResultDto resultDto = new ResultDto();

        resultDto.setValue(source.toString());

        return resultDto;
    }
}
